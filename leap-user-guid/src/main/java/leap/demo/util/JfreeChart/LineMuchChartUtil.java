package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
public class LineMuchChartUtil {
	
	private static CategoryDataset getCategoryDataset() {
		// 系列关键字
		final String series1 = "JAVA图书";
		final String series2 = "VC图书";
		final String series3 = "VB图书";
		// 分类关键字
		final String category1 = "1月";
		final String category2 = "2月";
		final String category3 = "3月";
		final String category4 = "4月";
		final String category5 = "5月";
		final String category6 = "6月";
		// 创建分类数据集
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(310, series1, category1);
		dataset.addValue(489, series1, category2);
		dataset.addValue(512, series1, category3);
		dataset.addValue(589, series1, category4);
		dataset.addValue(359, series1, category5);
		dataset.addValue(402, series1, category6);
		dataset.addValue(501, series2, category1);
		dataset.addValue(200, series2, category2);
		dataset.addValue(308, series2, category3);
		dataset.addValue(580, series2, category4);
		dataset.addValue(418, series2, category5);
		dataset.addValue(315, series2, category6);
		dataset.addValue(480, series3, category1);
		dataset.addValue(381, series3, category2);
		dataset.addValue(264, series3, category3);
		dataset.addValue(185, series3, category4);
		dataset.addValue(209, series3, category5);
		dataset.addValue(302, series3, category6);
		return dataset;
	}
	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createLineChart("2010年上半年销售量", // 图表标题
			"月份", 				// x轴标签
			"销售量（单位：本）", 		// y轴标签
			dataset, 				// 数据集
			PlotOrientation.VERTICAL, 	// 图表方向：水平、垂直
			true, 					// 是否显示图例
			false, 					// 是否生成工具
			false 					// 是否生成URL链接
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
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X轴字体
		categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y轴字体
		valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		
		//设置x轴位置
		categoryPlot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
		
		LineAndShapeRenderer renderer=(LineAndShapeRenderer) categoryPlot.getRenderer();
		//隐藏折线图中指定系列的折线
		//renderer.setSeriesLinesVisible(0, false);
		
		//加粗折线
		renderer.setSeriesStroke(0, new BasicStroke(5));
		
		//显示或隐藏节点
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesShapesVisible(2, true);
		
		//显示或隐藏折线
		/*renderer.setSeriesLinesVisible(0, false);
		renderer.setSeriesLinesVisible(1, false);
		renderer.setSeriesLinesVisible(2, false);*/
		
		// 虚线
		renderer.setSeriesStroke(0, new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[] { 10.0f, 16.0f }, 0.0f));
		renderer.setSeriesStroke(1, new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[] { 10.0f, 16.0f }, 0.0f));
		renderer.setSeriesStroke(2, new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[] { 10.0f, 16.0f }, 0.0f));
		
		//设置折线颜色
		renderer.setSeriesPaint(0, Color.black);
		renderer.setSeriesPaint(1, Color.red);
		renderer.setSeriesPaint(2, Color.blue);
		
	}
}
