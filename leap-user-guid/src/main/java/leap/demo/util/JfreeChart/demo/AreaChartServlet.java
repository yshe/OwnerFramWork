package leap.demo.util.JfreeChart.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;


/**
 * 处理区域图的Servlet类
 * @author Li Yong Qiang
 */
public class AreaChartServlet extends HttpServlet {
	private static final long serialVersionUID = 3035277682944773862L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//图形的宽度
		String w = request.getParameter("w");
		//图形的高度
		String h = request.getParameter("h");
		if (w == null || w.isEmpty()) {
			w = "600";		//宽度默认值
		}
		if (h == null || h.isEmpty()) {
			h = "300";		//高度默认值
		}
		JFreeChart chart = AreaChartUtil.createChart();
		// 初始化图表并获取文件名
		String fileName = ServletUtilities.saveChartAsJPEG(chart, Integer
				.parseInt(w), Integer.parseInt(h), request.getSession());
		// 生成图表的访问路径
		String imageUrl = request.getContextPath()
				+ "/servlet/DisplayChart?filename=" + fileName;
		request.setAttribute("imageUrl", imageUrl);
		// 转发请求到结果页面
		request.getRequestDispatcher("demoArea2.jsp").forward(request, response);
	}

}
