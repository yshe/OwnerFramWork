package leap.demo.util.JfreeChart.demo;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Font;
public class lineDemo {
	
	private static CategoryDataset getDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Number[]temperature1 = {-6,2,10,20,29,33,26,19,-1};
		Number[]temperature2 = {-15,-2,6,18,26,29,32,15,-5};
		Number[]temperature3 = {-20,-10,1,14,20,25,29,12,-10};
		for(int i=3;i<=11;i++){
			dataset.addValue(temperature1[i-3], "北京", i+"月");
			dataset.addValue(temperature2[i-3], "长春", i+"月");
			dataset.addValue(temperature3[i-3], "哈尔滨", i+"月");
		}
		return dataset;
	}
	public static JFreeChart createChart(){
		  // 创建制图的主题样式
	    StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
	    // 设置轴向的字体
	    standardChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 16));
	    // 设置图例的字体
	    standardChartTheme.setRegularFont(new Font("宋体", Font.BOLD, 16));
	    // 设置标题字体
	    standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 24));
	    ChartFactory.setChartTheme(standardChartTheme);//设置制图工厂使用主题
        JFreeChart chart = ChartFactory.createLineChart(
                                   "气温变化情况", // 图表标题
                                   "月份",
                                   "温度",
                                   getDataset(), // 绘制数据
                                   PlotOrientation.VERTICAL, 	//图表方向
                                   true, // 定义图表是否包含图例
                                   true, // 定义图表是否包含提示
                                   false); // 定义图表是否包含URL      
        return chart;
	}
}
