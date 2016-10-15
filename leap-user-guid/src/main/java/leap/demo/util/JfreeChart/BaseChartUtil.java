package leap.demo.util.JfreeChart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Stroke;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import leap.demo.util.JfreeChart.data.MapData;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
/**
 * 基本饼图
 * @author yabushan
 *
 */
public class BaseChartUtil {

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

	public static JFreeChart getJFreeChart() {
		// 获取数据集
		PieDataset dataset = getPieDataset();
		// 生成JFreeChart对象
		/**
		 * Open Declaration JFreeChart org.jfree.chart.ChartFactory.createPieChart
		 * (String title, PieDataset dataset, boolean legend, boolean tooltips, boolean urls)
		 * title：表示饼图的标题
		 * dataset：表示饼图的数据集合
		 * legend：表示十分使用图例
		 * tooltips：表示是否生成工具栏提示
		 * urls：表示是否生成URL链接
		 */
		
		JFreeChart chart = ChartFactory.createPieChart("各地土豪数", dataset,
				true, true, true);

		/**
		 * 由于受到分辨率的制约，物体周围会出现三角形的锯齿状，抗锯齿就是指对图像边缘进行柔化处理，使其更平滑
		 * 默认是打开抗锯齿
		 */
		//关闭抗锯齿
		chart.setAntiAlias(true);

		return chart;

	}
	
	/**
	 * 解决中文乱码问题
	 * @param chart
	 */
	public static void setPiePoltFont(JFreeChart chart) {

		// 图表(饼图)

		PiePlot piePlot = (PiePlot) chart.getPlot();

		//设置图表字体

		piePlot.setLabelFont(new Font("宋体", Font.PLAIN, 14));

		// 标题

		TextTitle textTitle = chart.getTitle();

		textTitle.setFont(new Font("宋体", Font.BOLD, 20));

		// 图示

		LegendTitle legendTitle = chart.getLegend();

		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 12));
	}
	
	/**
	 * 默认值显示标题，可以设置为显示标题和数值
	 * 
	 * @param chart
	 */
	public static void setPiePoltNum(JFreeChart chart) {

		// 图表(饼图)

		PiePlot piePlot = (PiePlot) chart.getPlot();

		//设置饼图标签显示
		/**
		 * "{0}" 即是JFreeChart使用的默认值，使用它则表示图表中显示类别名称
		 * "{1}" 表示图表中显示类别的具体数值
		 * "{2}"表示图表中要显示当前类别在总数中的百分比
		 * "{3}"表示图表中所有类别相加的总值
		 */

		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));

	}
	
	/**
	 * 设置背景图
	 * 设置饼图背景图
	 * 设置背景透明度
	 * 设置饼图背景色
	 * @param chart 图对象
	 * @param imgPath 图片路径
	 * @param opacity 透明度
	 */
	public static void setBackgroundImage(JFreeChart chart,String imgPath,String opacity) {

		Image image = null;

		try {

			image = ImageIO.read(new FileInputStream(imgPath));

		} catch (IOException e) {

			e.printStackTrace();

		}

		PiePlot piePlot = (PiePlot) chart.getPlot();

		//设置饼图背景图

		piePlot.setBackgroundImage(image);
		
		//设置背景透明度
		piePlot.setBackgroundAlpha(Float.parseFloat(opacity));
		
		//设置饼图背景色
		piePlot.setBackgroundPaint(Color.orange);

	}
	/**
	 * 处理图表的边框
	 * @param chart
	 */
	public static  void setOutline(JFreeChart chart) {

		PiePlot piePlot = (PiePlot) chart.getPlot();

		piePlot.setBackgroundPaint(Color.white);

		//取消边框
		//piePlot.setOutlineVisible(false);
		//设置边框笔触
		Stroke stroke=new BasicStroke(1);
		piePlot.setOutlineStroke(stroke);
		//设置边框颜色
		piePlot.setOutlinePaint(Color.orange);

	}
	/**
	 * 修改图表的图例
	 * @param chart
	 */
	@SuppressWarnings("deprecation")
	public static void setLegendTitle(JFreeChart chart) {

		LegendTitle legendTitle = chart.getLegend();

		//设置图示背景色
		legendTitle.setBackgroundPaint(Color.orange);

		//设置图例间距
		legendTitle.setMargin(0, 10, 10, 246);
		//设置图例颜色
		legendTitle.setItemPaint(Color.MAGENTA);
		//设置图例位置
		legendTitle.setPosition(RectangleEdge.BOTTOM);
		//设置图示边框
		BlockBorder border = new BlockBorder(0,0,0,0);
		legendTitle.setBorder(border);
		
	}


}
