package com.wafersystems.cloud.global;

import java.util.HashMap;
import java.util.Map;

public class ReturnData {
	public static Object getArrayData(Object o) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resObjs", o);
		returnMap.put("result", GlobalConstant.RESULT_SUCCESS);
		returnMap.put("data", dataMap);
		return returnMap;
	}

	public static Object getObjData(Object o) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resObj", o);
		returnMap.put("result", GlobalConstant.RESULT_SUCCESS);
		returnMap.put("data", dataMap);
		return returnMap;
	}
}
