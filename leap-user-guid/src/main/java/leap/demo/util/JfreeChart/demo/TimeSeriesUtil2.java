package leap.demo.util.JfreeChart.demo;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 * 时序图工具类，用于创建JFreeChart对象及时序图数据集合
 * 
 * @author Li Yong Qiang
 */
public class TimeSeriesUtil2 {
	/**
	 * 创建时序图数据集合
	 * 
	 * @return XYDataset
	 */
	public static XYDataset createDataset() {
		TimeSeries timeseries = new TimeSeries("Random Data");
		Day day = new Day(1, 1, 2009);
		double value = 35;
		// 添加一年365天的数据
		for (int i = 0; i < 365; i++) {
			double flag = Math.random();
			if(flag>0.5){
				value=value+Math.random()*1.5;
				
			}else{
				value=value-Math.random()*1.5;
			}
			timeseries.add(day, value);
			day = (Day) day.next();
		}
		// 返回数据集合对象
		return new TimeSeriesCollection(timeseries);
	}

	/**
	 * 创建JFreeChart对象
	 * 
	 * @return JFreeChart
	 */
	public static JFreeChart createChart() {
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 24)); // 设置标题字体
		standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 14)); // 设置图例的字体
		standardChartTheme.setLargeFont(new Font("宋体", Font.BOLD, 18)); // 设置轴向的字体
		ChartFactory.setChartTheme(standardChartTheme);// 设置主题样式
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				"国际原油价格走势图", 
				"", 
				"原油价格（单位：美元/桶）", 
				createDataset(), 
				false,
				false, 
				false);
		jfreechart.setBackgroundPaint(Color.ORANGE); // 设置背景色
		XYPlot xyplot = jfreechart.getXYPlot(); // 获取图表的绘制属性
		DateFormat format = new SimpleDateFormat("MM月份"); // 创建日期格式对象
		DateAxis domainAxis = new DateAxis("2009年统计月份"); // 创建时间轴对象		
		domainAxis.setDateFormatOverride(format);		
		domainAxis.setLowerMargin(0.0); // 设置图表空白
		domainAxis.setUpperMargin(0.0); // 设置图表空白
		xyplot.setDomainAxis(domainAxis); // 为绘图属性添加横轴对象
		return jfreechart;
	}
}
