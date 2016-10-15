<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"  %>
<%@ page import="org.jfree.chart.*"  %>
<%@ page import="java.io.*"  %>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"  %>
<%@ page import="leap.demo.util.JfreeChart.BaseChartUtil"  %>
<%@ page import="org.jfree.chart.JFreeChart"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>基本饼图</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%
  		JFreeChart chart = BaseChartUtil.getJFreeChart();//生成JFreeChart图表对象
  		BaseChartUtil.setPiePoltFont(chart);//设置字体样式
  		BaseChartUtil.setPiePoltNum(chart);//显示数值
  		BaseChartUtil.setBackgroundImage(chart,application.getRealPath("/")+"/image/backgroundImage.jpg","0.5");//设置背景图片
  		BaseChartUtil.setOutline(chart);//隐藏图表边框
  		BaseChartUtil.setLegendTitle(chart);//图示背景色 
  		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());    
    	String fileName = ServletUtilities.saveChartAsJPEG(chart,1000,300,info,session);//生成图片并返回临时图片名
    	PrintWriter writer = new PrintWriter(out);					//创建打印输出流
    	ChartUtilities.writeImageMap(writer,fileName,info,false);	//图片地图中加入工具栏提示    		
    	String chartUrl = path+"/DisplayChart?filename="+fileName;	//生成图片的路径
    	fileName = "#"+fileName;//图片名加#号
    	writer.flush();
    	
     %>   
     <center><img  src="<%=chartUrl %>" usemap="<%=fileName%>"></center>
  </body>
</html>
