package actions.task;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import model.beans.Task;
import model.common.ModelTask;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class TaskTable extends ActionSupport{

    private static final Logger logger = Logger.getLogger(TaskTable.class);
    private ArrayList<Task> tasks = null;
    
    //==========================================================================
    public TaskTable() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {
        
        
        try {            
            
            tasks = ModelTask.getTasks();            
            
        } catch (Exception e) {            
            logger.error("TaskTable",e);
        }
        
        
        return super.execute(); //To change body of generated methods, choose Tools | Templates.
    } // end execute

    //==========================================================================
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }   
    
} // end class