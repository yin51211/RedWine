package com.wafersystems.cloud.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @ClassName: HttpClientUtil
* @Description: HttpClient工具类
* @author Moon
*/
public class HttpClientUtil {

	private static final Logger								LOGGER					= LoggerFactory
																							.getLogger(HttpClientUtil.class);

	private static final MultiThreadedHttpConnectionManager	MANAGER					= new MultiThreadedHttpConnectionManager();

	private static final int								CONNECTION_TIME_OUT		= 20000;

	private static final int								SOCKET_TIME_OUT			= 10000;

	private static final int								MAX_CONNECTION_PERHOST	= 5;

	private static int										MAX_TOTAL_CONNECTIONS	= 40;

	private static boolean									INITIALED				= false;

	/**
	 * 否使用代理.
	 */
	public static boolean									IS_USER_PROXY			= false;
	/**
	* 代理服务器地址. IP:PORT
	*/
	public static String									PROXY					= null;

	/**
	 * 
	* @Title: SetPara
	* @Description: 设置全局参数.
	 */
	public static void setPara() {
		MANAGER.getParams().setConnectionTimeout(CONNECTION_TIME_OUT);
		MANAGER.getParams().setSoTimeout(SOCKET_TIME_OUT);
		MANAGER.getParams().setDefaultMaxConnectionsPerHost(MAX_CONNECTION_PERHOST);
		MANAGER.getParams().setMaxTotalConnections(MAX_TOTAL_CONNECTIONS);
		INITIALED = true;
	}

	/**
	 * getHttpDefaultHeader.
	 * @return String
	 */
	public static List<Header> getHttpDefaultHeader() {
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
		headers.add(new Header("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3"));
		headers.add(new Header("Accept-Encoding", "deflate,sdch"));
		headers.add(new Header("Accept-Language", "zh-CN,zh;q=0.8"));
		headers.add(new Header("Cache-Contro", "max-age=0"));
		headers.add(new Header("Connection", "keep-alive"));
		headers.add(new Header("Cookie", ""));
		headers.add(new Header("Referer", "http://www.google.com"));
		headers.add(new Header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.8 "
				+ "(KHTML, like Gecko; Google Web Preview) Chrome/19.0.1084.36 Safari/536.8"));
		return headers;
	}

	/**
	 * 
	* @Title: getHttpClient
	* @Description: 获得一个HttpClient
	* @return HttpClient
	 */
	public static HttpClient getHttpClient() {
		HttpClient client = new HttpClient(MANAGER);
		client.getHostConfiguration().getParams().setParameter("http.default-headers", getHttpDefaultHeader());
		if (INITIALED) {
			HttpClientUtil.setPara();
		}
		return client;
	}

	/**
	 * 
	* @Title: getGetResponseWithHttpClient
	* @Description: 获取响应数据
	* @param url - 请求的URL
	* @param encode - 请求的编码
	* @return String
	* @throws IOException IOE
	 */
	public static String getGetResponseWithHttpClient(String url, String encode) throws IOException {
		return getGetResponseWithHttpClient(url, encode, IS_USER_PROXY);
	}

	/**
	 * 
	* @Title: getGetResponseWithHttpClient
	* @Description: 获取响应数据
	* @param url - 请求的URL
	* @param encode - 请求的编码
	* @param byProxy - 是否使用代理
	* @return String
	* @throws IOException IOE
	 */
	public static String getGetResponseWithHttpClient(String url, String encode, boolean byProxy) throws IOException {
		return getGetResponseWithHttpClient(url, encode, byProxy, null);
	}

	/**
	 * 
	* @Title: getGetResponseWithHttpClient
	* @Description: 获取响应数据
	* @param url - 请求的URL
	* @param encode - 请求的编码
	* @param byProxy - 是否使用代理
	* @param cookie - cookie值
	* @return String
	* @throws IOException IOE
	 */
	public static String getGetResponseWithHttpClient(String url, String encode, boolean byProxy, String cookie)
			throws IOException {
		HttpClient client = new HttpClient(MANAGER);
		if (byProxy) {
			if (!StringUtils.isEmpty(PROXY)) {
				String[] hostArray = PROXY.split(":");
				client.getHostConfiguration().setProxy(hostArray[0], Integer.parseInt(hostArray[1]));
				client.getParams().setAuthenticationPreemptive(true);
			}
		}

		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.2 (KHTML, like Gecko) "
				+ "Chrome/15.0.854.0 Safari/535.2"));
		headers.add(new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
		headers.add(new Header("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3"));
		headers.add(new Header("Accept-Language", "zh-CN,zh;q=0.8"));
		headers.add(new Header("Cache-Control", "max-age=3600"));
		headers.add(new Header("Connection", "keep-alive"));
		if (!StringUtils.isEmpty(cookie)) {
			headers.add(new Header("Cookie", cookie));
		}
		client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		// 加入连接超时处理，2秒 modified by Gel 2014-03-11
		client.getParams().setParameter("http.socket.timeout", CONNECTION_TIME_OUT);
		client.getParams().setParameter("http.connection.timeout", CONNECTION_TIME_OUT);
		if (INITIALED) {
			HttpClientUtil.setPara();
		}
		GetMethod get = new GetMethod(url);
		get.setFollowRedirects(true);

		String result = null;
		StringBuffer resultBuffer = new StringBuffer();

		try {
			client.executeMethod(get);
			// String strGetResponseBody = post.getResponseBodyAsString();
			BufferedReader in = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream(),
					get.getResponseCharSet()));
			String inputLine = null;

			while ((inputLine = in.readLine()) != null) {
				resultBuffer.append(inputLine);
				resultBuffer.append("\n");
			}
			in.close();
			result = resultBuffer.toString();
			// iso-8859-1 is the default reading encode
			result = HttpClientUtil.converterStringCode(resultBuffer.toString(), get.getResponseCharSet(), encode);

		} finally {
			get.releaseConnection();
		}
		return result;
	}

	/**
	 * 
	* @Title: getPostResponseWithHttpClient
	* @Description: 获取响应数据
	* @param url - 请求的URL
	* @param encode - 请求编码
	* @return String
	 */
	public static String getPostResponseWithHttpClient(String url, String encode) {
		HttpClient client = new HttpClient(MANAGER);

		if (INITIALED) {
			HttpClientUtil.setPara();
		}

		PostMethod post = new PostMethod(url);
		post.setFollowRedirects(false);
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		StringBuffer resultBuffer = new StringBuffer();

		String result = null;

		try {
			client.executeMethod(post);

			BufferedReader in = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream(),
					post.getResponseCharSet()));
			String inputLine = null;

			while ((inputLine = in.readLine()) != null) {
				resultBuffer.append(inputLine);
				resultBuffer.append("\n");
			}

			in.close();

			// iso-8859-1 is the default reading encode
			result = HttpClientUtil.converterStringCode(resultBuffer.toString(), post.getResponseCharSet(), encode);
		} catch (Exception e) {
			LOGGER.error("getPostResponseWithHttpClient Error", e);
			result = "";
		} finally {
			post.releaseConnection();
		}
		return result;
	}

	/**
	 * 
	* @Title: getPostResponseWithHttpClient
	* @Description: 获取响应数据
	* @param url - 请求的URL
	* @param encode - 请求的编码
	* @param nameValuePair - post 参数
	* @return String
	 */
	public static String getPostResponseWithHttpClient(String url, String encode, NameValuePair[] nameValuePair) {
		HttpClient client = new HttpClient(MANAGER);

		if (INITIALED) {
			HttpClientUtil.setPara();
		}

		PostMethod post = new PostMethod(url);
		post.setRequestBody(nameValuePair);
		post.setFollowRedirects(false);
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		String result = null;
		StringBuffer resultBuffer = new StringBuffer();

		try {
			client.executeMethod(post);
			BufferedReader in = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream(),
					post.getResponseCharSet()));
			String inputLine = null;

			while ((inputLine = in.readLine()) != null) {
				resultBuffer.append(inputLine);
				resultBuffer.append("\n");
			}

			in.close();
			// iso-8859-1 is the default reading encode
			result = HttpClientUtil.converterStringCode(resultBuffer.toString(), post.getResponseCharSet(), encode);
		} catch (Exception e) {
			LOGGER.error("getPostResponseWithHttpClient Error", e);

			result = "";
		} finally {
			post.releaseConnection();

		}
		return result;
	}

	/**
	 * 
	* @Title: ConverterStringCode
	* @Description: 字符编码转换
	* @param source - 源
	* @param srcEncode - 源编码
	* @param destEncode - 目标编码
	* @return String
	* @throws UnsupportedEncodingException UnsupportedEncodingException
	 */
	private static String converterStringCode(String source, String srcEncode, String destEncode)
			throws UnsupportedEncodingException {
		return new String(source.getBytes(srcEncode), destEncode);
	}

	public static void main(String[] arg) throws IOException {
		String url = "http://192.168.0.159:8080/wse/deviceif!getPowerState.do?devName=SEP0004F2ED799D&level=11&userName=peteryang&pwd=12345";
		String encode = "utf-8";
		String content = getPostResponseWithHttpClient(url, encode);
		System.out.println(content);
	}
}
