package com.wafersystems.cloud.vo;
import java.io.Serializable;

/**
* @ClassName: ResultObject
* @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
* @author harvoo
*/
public class ResultObject implements Serializable {

	/**
	* @Fields serialVersionUID : UID
	*/
	private static final long	serialVersionUID	= 3426106905515292943L;
	private Object resObj;
	/**
	* <p>Title: </p>.
	* <p>Description: </p>
	*/
	public ResultObject() {
		// TODO Auto-generated constructor stub
	}
	/**
	* <p>Title: </p>.
	* <p>Description: </p>
	* @param resObj resObj
	*/
	public ResultObject(Object resObj) {
		super();
		this.resObj = resObj;
	}
	/**
	 * get the field resObj.
	 * @return the resObj
	 */
	public Object getResObj() {
		return resObj;
	}
	/**
	 * set the field resObj.
	 * @param resObj the resObj to set
	 */
	public void setResObj(Object resObj) {
		this.resObj = resObj;
	}
}
