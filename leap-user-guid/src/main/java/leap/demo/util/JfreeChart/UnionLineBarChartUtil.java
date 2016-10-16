package leap.demo.util.JfreeChart;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Font;
public class UnionLineBarChartUtil {
	
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
		//生成线形图渲染
		LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
		//生成柱形图渲染
		BarRenderer renderer2 = new BarRenderer();
		//设置X轴
		CategoryAxis domainAxis = new CategoryAxis("月份");
		//设置Y轴
		NumberAxis rangeAxis = new NumberAxis("销售量（单位：本）");
		//设置图表
		CategoryPlot plot1 = new CategoryPlot(dataset, domainAxis, rangeAxis, renderer1);
		CategoryPlot plot2 = new CategoryPlot(dataset, domainAxis, rangeAxis, renderer2);
		//设置联合分类图表
		final CombinedDomainCategoryPlot plot = new CombinedDomainCategoryPlot(domainAxis);
		/*plot.add(plot1);
		plot.add(plot2);*/
		//设置图表高度
		/*plot.add(plot1,1);
		plot.add(plot2,2);*/
		//设置图表位置顺序
		plot.add(plot2,2);
		plot.add(plot1,1);
		
		
		JFreeChart chart = new JFreeChart("2010年上半年销售量", plot);
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
	}

}
