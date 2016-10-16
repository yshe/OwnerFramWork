package leap.demo.util.JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;





import org.jfree.util.Rotation;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.Map;

import leap.demo.util.JfreeChart.data.MapData;
/**
 * 分离饼图
 * @author yabushan
 *
 */
public class SeparateChartUtil {
	
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
		JFreeChart chart = ChartFactory.createPieChart("2010.8月份销售排行", dataset,true, true, false);
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
				"{0}:{1}"));
		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.BOLD, 20));
		// 图例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
	}

	/**
	 * 设置Pie
	 * 
	 * @param chart
	 */
	public static void createPiePlot(JFreeChart chart) {		
		PiePlot piePlot = (PiePlot) chart.getPlot();
		// 需要分离的图书
		piePlot.setExplodePercent("广州", 0.1);
		piePlot.setExplodePercent("黄坑", 0.1);	
		//是否为椭圆
		//piePlot.setCircular(true);
		//饼图的阴影
		/*piePlot.setShadowXOffset(20);
		piePlot.setShadowYOffset(20);*/
		
		//加粗饼图分类边框
		//设置饼图边框笔触
		/*piePlot.setSectionOutlineStroke("广州", new BasicStroke(3f));
		piePlot.setSectionOutlineStroke("黄坑", new BasicStroke(5f));*/
		
		//设置饼图颜色
		piePlot.setSectionPaint("南雄",Color.yellow);
		piePlot.setSectionPaint("韶关",Color.green);
		piePlot.setSectionPaint("广州",Color.BLACK);
		piePlot.setSectionPaint("黄坑",Color.BLUE);
		
		//设置旋转角度
		piePlot.setStartAngle(120);
		//设置逆时针
		piePlot.setDirection(Rotation.ANTICLOCKWISE);
		
		
		//设置标签模式
		piePlot.setSimpleLabels(true);
		
		
		
		
	}
}
