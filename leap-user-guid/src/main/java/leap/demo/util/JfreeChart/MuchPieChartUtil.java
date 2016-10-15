package leap.demo.util.JfreeChart;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.TableOrder;
public class MuchPieChartUtil {
	
	/**
	 * 创建一个饼图表的数据集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		 double[ ][ ] data = new double[ ][ ] {
				{ 620, 410, 300 },
				{ 300, 390, 500 },{ 300, 390, 500 } };
		//创建数据集合实例
		 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"Dept部门",	//行名称 
				"Month月份",	//列名称
				data);
		return dataset;
	}


	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = createDataset();	//获取数据集
		//生成JFreeChart对象
		JFreeChart chart = ChartFactory.createMultiplePieChart(
				"4-6 month sales ranking ", 	// 饼图标题
				dataset, 				// 数据集
				TableOrder.BY_ROW, 		// 排序方式
				true, true, false);
		return chart;
	}

	
	public static void createPiePlot(JFreeChart chart){
		// 窗体标题
				TextTitle textTitle = chart.getTitle();
				textTitle.setFont(new Font("宋体", Font.BOLD, 20));
				// 图例
				LegendTitle legendTitle = chart.getLegend();
				legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
				//获取多饼图
				MultiplePiePlot multiplePiePlot = (MultiplePiePlot) chart.getPlot();
				JFreeChart jFreeChart = multiplePiePlot.getPieChart();
				// 图表标签
				PiePlot piePlot = (PiePlot) jFreeChart.getPlot();
				piePlot.setLabelFont(new Font("宋体", Font.PLAIN, 14));
				piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));
				// 图表标题
				TextTitle textTitle2 = jFreeChart.getTitle();
				textTitle2.setFont(new Font("宋体", Font.BOLD, 20));
	}

}
