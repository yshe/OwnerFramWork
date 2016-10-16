package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.date.SerialDate;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
/**
 * 时序图
 * @author yabushan
 *
 */
public class LineTimeChartUtil {
	
	private static XYDataset getDataset() {
		final TimeSeries s1 = new TimeSeries("JAVA图书");
		s1.add(new Month(1, 2010), 480);
		s1.add(new Month(2, 2010), 381);
		s1.add(new Month(3, 2010), 264);
		s1.add(new Month(4, 2010), 185);
		s1.add(new Month(5, 2010), 209);
		s1.add(new Month(6, 2010), 302);
		final TimeSeries s2 = new TimeSeries("VC图书");
		s2.add(new Month(1, 2010), 315);
		s2.add(new Month(2, 2010), 418);
		s2.add(new Month(3, 2010), 580);
		s2.add(new Month(4, 2010), 308);
		s2.add(new Month(5, 2010), 200);
		s2.add(new Month(6, 2010), 501);
		final TimeSeries s3 = new TimeSeries("VB图书");
		s3.add(new Month(1, 2010), 310);
		s3.add(new Month(2, 2010), 489);
		s3.add(new Month(3, 2010), 512);
		s3.add(new Month(4, 2010), 589);
		s3.add(new Month(5, 2010), 359);
		s3.add(new Month(6, 2010), 402);
		final TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		dataset.addSeries(s2);
		dataset.addSeries(s3);
		return dataset;
	}



	public static JFreeChart getJFreeChart() {
		XYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createTimeSeriesChart("2010年上半年销售量", // 图表标题
			"月份", 			// x轴标签
			"销售量（单位：本）",	// y轴标签
			dataset, 			// 数据集
			true, 				// 是否显示图例
			false, 				// 是否生成工具
			false 				// 是否生成URL链接
		);
		updateFont(chart);
		return chart;
	}

	public static void updateFont(JFreeChart chart) {
		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
		// 图表
		XYPlot xyPlot = chart.getXYPlot();
		ValueAxis domainyAxis = xyPlot.getDomainAxis();
		// X轴字体
		domainyAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		domainyAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		ValueAxis rangeAxis = xyPlot.getRangeAxis();
		// y轴字体
		rangeAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		rangeAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		
	
		DateAxis dateAxis=(DateAxis) xyPlot.getDomainAxis();
		//设置时间显示格式
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM"));
		/**
		 * 添加双时间轴
		 */
		//添加时间范围
		dateAxis.setRange(new Month(1,2010).getStart(),new Month(7,2010).getEnd());
		//设置时间表格
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MMM"));
		xyPlot.setDomainAxis(1,dateAxis);
		//设置时间轴位置
		xyPlot.setDomainAxisLocation(1,AxisLocation.BOTTOM_OR_LEFT);
		
		
		//显示十字标记
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		
		//添加Y轴标记
		ValueMarker marker=new ValueMarker(450.0);
		marker.setPaint(Color.orange);
		xyPlot.addRangeMarker(marker);
		
		
		//添加x轴标记
		Quarter quarter=new Quarter(2,2010);
		marker=new ValueMarker(quarter.getFirstMillisecond());
		marker.setPaint(Color.YELLOW);
		xyPlot.addDomainMarker(marker);
		
		//设置刻度线
			//设置单位
		final DateAxis dateAxis2=(DateAxis) xyPlot.getDomainAxis();
			//设置刻度单位
		dateAxis2.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH, 2,new SimpleDateFormat("yyyy-MMM")));
		
		
		//设置时间轴范围
		Day endDay = new Day(1,6,2010);
        SerialDate	 serialDate = SerialDate.addMonths(-5, endDay.getSerialDate());
		Day beginDay = new Day(serialDate.toDate());
		DateAxis axis = (DateAxis) chart.getXYPlot().getDomainAxis();
		//设置X轴开始结束位置
		axis.setRange(beginDay.getStart(), endDay.getEnd());
		
	}
}
