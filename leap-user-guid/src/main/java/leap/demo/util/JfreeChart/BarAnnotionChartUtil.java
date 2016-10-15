package leap.demo.util.JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryLineAnnotation;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
/**
 * 加强版柱形图
 * @author yabushan
 *
 */
public class BarAnnotionChartUtil {
	
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
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("JAVA图书", keyedValues);
		return dataset;
	}

	public static JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("2010年上半年销售量", // 图表标题
				"月份", // x轴标签
				"销售量（单位：本）", // y轴标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		updateFont(chart);
		updatePlot(chart);
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
	}
	public static void updatePlot(JFreeChart chart) {
		// 图表
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		//设置注解
		CategoryTextAnnotation annotation = new CategoryTextAnnotation("310","1月",320);
		CategoryTextAnnotation annotation1 = new CategoryTextAnnotation("489","2月",499);
		CategoryTextAnnotation annotation2 = new CategoryTextAnnotation("512","3月",522);
		CategoryTextAnnotation annotation3 = new CategoryTextAnnotation("589","4月",599);
		CategoryTextAnnotation annotation4 = new CategoryTextAnnotation("359","5月",369);
		CategoryTextAnnotation annotation5 = new CategoryTextAnnotation("402","6月",412);
		//添加注解
		categoryPlot.addAnnotation(annotation);
		categoryPlot.addAnnotation(annotation1);
		categoryPlot.addAnnotation(annotation2);
		categoryPlot.addAnnotation(annotation3);
		categoryPlot.addAnnotation(annotation4);
		categoryPlot.addAnnotation(annotation5);
		//设置注解文本锚点
		annotation.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		annotation1.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		annotation2.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		annotation3.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		annotation4.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		annotation5.setTextAnchor(TextAnchor.BASELINE_RIGHT);
		//设置注解角度锚点
		annotation.setRotationAngle(Math.PI*0.2);
		annotation1.setRotationAngle(Math.PI*0.2);
		annotation2.setRotationAngle(Math.PI*0.2);
		annotation3.setRotationAngle(Math.PI*0.2);
		annotation4.setRotationAngle(Math.PI*0.2);
		annotation5.setRotationAngle(Math.PI*0.2);
		
		
		//设置柱形图线条注解
		CategoryLineAnnotation annotation0 = new CategoryLineAnnotation("1月",200,"2月",300,Color.blue,new BasicStroke());
		CategoryLineAnnotation annotation11 = new CategoryLineAnnotation("2月",300,"3月",100,Color.blue,new BasicStroke());
		CategoryLineAnnotation annotation21 = new CategoryLineAnnotation("3月",100,"4月",400,Color.blue,new BasicStroke());
		CategoryLineAnnotation annotation31 = new CategoryLineAnnotation("4月",400,"5月",300,Color.blue,new BasicStroke());
		CategoryLineAnnotation annotation41 = new CategoryLineAnnotation("5月",300,"6月",350,Color.blue,new BasicStroke());
		categoryPlot.addAnnotation(annotation0);
		categoryPlot.addAnnotation(annotation11);
		categoryPlot.addAnnotation(annotation21);
		categoryPlot.addAnnotation(annotation31);
		categoryPlot.addAnnotation(annotation41);
		
		//绘制柱形效果
			//设置y轴显示位置
		BarRenderer renderer=(BarRenderer) categoryPlot.getRenderer();
			//普通效果
		StandardBarPainter barPainter=new StandardBarPainter();
			//梯形效果
		GradientBarPainter barPainter2=new GradientBarPainter();
		renderer.setBarPainter(barPainter2);
		
		//柱形图阴影
		renderer.setShadowVisible(true);
		
		//柱形图阴影偏移
		renderer.setShadowXOffset(10);
		renderer.setShadowYOffset(10);
		
		//设置柱形颜色
		renderer.setSeriesPaint(0, Color.GREEN);
	}


}
