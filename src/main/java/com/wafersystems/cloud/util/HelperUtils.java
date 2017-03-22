package com.wafersystems.cloud.util;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: roc
 * Date: 13-7-31
 * Time: 下午2:07
 * Email: liu.pengcheng@live.cn
 */
public final class HelperUtils {

	/**
	 * 
	* @Title: getLocaleByStr
	* @Description: 获取本地语言资源
	* @param lang - 语言
	* @return Locale
	 */
    public static Locale getLocaleByStr(String lang) {
        Locale locale = null;
        if (StrUtil.isEmptyStr(lang)) {
        	locale = Locale.CHINA;
        } else {
        	if (lang.startsWith("en")) {
                locale = Locale.ENGLISH;
            } else if (lang.equals("zh_CN")) {
                locale = Locale.CHINA;
            } else if (lang.equals("zh_HK")) {
                locale = Locale.TRADITIONAL_CHINESE;
            }
        }
        return locale;
    }

    /**
     * .
    * <p>Title: </p>
    * <p>Description: </p>
     */
    private HelperUtils() {
    }
}
