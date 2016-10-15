package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;
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
public class Bar3DChartUtil {
	
	private static CategoryDataset getCategoryDataset() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		//添加数据
		keyedValues.addValue("1月", 310);
		keyedValues.addValue("2月", 489);
		keyedValues.addValue("3月", 512);
		keyedValues.addValue("4月", 589);
		keyedValues.addValue("5月", 359);
		keyedValues.addValue("6月", 402);
		//创建数据集合实例
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"跳楼价", keyedValues);
		return dataset;
	}



	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart3D("2016年上半年何文斌价格表", // 图表标题
				"月份", 				// x轴标签
				"价格（单位：个/元）", 		// y轴标签
				dataset, // 数据集
				PlotOrientation.VERTICAL,	// 图表方向：水平、垂直
				true, 					// 是否显示图例(对于简单的柱状图必须是false)
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
		// 图表(柱形图)
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
		// 图示
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 12));
		
		
		//标记柱形图区间
		IntervalMarker target = new IntervalMarker(560.0, 700.0);
		target.setLabel("超出历史最高销售"); 				//Marker标签名称
        target.setLabelFont(new Font("宋体", Font.PLAIN, 14)); 		//Marker标签字体
        target.setLabelAnchor(RectangleAnchor.LEFT); 			//Marker标签锚点
        target.setLabelTextAnchor(TextAnchor.BASELINE_LEFT); 	//Marker标签文字锚点
        target.setPaint(new Color(222, 122, 255, 128)); 			//Marker背景色
        categoryPlot.addRangeMarker(target); 				//标记范围
	}

}
