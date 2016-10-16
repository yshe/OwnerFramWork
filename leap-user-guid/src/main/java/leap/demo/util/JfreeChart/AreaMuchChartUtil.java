package leap.demo.util.JfreeChart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import java.awt.Color;
import java.awt.Font;
public class AreaMuchChartUtil {
	
	private static CategoryDataset getCategoryDataset() {
		// 行关键字
		final String series1 = "JAVA图书";
		final String series2 = "VC图书";
		final String series3 = "VB图书";
		// 列关键字
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
		JFreeChart chart = ChartFactory.createAreaChart("2010年上半年销售量", // 图表标题
		"月份", 			// x轴标签
		"销售量（单位：本）", 	// y轴标签
		dataset, 			// 数据集
		PlotOrientation.VERTICAL, // 图表方向：水平、垂直
		true, 				// 是否显示图例
		false,			 	// 是否生成工具
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
		
		//设置透明度
		categoryPlot.setForegroundAlpha(0.5f);
		//添加说明文字
		TextTitle subtitle = new TextTitle("下图显示明日科技公司2010上半年（1-6月份）图书销售情况，根据图表显示情况2010上半年中JAVA图书的销售占比较大的比重，VC和VB相比JAVA图书的销售少了一些。");
		chart.addSubtitle(subtitle);
		//设置显示位置
		subtitle.setPosition(RectangleEdge.LEFT);
		subtitle.setPaint(Color.green);
		chart.addSubtitle(subtitle);
		
		//设置区域图x轴显示位置
		categoryPlot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
		
		//设置区域图x轴标签角度
		categoryAxis.setLabelAngle(Math.PI*0.3);
		
		//设置区域图x轴尺度标签角度
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		
		//设置区域颜色
		AreaRenderer renderer=(AreaRenderer) categoryPlot.getRenderer();
		renderer.setSeriesPaint(0, Color.BLUE);
	}


}
