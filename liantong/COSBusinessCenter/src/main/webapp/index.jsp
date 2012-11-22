<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>CTO FrameWork</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="cto,ctoframework,Dynamic deployment framework">
<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
			-->
</head>

<body>
	<jsp:forward page="system.service">
		<jsp:param name="transName" value="adminMain" />
	</jsp:forward>
</body>

</html>
