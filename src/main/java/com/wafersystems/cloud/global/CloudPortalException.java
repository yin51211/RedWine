package com.wafersystems.cloud.global;
import java.util.HashMap;
import java.util.Map;

/** 
* @ClassName: CloudPortalException
* @Description: 企业云管理Portal异常类
* @author gelin
*/
public class CloudPortalException extends Exception {

	/**
	* @Fields serialVersionUID : serialVersionUID
	*/
	private static final long	serialVersionUID	= -7031740941156326842L;

	/**
	 * 异常基类描述.
	 */
	public static String PARAM_MESSAGE = "PORTAL EXCEPTION";
	
	/**
	 * 异常类数据缓冲.
	 */
	private Map<String , Object> map;
	
	/**
	 * 基础构造.
	* <p>Title: </p>
	* <p>Description: </p>
	 */
	public CloudPortalException() {
		super(PARAM_MESSAGE);
	}
	
	/**
	 * 基础构造.
	* <p>Title: </p>
	* <p>Description: </p>
	* @param message - 描述
	 */
	public CloudPortalException(String message) {
		super(message == null ? PARAM_MESSAGE : message);
	}
	
	/**
	 * 可添加描述和异常的构造体.
	* <p>Title: </p>
	* <p>Description: </p>
	* @param message - 指定描述
	* @param ex - 指定外部异常
	 */
	public CloudPortalException(String message, Throwable ex) {
		super(message, ex);
	}
	
	/**
	 * 
	* @Title: addParam
	* @Description: 向异常中添加参数
	* @param key - 参数名
	* @param obj - 参数值
	* @return
	* @throws
	 */
	public void addParam(String key, Object obj) {
		if (map == null) {
			map = new HashMap<String , Object>();
		}
		map.put(key, obj);
	}
	
	/**
	 * 
	* @Title: getValue
	* @Description: 获取异常参数中值
	* @param key - 参数名
	* @return Object
	* @throws
	 */
	public Object getValue(String key) {
		if (map != null) {
			return map.get(key);
		} else {
			return null;
		}
	}

}
