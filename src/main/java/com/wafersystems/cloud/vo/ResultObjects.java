package com.wafersystems.cloud.vo;
import java.io.Serializable;
import java.util.List;

/**
* @ClassName: ResultObjects
* @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
* @author harvoo
*/
public class ResultObjects implements Serializable {

	/**
	* @Fields serialVersionUID : UID
	*/
	private static final long	serialVersionUID	= -6888350415860631689L;
	private List<Object> resObjs;
	/**
	* <p>Title: </p>.
	* <p>Description: </p>
	*/
	public ResultObjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	* <p>Title: </p>.
	* <p>Description: </p>
	* @param resObjs resObjs
	*/
	public ResultObjects(List<Object> resObjs) {
		super();
		this.resObjs = resObjs;
	}
	/**
	 * get the field resObjs.
	 * @return the resObjs
	 */
	public List<Object> getResObjs() {
		return resObjs;
	}
	/**
	 * set the field resObjs.
	 * @param resObjs the resObjs to set
	 */
	public void setResObjs(List<Object> resObjs) {
		this.resObjs = resObjs;
	}
}
