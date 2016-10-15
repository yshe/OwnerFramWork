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
    <title>������ͼ</title>
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
  		JFreeChart chart = BaseChartUtil.getJFreeChart();//����JFreeChartͼ�����
  		BaseChartUtil.setPiePoltFont(chart);//����������ʽ
  		BaseChartUtil.setPiePoltNum(chart);//��ʾ��ֵ
  		BaseChartUtil.setBackgroundImage(chart,application.getRealPath("/")+"/image/backgroundImage.jpg","0.5");//���ñ���ͼƬ
  		BaseChartUtil.setOutline(chart);//����ͼ��߿�
  		BaseChartUtil.setLegendTitle(chart);//ͼʾ����ɫ 
  		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());    
    	String fileName = ServletUtilities.saveChartAsJPEG(chart,1000,300,info,session);//����ͼƬ��������ʱͼƬ��
    	PrintWriter writer = new PrintWriter(out);					//������ӡ�����
    	ChartUtilities.writeImageMap(writer,fileName,info,false);	//ͼƬ��ͼ�м��빤������ʾ    		
    	String chartUrl = path+"/DisplayChart?filename="+fileName;	//����ͼƬ��·��
    	fileName = "#"+fileName;//ͼƬ����#��
    	writer.flush();
    	
     %>   
     <center><img  src="<%=chartUrl %>" usemap="<%=fileName%>"></center>
  </body>
</html>
