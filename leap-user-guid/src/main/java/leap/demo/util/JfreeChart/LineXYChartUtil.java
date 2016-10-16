package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.Font;
public class LineXYChartUtil {
	
	private static IntervalXYDataset getDataset() {
		final XYSeries series1 = new XYSeries("JAVA图书");
		final XYSeries series2 = new XYSeries("VC图书");
		final XYSeries series3 = new XYSeries("VB图书");
		series1.add(501, 3);
		series1.add(200, 2);
		series1.add(308, 2);
		series1.add(580, 4);
		series1.add(418, 2);
		series1.add(315, 1);
		series2.add(480, 2);
		series2.add(381, 3);
		series2.add(264, 1);
		series2.add(185, 2);
		series2.add(209, 2);
		series2.add(302, 2);
		series3.add(310, 2);
		series3.add(489, 2);
		series3.add(512, 3);
		series3.add(589, 4);
		series3.add(359, 2);
		series3.add(402, 2);
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		return dataset;
	}
	public static JFreeChart getJFreeChart() {
		IntervalXYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createXYLineChart("2010年上半年图书完成量", // 图表标题
		"完成页数", // x轴标签
		"人员数量", // y轴标签
		dataset, // 数据集
		PlotOrientation.VERTICAL, // 图表方向：水平、垂直
		true, // 是否显示图例
		false, // 是否生成工具
		false // 是否生成URL链接
		);
		updateFont(chart);
		return chart;
	}

	private static void updateFont(JFreeChart chart) {
		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
		// 图表
		XYPlot plot = chart.getXYPlot();
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		// X轴字体
		domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		ValueAxis valueAxis = plot.getRangeAxis();
		// y轴字体
		valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
	}


}
