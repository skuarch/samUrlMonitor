package actions.task;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import model.beans.Task;
import model.common.ModelTask;
import model.common.TaskContainer;
import model.common.TaskProccessor;
import model.common.WrapperHTTPConnection;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class CreateTask extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CreateTask.class);
    private Task task = null;
    private String name;
    private String url;
    private int trigger;
    private int timeout;
    private int period;
    private String method;
    private String message;
    private String email;
    private String sms;

    //==========================================================================
    public CreateTask() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;

        try {
            
            if(!url.contains("http://")){
                message = getText("task.no.protocol");
                return Action.SUCCESS;
            }            
            
            //check if the name of the task already exists
            if (ModelTask.existsTask(name)) {

                message = getText("task.exists");

            } else {

                //check if the website exists
                if (!new WrapperHTTPConnection().existsWebsite(url, method,timeout)) {
                    message = getText("task.no.connection");
                    return Action.SUCCESS;
                }

                //create the new task
                task = new Task();
                task.setName(name);
                task.setUrl(url);
                task.setTrigger(trigger);
                task.setTimeout(timeout);
                task.setPeriod(period);
                task.setMethod(method);
                task.setStatus(1);
                
                if(email == null || email.length() < 1){
                    task.setSms(sms);
                }else{
                    task.setEmail(email);
                }                

                //Schedule the task
                TaskProccessor tp = new TaskProccessor(task);
                tp.start();                                
                tp.setName(task.getName());

                ModelTask.createTask(task);
                message = getText("task.created");                
                
                //save the scheduler
                TaskContainer.addTaskProccessor(tp);
                System.out.println("task was created id= " + task.getId());
                
            }

        } catch (Exception e) {
            logger.error("CreateTask", e);
            message = getText("application.error");
        }

        return actionReturn;

    } // end execute

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTrigger() {
        return trigger;
    }

    public void setTrigger(int trigger) {
        this.trigger = trigger;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
    
} // end class
