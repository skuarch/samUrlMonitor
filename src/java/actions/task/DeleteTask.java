package actions.task;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import model.beans.Task;
import model.common.ModelTask;
import model.common.TaskContainer;
import model.common.TaskProccessor;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class DeleteTask extends ActionSupport {

    private static final Logger logger = Logger.getLogger(DeleteTask.class);
    private int id;
    private String message;

    //==========================================================================
    public DeleteTask() {
    } // end DeleteTask

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;
        Task task = null;
        TaskProccessor tp = null;

        try {

            if (id < 1) {
                message = getText("application.error");
            } else { 
                
                //delete and stop task                                
                task = ModelTask.getTask(id);                
                System.out.println("clean proccess for " + task.getName());                
                tp = TaskContainer.getTaskProccessor(task.getName());                
                tp.stopScheduler();
                tp.interrupt();
                
                TaskContainer.removeTaskProccessor(tp.getName());
                tp = null;
                ModelTask.removeTask(task);   
                task = null;
                
                message = getText("task.deleted");
            }

        } catch (Exception e) {
            logger.error("DeleteTask", e);
            message = getText("application.error");
        }

        return actionReturn;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
} // end class
