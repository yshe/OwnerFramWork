package leap.demo.util.JfreeChart.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
public class TimeSeriesUtil {
	private static XYDataset getDataset(){
		TimeSeriesCollection dataset = new TimeSeriesCollection(); 
		TimeSeries timeSeriesA = new TimeSeries("A股");
		TimeSeries timeSeriesB = new TimeSeries("B股");
		TimeSeries timeSeriesC = new TimeSeries("C股");
		for(int i=1;i<=12;i++){
			timeSeriesA.add(new Month(i,2010),new Random().nextDouble()*9);
			timeSeriesB.add(new Month(i,2010),new Random().nextDouble()*8);
			timeSeriesC.add(new Month(i,2010),new Random().nextDouble()*6);
		}
		dataset.addSeries(timeSeriesA);
		dataset.addSeries(timeSeriesB);
		dataset.addSeries(timeSeriesC);
		return dataset;
	}
	public static JFreeChart getTimeSeriesChart(){
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 24)); // 设置标题字体
		standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 14)); // 设置图例的字体
		standardChartTheme.setLargeFont(new Font("宋体", Font.BOLD, 18)); // 设置轴向的字体
		ChartFactory.setChartTheme(standardChartTheme);// 设置主题样式
		JFreeChart timeChart = ChartFactory.createTimeSeriesChart(
				"股票价格走势", 
				"月份", 
				"每股价格", getDataset(),
				true, 
				true, 
				false);
		//timeChart.setBackgroundPaint(Color.MAGENTA); // 设置背景色
		XYPlot plot = timeChart.getXYPlot();
		DateFormat format = new SimpleDateFormat("MM月份"); // 创建日期格式对象
		DateAxis domainAxis = new DateAxis("2010年统计月份"); // 创建时间轴对象
		DateTickUnit dtu = new DateTickUnit(DateTickUnit.DAY, 29, format);
		domainAxis.setTickUnit(dtu); // 设置横轴上的时间刻度的显示格式
		domainAxis.setLowerMargin(0.0); // 设置图表空白
		domainAxis.setUpperMargin(0.3); // 设置图表空白
		plot.setDomainAxis(domainAxis); // 为绘图属性添加横轴对象
		return timeChart;
	}
}
