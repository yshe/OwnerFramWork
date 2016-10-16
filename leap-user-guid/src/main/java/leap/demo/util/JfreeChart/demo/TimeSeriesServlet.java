package leap.demo.util.JfreeChart.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;


/**
 * 处理时序图的Servlet类
 * @author Li Yong Qiang
 */
public class TimeSeriesServlet extends HttpServlet {
	private static final long serialVersionUID = -2138395507538302226L;

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
			w = "700";		//宽度默认值
		}
		if (h == null || h.isEmpty()) {
			h = "300";		//高度默认值
		}
		JFreeChart chart = TimeSeriesUtil2.createChart();
		// 初始化图表并获取文件名
		String fileName = ServletUtilities.saveChartAsJPEG(chart, Integer
				.parseInt(w), Integer.parseInt(h), request.getSession());
		// 生成图表的访问路径
		String graphUrl = request.getContextPath()
				+ "/servlet/DisplayChart?filename=" + fileName;
		request.setAttribute("imageUrl", graphUrl);
		// 转发请求到结果页面
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
