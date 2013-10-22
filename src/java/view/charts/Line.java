package view.charts;

import ChartDirector.Chart;
import ChartDirector.LineLayer;
import ChartDirector.XYChart;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author skuarch
 */
public class Line extends XYChart implements ChartCustom {

    private String title = "";
    private String titleY = "";
    private String titleX = "";
    private String titleData = "";
    private String[] labels = null;
    private double[] data = null;
    private int fontAngle = 0;

    //==========================================================================
    public Line(int height, int width) {
        super(height, width);
    } // end BarChart 

    //==========================================================================
    public Line(String title, int height, int width, double[] data, String[] labels) {
        super(height, width);
        this.title = title;
        this.data = data;
        this.labels = labels;
    } // end Line 

    //==========================================================================
    @Override
    public void createChart() {   
        
        Chart.setLicenseCode("DEVP-353Y-BPF3-395R-D4AA-C8C0");
        
        if (data == null) {
            throw new NullPointerException("data is null");
        }

        if (labels == null) {
            throw new NullPointerException("labels is null");
        }

        if (title == null) {
            throw new NullPointerException("title is null");
        }

        if (titleY == null) {
            throw new NullPointerException("titleY is null");
        }
        
        setPlotArea(55, 58, 740, 495, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
        addLegend(50, 30, false, "Arial Bold", 9).setBackground(Chart.Transparent);
        addTitle(title, "Arial Bold", 10);
        yAxis().setTitle(titleY);
        xAxis().setTitle(titleX);
        xAxis().setLabels(labels).setFontAngle(fontAngle);
        xAxis().setLabelStep(1);        
        LineLayer layer = addLineLayer2();
        layer.setLineWidth(2);
        layer.addDataSet(data, 0x000000, titleData);
        setBackground(0xcccccc);
    }

    //==========================================================================
    @Override
    public String getStringChart(HttpServletRequest request) {
        return this.makeSession(request, title + Math.random());
    }

    //==========================================================================
    @Override
    public void setData(double[] data) {
        this.data = data;
    }

    //==========================================================================
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    //==========================================================================
    @Override
    public void setTitleY(String titleY) {
        this.titleY = titleY;
    }

    //==========================================================================
    @Override
    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    //==========================================================================
    @Override
    public int getFontAngle() {
        return this.fontAngle;
    }

    //==========================================================================
    @Override
    public void setFontAngle(int fontAngle) {
        this.fontAngle = fontAngle;
    }

    //==========================================================================
    @Override
    public void setTitleX(String titleX) {
        this.titleX = titleX;
    }

    //==========================================================================
    public void setTitleData(String titleData) {
        this.titleData = titleData;
    }    
    
} // end class