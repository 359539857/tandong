<%@page contentType="text/html; charset=UTF-8"%>
<aside>
	<ul id="nav">
		<li>
			<a href="<%=application.getInitParameter("contextPath") %>/sysService.service" target="rightIframe">
				<img src="<%=application.getInitParameter("staticPath") %>/images/nav/nav_5.png" alt="" />框架信息
			</a>
		</li>
		<li>
			<a href="<%=application.getInitParameter("contextPath") %>/sysService.service" target="rightIframe">
				<img src="<%=application.getInitParameter("staticPath") %>/images/nav/nav_7.png" alt="" />系统服务
			</a>
		</li>
		<li>
			<a href="<%=application.getInitParameter("contextPath") %>/sysService.service" target="rightIframe">
				<img src="<%=application.getInitParameter("staticPath") %>/images/nav/nav_8.png" alt="" />系统Trans
			</a>
		</li>
		<li>
			<a href="<%=application.getInitParameter("contextPath") %>/loginOut.service">
				<img src="<%=application.getInitParameter("staticPath") %>/images/nav/delete.png" alt="" /> 退出系统 
			</a>
		</li>
	</ul>
</aside>
<!-- aside ends -->
