package actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import view.charts.Line;

/**
 *
 * @author skuarch
 */
public class ChartBorrar extends ActionSupport {
    
    private String stringChart;
    private String image;

    //==========================================================================
    public ChartBorrar() {
    }

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String actionReturn = Action.SUCCESS;
        String[] labels = {"2010-10-10", "2010-10-11","2010-10-12"};
        double[] data = {3, 3,3};

        Line lineChart = new Line(1000, 1000);
        lineChart.setLabels(labels);
        lineChart.setData(data);
        lineChart.setTitleX("algo");
        lineChart.setTitleY("algo"); 
        lineChart.setTitleData("algo");
        lineChart.setFontAngle(75);
        lineChart.createChart();

        stringChart = lineChart.getStringChart(ServletActionContext.getRequest());
        image = ServletActionContext.getResponse().encodeURL("pages/application/getchart.jsp?" + stringChart);


        return actionReturn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
  
} // end class