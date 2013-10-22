package actions.dashboard;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import model.beans.Alarm;
import model.common.ModelAlarm;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class Dashboard extends ActionSupport {

    private final static Logger logger = Logger.getLogger(Dashboard.class);
    private ArrayList<Alarm> alarms = null;
    private String image = null;
    private String stringChart = null;

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;
        double[] data = null;
        String[] labels = null;
        List list = null;
        String obj = null;
        ArrayList<String> arrayList = null;
        ArrayList<Long> arrayListData = null;


        try {

            /*arrayList = new ArrayList<String>();
            arrayListData = new ArrayList<Long>();
            list = new DAO().hql("Select date from Alarm a where a.date >= '" + DateUtilities.getCurrentDate() + "'", String.class);
            
            for (int i = 0; i < list.size(); i++) {                
                
                obj = (String)list.get(i);                                
                arrayList.add(obj);
                arrayListData.add(3L);

            }

            data = toPrimitiveLong(arrayListData);
            labels = arrayList.toArray(new String[arrayList.size()]);

            //ancho,alto
            Line lineChart = new Line(850,670);
            lineChart.setLabels(labels);
            lineChart.setData(data);
            lineChart.setTitleX("");
            lineChart.setTitleY("Level");
            lineChart.setTitleData("Alarms");
            lineChart.setFontAngle(75);
            lineChart.createChart();

            stringChart = lineChart.getStringChart(ServletActionContext.getRequest());
            image = ServletActionContext.getResponse().encodeURL("pages/application/getchart.jsp?" + stringChart);*/            

            alarms = ModelAlarm.getCurrentAlarms();            

        } catch (Exception e) {
            logger.error("dashboard", e);
        }

        return actionReturn;

    } // end execute  

    //==========================================================================
    public ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }   
    

    //==========================================================================
    public static double[] toPrimitiveLong(ArrayList<Long> arrayList) {
        if (arrayList == null) {
            return null;
        } else if (arrayList.size() == 0) {
            return new double[0];
        }

        final double[] result = new double[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i).longValue();
        }
        return result;
    }
} // end class
