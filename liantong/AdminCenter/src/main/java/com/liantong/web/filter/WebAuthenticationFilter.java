/**
 * 
 */
package com.liantong.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cto.framework.core.CTO;
import cto.framework.core.util.StringHelper;
import cto.framework.web.filter.AbstractFilter;

/**
 * @author PeterTan
 * 
 */
public class WebAuthenticationFilter extends AbstractFilter {

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest $request = (HttpServletRequest)request;
		HttpServletResponse $response = (HttpServletResponse)request;
		HttpSession session = $request.getSession();
		
		String loginPage = "/login.vm";
		String targetUrl = $request.getRequestURI();
		
		if (StringHelper.isNotBlank(targetUrl)) {
			if (targetUrl.contains("login.do")
					|| targetUrl.contains("authentication.do")) {
				filterChain.doFilter(request, response);
				return;
			} else {
				loginPage += "?targetUrl=" + targetUrl;
			}
		}
		
		CTO user = null;
		if(session != null){
			user = (CTO)session.getAttribute("user");
		}
		filterChain.doFilter($request, $response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
	}
}
