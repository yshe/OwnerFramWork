package leap.demo.util.JfreeChart.demo;

import java.awt.Font;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.VerticalAlignment;

/**
 * 区域图工具类
 * @author yabushan
 */
public class AreaChartUtil{
	/**
	 * 根据数据集合，创建JFreeChart对象
	 * @return JFreeChart
	 */
	public static JFreeChart createChart() {
		JFreeChart jfreechart = null;			//JFreeChart对象
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 24)); // 设置标题字体
		standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 15)); // 设置图例的字体
		standardChartTheme.setLargeFont(new Font("宋体", Font.BOLD, 15)); // 设置轴向的字体
		ChartFactory.setChartTheme(standardChartTheme);// 设置主题样式
		jfreechart=ChartFactory.createAreaChart(
				"学生成绩", 						// 图表标题
				"学生", 						// 横轴标题
				"成绩", 						// 纵轴标题
				createDataset(), 				//制图的数据集
				PlotOrientation.VERTICAL,		//定义区域图的方向为纵向
				true, 							// 是否显示图例标识
				true, 							// 是否显示tooltips
				false);							// 是否支持超链接
		//获取categoryplot对象
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		categoryplot.setForegroundAlpha(0.5F);	// 设置前景透明度为50%
		categoryplot.setDomainGridlinesVisible(true);//显示网格
		//创建子标题
		TextTitle textTile = new TextTitle("XX学校学生英语成绩变化");
		textTile.setVerticalAlignment(VerticalAlignment.BOTTOM);	//居中显示
		jfreechart.addSubtitle(textTile);							//将子标题放入jfreechart中
		//获取NumberAxis对象
		//NumberAxis numberaxis = (NumberAxis)categoryplot.g
		//numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		ChartUtilities.applyCurrentTheme(jfreechart);
		return jfreechart;
	}
	/**
	 * 创建区域图的数据集合
	 * @return CategoryDataset
	 */
	public static CategoryDataset createDataset() {
		//数据集合DefaultCategoryDataset对象
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		Random random = new Random();		//创建Random对象
		//向数据集合加入6个月的数据
		for (int i = 1; i < 7; i++) {
			defaultcategorydataset.addValue(random.nextInt(50) + 50, "小王", i + "");
			defaultcategorydataset.addValue(random.nextInt(50) + 50, "小李", i + "");
			defaultcategorydataset.addValue(random.nextInt(50) + 50, "小刘", i + "");
		}
		return defaultcategorydataset;
	}
	
}
