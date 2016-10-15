package leap.demo.util.JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.Font;
import java.util.Iterator;
import java.util.Map;

/**
 * 3D饼图
 * 
 */
import leap.demo.util.JfreeChart.data.MapData;
public class Pie3dChartUtil {
	
	/**
	 * 创建一个饼图表的数据集
	 * 
	 * @return
	 */
	private static PieDataset getPieDataset() {
		// 创建一个饼图表的数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
		// 获取数据
		Map parMap=MapData.getData();
		Iterator<Map.Entry<String, Integer>> entries = parMap.entrySet().iterator();  
		while (entries.hasNext()) {  
		    Map.Entry<String, Integer> entry = entries.next();  
		 // 向饼图表的数据集添加数据
		  dataset.setValue(entry.getKey(), entry.getValue());
		}  
		return dataset;
	}

	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	public static JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart3D("2010.8月份销售排行", dataset,true, true, false);
		setPiePoltFont(chart);
		createPiePlot(chart);
		return chart;
	}
	

	/**
	 * 设置饼图使用的字体
	 * 
	 * @param chart
	 */
	protected static void setPiePoltFont(JFreeChart chart) {
		// 图表(饼图)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{1}"));
		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.BOLD, 20));
		// 图例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
	}
	
	public static void createPiePlot(JFreeChart chart){
		PiePlot3D plot  = (PiePlot3D)chart.getPlot();
		//设置3D饼图Z轴的高度
		plot.setDepthFactor(0.1f); 
		//设置饼图透明度
		plot.setForegroundAlpha(0.7f);
		
		
		
	}

}
