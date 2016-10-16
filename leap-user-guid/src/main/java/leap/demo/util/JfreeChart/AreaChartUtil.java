package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
/**
 * 基本区域图
 * @author yabushan
 *
 */
public class AreaChartUtil {
	
	private static CategoryDataset getCategoryDataset() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		//添加数据
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", 589);
		keyedValues.addValue("5", 359);
		keyedValues.addValue("6", 402);
		//创建数据集
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("java book", keyedValues);
		return dataset;
	}
	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createAreaChart("2010-1-6 sales volume", // 图表标题
		"month", 				// x轴标签
		"sales", 				// y轴标签
		dataset, 				// 数据集
		PlotOrientation.VERTICAL, 	// 图表方向：水平、垂直
		true, 					// 是否显示图例
		false, 					// 是否生成工具
		false 					// 是否生成URL链接
		);
		return chart;
	}

}
