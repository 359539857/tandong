/**  
 * $Id: HttpUtils.java 8754 2012-03-26 19:14:53Z tandong $
 * @Copyright @ Expoint.com.cn 2012 All Right Reserved
 */
package cto.framework.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @author tandong
 * @date 2012-2-17 上午10:41:31
 * @version V1.0
 */
public class HttpUtils {

	private static Logger logger = Logger.getLogger(HttpUtils.class);

	@SuppressWarnings("deprecation")
	private static final String CHARSET = HTTP.UTF_8;
	private static HttpClient customerHttpClient;

	private HttpUtils() {
	}

	public static synchronized HttpClient getHttpClient() {
		if (null == customerHttpClient) {
			HttpParams params = new BasicHttpParams();
			// 设置一些基本参数
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, CHARSET);
			HttpProtocolParams.setUseExpectContinue(params, true);
			HttpProtocolParams.setHttpElementCharset(params, CHARSET);
			HttpProtocolParams.setUserAgent(params, "HttpComponents/1.1");
			// 超时设置
			/* 连接超时 */
			HttpConnectionParams.setConnectionTimeout(params, 6000000);
			/* 请求超时 */
			HttpConnectionParams.setSoTimeout(params, 6000000);
			// 设置我们的HttpClient支持HTTP和HTTPS两种模式
			SchemeRegistry schReg = new SchemeRegistry();
			schReg.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
			schReg.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

			// 使用线程安全的连接管理来创建HttpClient
			/* 从连接池中取连接的超时时间 1000毫秒 */
			PoolingClientConnectionManager conMgr = new PoolingClientConnectionManager(schReg, 1000000, TimeUnit.MILLISECONDS);
			customerHttpClient = new DefaultHttpClient(conMgr, params);

		}
		return customerHttpClient;
	}

	public static String post(String url, Map<String, String> params) {
		try {
			// 编码参数
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
			Set<String> keys = params.keySet();
			for (String key : keys) {
				NameValuePair vlauePair = new BasicNameValuePair(key, params.get(key));
				formparams.add(vlauePair);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET);
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);
			// 发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			String responseText = (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
			if (logger.isDebugEnabled()) {
				logger.debug(responseText);
			}
			return responseText;
		} catch (UnsupportedEncodingException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} finally {

		}
		return null;
	}

	public static HttpResponse postToResponse(String url, Map<String, String> params) {
		try {
			// 编码参数
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
			Set<String> keys = params.keySet();
			for (String key : keys) {
				NameValuePair vlauePair = new BasicNameValuePair(key, params.get(key));
				formparams.add(vlauePair);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET);
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);
			// 发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			return response;
		} catch (UnsupportedEncodingException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static String post(String url, NameValuePair... params) {
		try {
			// 编码参数
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
			for (NameValuePair param : params) {
				formparams.add(param);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET);
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);
			// 发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			String responseText = (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
			if (logger.isDebugEnabled()) {
				logger.debug("response text:" + response);
			}
			return responseText;
		} catch (UnsupportedEncodingException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static String post(String url, String params) {
		try {

			StringEntity entity = new StringEntity(params, CHARSET);
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);
			// 发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			String responseText = (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
			if (logger.isDebugEnabled()) {
				logger.debug("response text:" + response);
			}
			return responseText;
		} catch (UnsupportedEncodingException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static InputStream getStream(String url) {
		try {
			HttpClient httpclient = getHttpClient();
			// 创建一个GET请求
			HttpGet request = new HttpGet(url);
			// 发送GET请求，并将响应内容转换成字符串
			if (logger.isDebugEnabled()) {
				logger.debug(url);
			}
			HttpResponse response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			return resEntity.getContent();
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static String get(String url) {
		try {
			HttpClient httpclient = getHttpClient();
			// 创建一个GET请求
			HttpGet request = new HttpGet(url);
			// 发送GET请求，并将响应内容转换成字符串
			if (logger.isDebugEnabled()) {
				logger.debug(url);
			}
			HttpResponse response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			String responseText = (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
			if (logger.isDebugEnabled()) {
				logger.debug("response text:" + response);
			}
			return responseText;

		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static String get(String url, String... args) {
		String u = url;
		try {
			if (args != null) {
				for (int i = 0, j = args.length; i < j; i++) {
					if (args[i] == null || "".equals(args[i])) {
						u = u.replaceAll("\\{" + i + "\\}", "");
					} else {
						u = u.replaceAll("\\{" + i + "\\}", URLEncoder.encode(args[i], CHARSET));
					}
				}
			}
			HttpClient httpclient = getHttpClient();
			// 创建一个GET请求
			HttpGet request = new HttpGet(url);
			// 发送GET请求，并将响应内容转换成字符串
			if (logger.isDebugEnabled()) {
				logger.debug(url);
			}
			HttpResponse response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			String responseText = (resEntity == null) ? null : EntityUtils.toString(resEntity, CHARSET);
			if (logger.isDebugEnabled()) {
				logger.debug("response text:" + response);
			}
			return responseText;
		} catch (ClientProtocolException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		} catch (IOException e) {
			logger.info(ExceptionUtils.getFullStackTrace(e));
		}
		return null;
	}

	public static void main(String[] args) {

	}

}