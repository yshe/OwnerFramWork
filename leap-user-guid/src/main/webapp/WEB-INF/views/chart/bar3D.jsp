<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"  %>
<%@ page import="leap.demo.util.JfreeChart.Bar3DChartUtil"  %>
<%@ page import="org.jfree.chart.JFreeChart"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>绘制3D柱形图</title>
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
  		JFreeChart chart = Bar3DChartUtil.getJFreeChart();//生成JFreeChart图表对象 
    	String filename = ServletUtilities.saveChartAsJPEG(chart,650,400,session);
    	String chartUrl = path+"/DisplayChart?filename="+filename;
     %>
     <center><img alt="" src="<%=chartUrl %>"></center>
  </body>
</html>
