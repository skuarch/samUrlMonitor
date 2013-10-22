package model.common;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.Alarm;
import model.beans.Task;
import model.dao.DAO;
import model.util.DateUtilities;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class TaskProccessor extends Thread {

    private static final Logger logger = Logger.getLogger(TaskProccessor.class);
    private Task task = null;
    private TimerTask timerTask = null;
    private Timer timer = null;
    private TaskProccessor me;
    private int failures = 0;
    private boolean sendNotificationFailure = false;

    //==========================================================================
    public TaskProccessor(Task task) {

        this.task = task;

    } // end TaskProccessor

    //==========================================================================
    @Override
    public void run() {
        setName(task.getName());
        runScheduler();
    } // end run

    //==========================================================================
    private synchronized void runScheduler() {

        me = this;

        timerTask = new TimerTask() {
            @Override
            public void run() {

                ConcurrentHashMap<String, TaskProccessor> hm = TaskContainer.getHm();
                System.out.println("taskContainer " + hm.size());
                System.out.println("running task: " + task.getName() + " " + task.getUrl());
                WrapperHTTPConnection whttpc = null;
                boolean isAlive = false;                

                try {

                    whttpc = new WrapperHTTPConnection();
                    isAlive = whttpc.existsWebsite(task.getUrl(), task.getMethod(), task.getTimeout());

                    if (!isAlive) {
                        
                        //is dead
                        
                        System.out.println("*****failures: " + failures + " trigger " + task.getTrigger());

                        if (failures >= task.getTrigger() -1) {

                            //create an alarm
                            Alarm alarm = new Alarm();
                            alarm.setLevel(3);
                            alarm.setTaskName(task.getName());
                            alarm.setUrl(task.getUrl());
                            alarm.setDescription("the website doesn't response " + task.getUrl());
                            alarm.setDate(DateUtilities.getCurrentDateTime());
                            task.setStatus(0);
                            new DAO().create(alarm);
                            new DAO().update(task);
                            
                            //here send the mail or sms                            
                            SendNotificationWrapper.sendNotification(task, alarm.getDescription());
                            BroadcastMessage.sendAlarm("the "+ task.getName() + " is down");
                            
                            
                            failures = 0;
                            sendNotificationFailure = true;

                        } else {
                            failures++;
                        }

                    } else {

                        //is alive
                        System.out.println("live:: " + sendNotificationFailure);
                        
                        if (sendNotificationFailure) {

                            //the failures should be continues
                            //if is alive and failures is more than 0 send mail
                            //with the message is alive
                            Alarm alarm = new Alarm();
                            alarm.setLevel(1);
                            alarm.setTaskName(task.getName());
                            alarm.setUrl(task.getUrl());
                            alarm.setDescription("the website " + task.getUrl() + " is running again");
                            alarm.setDate(DateUtilities.getCurrentDateTime());
                            new DAO().create(alarm);
                            task.setStatus(1);
                            new DAO().update(task);
                            SendNotificationWrapper.sendNotification(task, alarm.getDescription());                            
                            sendNotificationFailure = false;
                            BroadcastMessage.sendAlarm("the "+ task.getName() + " is up");

                        }
                        
                        failures = 0;

                    }


                } catch (Exception e) {
                    logger.error(task.getName(), e);
                }

            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, task.getPeriod() * 1000);

    } // end runScheduler

    //==========================================================================
    /**
     * stop the scheduler
     */
    public void stopScheduler() throws Exception {

        try {
            System.out.println("stopping scheduler: " + getName());
            timerTask.cancel();
            timer.purge();
            timer.cancel();
            interrupt();
            stop();
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("complete clean");
            timerTask = null;
            timer = null;
        }

    } // end stopScheduler
    //==========================================================================
    /*public Task getTask() {
     return task;
     }

     public void setTask(Task task) {
     this.task = task;
     }*/
} // end class