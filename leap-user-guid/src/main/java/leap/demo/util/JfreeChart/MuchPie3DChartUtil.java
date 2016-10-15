package leap.demo.util.JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.TableOrder;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Image;
import java.awt.Stroke;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
public class MuchPie3DChartUtil {
	
	/**
	 * 创建一个饼图表的数据集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		 double[ ][ ] data = new double[ ][ ] {
				{ 620, 410, 300 },
				{ 300, 390, 500 } };
		//创建数据集合实例
		 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"部门",	//行名称 
				"月份",	//列名称
				data);
		return dataset;
	}


	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createMultiplePieChart3D(
				"4-6月销售排行 ", 	// 饼图标题
				dataset, 				// 数据集
				TableOrder. BY_COLUMN,	// 排序方式
				true, true, false);
		createPiePlot(chart);
		return chart;
	}

	public static void createPiePlot(JFreeChart chart) {
			
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
