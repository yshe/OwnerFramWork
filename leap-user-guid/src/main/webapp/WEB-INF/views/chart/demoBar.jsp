<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"  %>
<%@ page import="leap.demo.util.JfreeChart.demo.barDemo"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>利用柱形图显示某Ajax网站不同框架下载量</title>
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
    	String filename = ServletUtilities.saveChartAsJPEG(barDemo.createChart(),700,300,session);
    	String chartUrl = path+"/DisplayChart?filename="+filename;
     %>
     <img alt="" src="<%=chartUrl %>">
  </body>
</html>
