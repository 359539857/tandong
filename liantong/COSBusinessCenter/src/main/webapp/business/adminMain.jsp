<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CTO Framework 服务系统</title>
<!-- common_css -->
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/style.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/responsive.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/visualize.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/date_input.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/jquery.minicolors.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/jquery.wysiwyg.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/jquery.fancybox.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/tipsy.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/ui-lightness/jquery-ui.custom.css">
<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/jquery.validation.css">
<!--[if lt IE 9]>
	<link rel="stylesheet" href="<%=application.getInitParameter("staticPath") %>/css/ie.css">
	<script src="<%=application.getInitParameter("staticPath") %>/js/html5shiv.js"></script>
	<![endif]-->
<!-- common_css E-->
<%
	
%>
</head>
<body>

	<!-- header S -->
	<header>
		<img style="float:left; margin:12px 20px 0px 0px;" src="<%=application.getInitParameter("staticPath") %>/images/COS.jpg" />
		<h1>
			<a href="${contextPath}">CTO Framework 服务系统</a>
		</h1>
	</header>
	<!-- #header ends -->

	<%@ include file="/business/adminLeft.jsp"%>

	<section id="content" class="mainframe" style="height: auto;">
		<iframe id="rightIframe" name="rightIframe" frameborder="0" marginheight='0' scrolling="no" width="100%" height="100%" src="adminIndex.service"></iframe>
	</section>

	<div id="operatorSet" style="display:none;"></div>

	<!-- common_js S-->
	<%@ include file="/common/foot_js.jsp"%>
	<!-- common_js E-->

</body>
</html>
