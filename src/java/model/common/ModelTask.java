package model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.beans.Task;
import model.dao.DAO;

/**
 *
 * @author skuarch
 */
public class ModelTask {

    //==========================================================================
    private ModelTask() {
    }

    //==========================================================================
    public static long createTask(Task task) throws Exception {

        if (task == null) {
            new IllegalArgumentException("task is null");
        }

        return new DAO().create(task);

    } // end createTask

    //==========================================================================
    public static Task getTask(long id) throws Exception {

        if (id < 1) {
            new IllegalArgumentException("id is incorrect");
        }

        return new DAO().findById(id, new Task());

    } // end getTask

    //==========================================================================
    public static void removeTask(Task task) throws Exception {

        if (task == null) {
            new IllegalArgumentException("task is null");
        }

        new DAO().delete(task);

    } // end removeTask
    
    //==========================================================================
    /**
     * check if exists task in the DB.
     *
     * @param name String name of task
     * @return true if the task exists in the DB.
     * @throws Exception
     */
    public static boolean existsTask(String name) throws Exception {

        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("name is null opr empty");
        }

        boolean flag = false;
        List list = null;
        HashMap parameters = new HashMap();        
        parameters.put("name", name);
        list = new DAO().query("getTaskByName", parameters, new Task());

        if (list == null || list.size() < 1) {
            flag = false;
        } else {
            flag = true;
        }

        return flag;

    } // end existsTask
    
    //==========================================================================
    /**
     * return an ArrayList of Task.
     *
     * @return ArrayList<Task>
     */
    public static ArrayList<Task> getTasks() throws Exception {

        ArrayList<Task> arrayList = new DAO().getArrayList(new Task());
        return arrayList;

    } // end getTasks
} // end class