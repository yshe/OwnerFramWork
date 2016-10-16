package leap.demo.util.JfreeChart.demo;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.Font;
import java.text.NumberFormat;
public class pieDemo {
	private static PieDataset getDataset(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Java", 30);
		dataset.setValue("C#", 25);
		dataset.setValue("C++", 20);
		dataset.setValue("PHP", 15);
		dataset.setValue("C语言", 10);
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
        JFreeChart chart = ChartFactory.createPieChart(
                                   "不同编程语言的市场占有率", // 图表标题
                                   getDataset(), // 绘制数据
                                   true, // 定义图表是否包含图例
                                   true, // 定义图表是否包含提示
                                   false); // 定义图表是否包含URL
        PiePlot plot = (PiePlot)chart.getPlot(); 
    	plot.setLabelGenerator(
    			new StandardPieSectionLabelGenerator("{0}{2}",
    			NumberFormat.getNumberInstance(), 
    			NumberFormat.getPercentInstance()));
    	plot.setBackgroundAlpha(0.8f);
    	plot.setForegroundAlpha(0.4f);
        return chart;
	}
}
