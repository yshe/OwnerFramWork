package leap.demo.util.JfreeChart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
/**
 * 基本柱状图
 * @author yabushan
 *
 */
public class BarChartUtil {
	private static CategoryDataset getCategoryDataset() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		//添加数据
		keyedValues.addValue("1月份", 310);
		keyedValues.addValue("2月份", 489);
		keyedValues.addValue("3月份", 512);
		keyedValues.addValue("4月份", 589);
		keyedValues.addValue("5月份", 359);
		keyedValues.addValue("6月份", 402);
		/*keyedValues.addValue("7月份", null);
		keyedValues.addValue("8月份", -402);//数值的正负，标识在y轴的位置
*/		//创建数据集合实例
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("java book2010年", keyedValues);
		return dataset;
	}



	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("2010.1-6 sales volume年份", // 图表标题
				"month", 	// x轴标签
				"sales",	// y轴标签
				dataset, 	// 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				false,	 	// 是否显示图例(对于简单的柱状图必须是false)
				false, 		// 是否生成工具
				false 		// 是否生成URL链接
				);
		createPlot(chart);		//修改标题字体
		return chart;
	}
	public static void createPlot(JFreeChart chart) {
		// 标题
				TextTitle textTitle = chart.getTitle();
				textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
				// 图表(柱形图)
				CategoryPlot categoryPlot = chart.getCategoryPlot();
				//y轴的显示位置(左边右边)
				categoryPlot.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
				//x轴的显示位置(即图像的上边还是图像的下边)
				categoryPlot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
				
				//设置网格竖线是否显示
				categoryPlot.setDomainGridlinesVisible(true);
				//设置网格竖线颜色
				categoryPlot.setDomainGridlinePaint(Color.blue);
				
				/**
				 * x轴设置
				 */
				CategoryAxis axis = categoryPlot.getDomainAxis();
				//X轴字体
				axis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
				//X轴标签字体
				axis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
				//x轴标签角度
				axis.setLabelAngle(4l);
				
				//x轴尺度线颜色
				axis.setAxisLinePaint(Color.GREEN);
				//隐藏x轴尺度线
				//axis.setAxisLineVisible(false);
				//x轴尺度线笔触
				axis.setAxisLineStroke(new BasicStroke(5f));
				//x轴尺度标签过长时，调整角度，避免重叠
				/**
				 * DOWN_45 顺时针旋转45°
				 * DOWN_90 顺时针旋转90°
				 * UP_45逆时针旋转45°
				 */
				axis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
				
				//x轴分类的间距
				axis.setCategoryMargin(0.5);
				
				//x轴分类与原点的间距
				axis.setLowerMargin(0.3);
				
				
				
				//隐藏x轴坐标
				//axis.setVisible(false);
				/**
				 * y轴设置
				 * 
				 */
				ValueAxis valueAxis = categoryPlot.getRangeAxis();
				// y轴字体
				valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
				//y轴标签字体
				valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
				//y轴标签角度
				valueAxis.setLabelAngle(10l);
				//y轴尺度线颜色
				valueAxis.setAxisLinePaint(Color.YELLOW);
				//隐藏y轴尺度线
				//valueAxis.setAxisLineVisible(false);
				//隐藏y轴坐标
				//valueAxis.setVisible(false);
				//y轴尺度线笔触
				valueAxis.setAxisLineStroke(new BasicStroke(5f));
				
				//y轴尺度标签角度垂直
				valueAxis.setVerticalTickLabels(true);
				
				//y轴起始值
			//	valueAxis.setLowerBound(100);
				
				//设置y轴箭头
				valueAxis.setPositiveArrowVisible(true);
				
				//隐藏y轴主要刻度线
				valueAxis.setTickMarksVisible(false);
				
				//y轴主要刻度线长度
				valueAxis.setTickMarkInsideLength(5f);
				//设置y轴主要刻度线外部延长线的长度
				valueAxis.setTickMarkOutsideLength(10f);
				
				//设置y轴最大值
				valueAxis.setUpperBound(800l);
				
				//设置y轴数范围
				valueAxis.setRangeAboutValue(200, 900);
				
				
	}
}
