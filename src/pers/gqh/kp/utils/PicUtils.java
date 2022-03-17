package pers.gqh.kp.utils;


import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Package pers.gqh.kp.utils
 * @Description
 * @Author Simple OR XXX
 * @Date 2022/3/17
 **/
public class PicUtils {

    public static void main(String[] args) throws IOException {

        scatterPlotPaint();
    }

    public static void scatterPlotPaint() throws IOException {
        double[][] a = {{1, 2, 3, 5, 6, 7, 8},
                {4, 5, 6, 7, 8, 9, 10}};

        DefaultXYDataset defaultXYDataset = new DefaultXYDataset();
        defaultXYDataset.addSeries(" ", a);
        JFreeChart chart = ChartFactory.createScatterPlot("", "Weight", "Value", defaultXYDataset,
                PlotOrientation.VERTICAL, true, true, false);//设置表头，x轴，y轴，name表示问题的类型
        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(Color.white);//设置背景面板颜色
        ValueAxis valueAxis = xyplot.getDomainAxis();
        valueAxis.setAxisLineStroke(new BasicStroke(1.0f));//设置坐标轴粗细

        //输出PNG文件
        OutputStream os_png = new FileOutputStream("D:/1.png");
        ChartUtilities.writeChartAsPNG(os_png, chart, 500, 500);

        //以面板显示
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 400));

        //创建一个主窗口来显示面板
        JFrame frame = new JFrame("散点图");
        frame.setLocation(500, 400);
        frame.setSize(600, 500);

        //将主窗口的内容面板设置为图表面板
        frame.setContentPane(chartPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);





    }


}
