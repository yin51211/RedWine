package com.wafersystems.cloud.vo;
import java.io.Serializable;

/**
* @ClassName: SuccessResult
* @Description: 鎺ュ彛鎴愬姛杩斿洖瀵硅薄
* @author harvoo
*/
public class SuccessResult implements Serializable {

	/**
	* @Fields serialVersionUID : UID
	*/
	private static final long	serialVersionUID	= 2567509762836533060L;

	private Integer result;
	private Object data;
	
	/** 
	 * <p>Title: </p>.
	 * <p>Description: </p>
	 */
	public SuccessResult() {
	}
	
	/** 
	* <p>Title: </p>.
	* <p>Description: </p>
	* @param result 鐘舵€佷綅
	* @param data 杩斿洖鐨勬暟鎹?
	*/
	public SuccessResult(Integer result, Object data) {
		this.result = result;
		this.data = data;
	}
	
	/**
	 * get the field result.
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	/**
	 * set the field result.
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
	/**
	 * get the field data.
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * set the field data.
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
