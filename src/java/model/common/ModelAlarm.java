package model.common;

import java.util.ArrayList;
import model.beans.Alarm;
import model.dao.DAO;
import model.util.DateUtilities;

/**
 *
 * @author skuarch
 */
public class ModelAlarm {

    //==========================================================================
    /**
     * return an ArrayList<Alarm>.
     *
     * @return ArrayList<Alarm>
     */
    public static ArrayList<Alarm> getAlarms() throws Exception {

        ArrayList<Alarm> alarms = null;
        alarms = new DAO().getArrayList(new Alarm());
        
        if(alarms == null || alarms.size() < 1){
            alarms = new ArrayList<>();
        }
        
        return alarms;

    } //end getAlarms
    
    //==========================================================================
    public static ArrayList<Alarm> getCurrentAlarms() throws Exception{
    
        ArrayList<Alarm> alarms = null;
        alarms = (ArrayList<Alarm>) new DAO().hql("from Alarm a where date >= '" + DateUtilities.getCurrentDate() + "' order by a.date desc", new Alarm());
        
        if(alarms == null || alarms.size() < 1){
            alarms = new ArrayList<>();
        }
        
        return alarms;
        
    }
    
} // end class