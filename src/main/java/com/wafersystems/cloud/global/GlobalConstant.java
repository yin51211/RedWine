/**
 * @Title: GlobalConstant.java
 * @Package com.wafersystems.cloud.office
 * @Description: Portal常量定义存储文件
 * @author Moon
 * @date 2013-4-15 下午5:30:03
 */
package com.wafersystems.cloud.global;

/** 
* @ClassName: GlobalConstant
* @Description: Portal常量定义
* @author Moon
*/
public final class GlobalConstant {

	/**
	 * Token分割符.
	 */
	public static final String	DIVIDER							= "=";

	public static final String	MARK							= "woc";

	public static final String	WSM_KEY							= "wafer";
	
	public static final Short USER_STATE_NORMAL                 = 1;
	
	public static final Short USER_STATE_DELETED                = 0;
	/**
	 * 成功状态位.
	 */
	public static final Integer	RESULT_SUCCESS					= 0;
	/**
	 * 失败状态位.
	 */
	public static final Integer	RESULT_FAIL						= 1;
	
	public static final String CONTACTS_PATH = "../../webapps/ROOT";
	
	public static final String UPLOAD_BILLS = "../bills";
	
}
