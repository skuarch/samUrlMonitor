package model.common;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author skuarch
 */
public class TaskContainer {

    private static final ConcurrentHashMap<String, TaskProccessor> hm = new ConcurrentHashMap<>();

    //==========================================================================
    private TaskContainer() {
    }

    //==========================================================================
    public static void addTaskProccessor(TaskProccessor tp) {

        if (tp.getName() == null || tp.getName().length() < 1) {
            new IllegalArgumentException("taskProccessor doesn't have a name");
        }

        hm.put(tp.getName(), tp);

    } // end addTaskProccessor

    //==========================================================================
    public static void removeTaskProccessor(String name) {

        if (name == null || name.length() < 1) {
            new IllegalArgumentException("name is null or empty");
        }

        System.out.println("removing from container: " + name);
        hm.remove(name);

    } // end removeTaskProccessor

    //==========================================================================
    public static TaskProccessor getTaskProccessor(String name) {

        if (name == null || name.length() < 1) {
            new IllegalArgumentException("name is null or empty");
        }

        TaskProccessor tp = hm.get(name);
        
        System.out.println("returning: " + tp.getName());
        
        return tp;
    } // end getTaskProccessor

    
    //==========================================================================
    public static ConcurrentHashMap<String, TaskProccessor> getHm() {
        return hm;
    } 
    
    
} // end class