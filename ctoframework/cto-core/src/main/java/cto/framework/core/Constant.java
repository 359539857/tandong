/**
 * 
 */
package cto.framework.core;

import java.util.concurrent.TimeUnit;

/**
 * @author PeterTan
 * 
 */
public class Constant {

	public static final String ENCODING = "utf-8";
	public static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
	public static final String DEFAULT_RESOURCE_PATTERN = "ServicePlugin.xml";

	public static final String STR_SERVICE_NAME = "serviceName";
	public static final String STR_ACTION_NAME = "actionName";
	public static final String STR_TRANS_NAME = "transName";

	public static final String SUCCSES_CODE = "888";
	public static final String NULL = "null";
	public static final String DATASOURCE = "dataSource";
	public static final String CACHEGROUP = "cachegroup";
	public static final String CONNECTIONS = "connections";
	public static final int DEFAULT_TIMEOUT = 5;
	public static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;
	public static final String CACHE_KEY = "8888-3333-6666-9999";

	public static final String HTTP_SERVLET_REQUEST = "HttpServletRequest";
	public static final String HTTP_SERVLET_RESPONSE = "HttpServletResponse";
	public static final String HTTP_SESSION = "HttpSession";
	public static final String HTTP_APPLICATION = "HttpApplication";

	public static final String APPLICATION_CONFIG = "application_config_file";
	public static final String DEFAULT_ACTION_FRAMEWORK_CONFIG = "classpath:ActionFramework.xml";
	public static final String DEFAULT_SERVICE_FRAMEWORK_CONFIG = "classpath:ServiceFramework.xml";
	public static final String APPLICATION_NAME = "application_name";

	public static final int SQL_QUERY_RECORDSET = 1;
	public static final int SQL_QUERY_RECORD = 2;
	public static final int SQL_QUERY_FEILD = 3;
	
	public static final String RESULT_PATH = "result_path";
	

}
