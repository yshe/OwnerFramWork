package leap.demo.util.JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.SortOrder;

import java.awt.Font;
/**
 * 基本折线图
 * @author yabushan
 *
 */
public class LineChartUtil {
	
	private static CategoryDataset getCategoryDataset() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", 589);
		keyedValues.addValue("5", 359);
		keyedValues.addValue("6", 402);
		//排序
		keyedValues.sortByValues(SortOrder.ASCENDING); 
	//	keyedValues.sortByKeys(SortOrder.DESCENDING);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("JAVA图书", keyedValues);
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
		
		
	}

}
