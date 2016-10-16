package leap.demo.util.JfreeChart.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
public class barDemo {
	
	private static CategoryDataset getDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=2006;i<=2010;i++){
			dataset.addValue(new Random().nextInt(3000), "ExtJs", i+"");
			dataset.addValue(new Random().nextInt(3000), "Dojo", i+"");
			dataset.addValue(new Random().nextInt(3000), "DWR", i+"");
			dataset.addValue(new Random().nextInt(3000), "prototype", i+"");
			dataset.addValue(new Random().nextInt(3000), "jQuery", i+"");
		}
		return dataset;
	}
	public static JFreeChart createChart(){
		  // 创建制图的主题样式
	    StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
	    // 设置轴向的字体
	    standardChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 16));
	    // 设置图例的字体
	    standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 16));
	    // 设置标题字体
	    standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 24));
	    ChartFactory.setChartTheme(standardChartTheme);//设置制图工厂使用主题
        // 创建效果图
        JFreeChart chart = ChartFactory.createBarChart(
                                   "某Ajax网站的框架年下载量", // 图表标题
                                   "", // 坐标标题
                                   "年下载量", // 坐标标题
                                   getDataset(), // 绘制数据
                                   PlotOrientation.VERTICAL, // 直方图的方向,竖向
                                   true, // 定义图表是否包含图例
                                   true, // 定义图表是否包含提示
                                   false); // 定义图表是否包含URL
        // 定义图框颜色
        chart.setBackgroundPaint(new Color(168, 219, 219));
        // 获得图表对象引用，自行设置绘制属性
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(219, 219, 127)); // 设置绘图区域背景色
        plot.setDomainGridlinePaint(Color.BLACK); // 设置垂直方向网格线的颜色
        plot.setDomainGridlinesVisible(false); // 设置垂直方向网格线是否显示
        plot.setRangeGridlinePaint(Color.RED); // 设置水平方向网格线的颜色
        plot.setRangeGridlinesVisible(true); // 设置水平方向网格线是否显示
        
        // 设置横轴标题文字的旋转方向
        CategoryAxis domainAxis = (CategoryAxis) plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createDownRotationLabelPositions(Math.PI /  // 文字顺时针旋转
                16.0) );// 文字旋转弧度，接受双精度参数
        // 结束自定义图表绘制的相关属性
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
       
        return chart;
	}
}
