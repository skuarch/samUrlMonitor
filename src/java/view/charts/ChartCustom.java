package view.charts;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author skuarch
 */
public interface ChartCustom {
    
    public void createChart();
    public String getStringChart(HttpServletRequest request);    
    public void setData(double[] data);    
    public void setTitle(String title);    
    public void setTitleY(String titleY);    
    public void setTitleX(String titleX);    
    public void setLabels(String[] labels);    
    public int getFontAngle();    
    public void setFontAngle(int fontAngle);
    
} // end interface