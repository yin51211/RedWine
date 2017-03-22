package com.wafersystems.cloud.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

/**
 * 
* @ClassName: StrUtil
* @Description: 字符串工具类
* @author harvoo
 */
public final class StrUtil {
	/**
	 * Logger for this class.
	 */
	private static final Logger	LOGGER		= Logger.getLogger(StrUtil.class);

	private static String[]		INITALSTR	= new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
			"A", "b", "B", "c", "C", "d", "D", "e", "E", "BinTreeTraverse2", "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K",
			"l", "L", "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R", "s", "S", "t", "T", "u", "U", "v",
			"V", "w", "W", "x", "X", "y", "Y", "z", "Z" };

	private static Random		RANDOM		= new Random();
	
	/**
	 * Perl5Compiler.
	 */
	private static final PatternCompiler			COMPILER		= new Perl5Compiler();
	/**
	 * Perl5Matcher.
	 */
	private static final PatternMatcher				MATCHER			= new Perl5Matcher();
	/**
	 * 正则表达式缓冲.
	 */
	private static final Map<String, Pattern>		REGEX_PATTERN	= new HashMap<String, Pattern>();

	/**
	 * 
	* @Title: isEmptyStr.
	* @Description: 检查字符串是否空
	* @param str - 检查字串
	* @return boolean
	 */
	public static boolean isEmptyStr(String str) {
		return null == str || "".equals(str.trim()) || "null".equals(str.trim().toLowerCase());
	}

	/**
	 * 
	* @Title: formatStr.
	* @Description: 字符串trim
	* @param str - 字串
	* @return String
	 */
	public static String formatStr(String str) {
		if (null == str || str.equals("null")) {
			return "";
		} else {
			return str.trim();
		}
	}

	/**
	 * 
	* @Title: getLeftBlankStrNum
	* @Description: 数字左边补齐0至指定长度
	* @param value - 数字
	* @param size - 补齐的长度
	* @return String
	 */
	public static String getLeftBlankStrNum(int value, int size) {
		String ret = new Integer(value).toString();
		while (ret.length() < size) {
			ret = "0" + ret;
		}
		return ret;
	}

	/**
	 * 
	* @Title: randomString
	* @Description: 取得指定长度的随机字符串
	* @param strLength - 需要的字符串长度
	* @return String
	 */
	public static String randomString(int strLength) {
		synchronized (StrUtil.class) {
			StringBuffer buffer = new StringBuffer();
			while (strLength > 0) {
				buffer.append(INITALSTR[RANDOM.nextInt(INITALSTR.length)]);
				strLength--;
			}
			return buffer.toString();
		}
	}

	/**
	 * 
	* @Title: isMatch.
	* @Description: 判断是否与给定的模式匹配
	* @param value 给定的字符串
	* @param pattern 给定的模式
	* @return boolean
	* @throws
	 */
	public static synchronized boolean isMatch(String value, String pattern) {
		if (isEmptyStr(value)) {
			return false;
		} else {
			try {
				Pattern pt = null;
				if (REGEX_PATTERN.containsKey(pattern)) {
					pt = REGEX_PATTERN.get(pattern);
				} else {
					// 及时编译模式
					pt = COMPILER.compile(pattern);
					// 缓冲该模式
					REGEX_PATTERN.put(pattern, pt);
					LOGGER.debug("添加模式：" + pattern);
				}

				return MATCHER.matches(value, pt);
			} catch (Exception e) {
				LOGGER.error("正则表达式错误：" + value + "：" + pattern, e);
				return false;
			}
		}
	}
	
	/**
	 * 
	* @Title: getMatchString
	* @Description: 获取正则匹配的字串
	* @param value 给定的字符串
	* @param pattern 给定的模式
	* @return String[]
	 */
	public static synchronized String[] getMatchString(String value, String pattern) {
		if (isEmptyStr(value)) {
			return null;
		} else {
			try {
				Pattern pt = null;
				if (REGEX_PATTERN.containsKey(pattern)) {
					pt = REGEX_PATTERN.get(pattern);
				} else {
					// 及时编译模式
					pt = COMPILER.compile(pattern);
					// 缓冲该模式
					REGEX_PATTERN.put(pattern, pt);
					LOGGER.debug("添加模式：" + pattern);
				}
				if (MATCHER.contains(value, pt)) {
					MatchResult matchResult = MATCHER.getMatch();
					String[] result = new String[matchResult.groups()];
					for (int i = 0; i < result.length; i++) {
						result[i] = matchResult.group(i);
					}
					return result;
				} else {
					return null;
				}
			} catch (Exception e) {
				LOGGER.error("正则表达式错误：" + value + "：" + pattern, e);
				return null;
			}
		}
	}

	/**
	 * .
	* <p>Title: </p>
	* <p>Description: </p>
	 */
	private StrUtil() {
	}

}
