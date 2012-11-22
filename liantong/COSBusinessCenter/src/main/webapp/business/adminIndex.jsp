<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="cto.framework.core.*,cto.framework.service.schema.*,cto.framework.service.plugin.schema.*"%>
<%@ include file="/common/style_css.jsp"%>
<!DOCTYPE HTML>
<html>
<body class="mainbody">
	<div id="content">
		<div class="breadcrumb">
			<a href="/" target="_top"><a href="###">系统配置信息</a>
		</div>
		<div class="textbox half ">
			<h2>缓存 配置信息</h2>
			<div class="textbox_content">
				<table>
					<%
						CTO ctoResponse = (CTO) request.getAttribute("ctoResponse");
						if (ctoResponse != null) 
						{
							MemCacheServerGroup[] cacheGroup = (MemCacheServerGroup[])ctoResponse.getObjectValue("cacheGroup");
							if(cacheGroup != null)
							{
								java.
							}
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>