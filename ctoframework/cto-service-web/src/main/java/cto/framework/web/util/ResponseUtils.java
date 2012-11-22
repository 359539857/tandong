package cto.framework.web.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class ResponseUtils {
	private static final String ENCODING_PREFIX = "encoding:";
	private static final String NOCACHE_PREFIX = "no-cache:";
	private static final String ENCODING_DEFAULT = "UTF-8";
	private static final boolean NOCACHE_DEFAULT = true;
	
	private ResponseUtils() {
	}
	
	public static void render(HttpServletResponse response,final String contentType, final String content, final String... headers) {
		try {
			String encoding = ENCODING_DEFAULT;
			boolean noCache = NOCACHE_DEFAULT;
			for (String header : headers) {
				String headerName = StringUtils.substringBefore(header, ":");
				String headerValue = StringUtils.substringAfter(header, ":");

				if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
					encoding = headerValue;
				} else if (StringUtils.equalsIgnoreCase(headerName, NOCACHE_PREFIX)) {
					noCache = Boolean.parseBoolean(headerValue);
				} else
					throw new IllegalArgumentException(headerName + "head err");
			}

			response.setCharacterEncoding(encoding);
			String fullContentType = contentType + ";charset=" + encoding;
			response.setContentType(fullContentType);
			if (noCache) {
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
			}

			response.getWriter().write(content);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void renderText(HttpServletResponse response,final String text, final String... headers) {
		render(response,"text/plain", text, headers);
	}
	
	public static void renderHtml(HttpServletResponse response,final String html, final String... headers) {
		render(response,"text/html", html, headers);
	}
	
	public static void renderXml(HttpServletResponse response,final String xml, final String... headers) {
		render(response,"text/xml", xml, headers);
	}
	
	public static void renderJson(HttpServletResponse response,final String string, final String... headers) {
		render(response,"application/json", string, headers);
	}
}
