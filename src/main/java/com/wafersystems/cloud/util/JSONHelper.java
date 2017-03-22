package com.wafersystems.cloud.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JSONHelper {
	
		
	public static void writeJSON(HttpServletResponse response,Object obj){
		JSONObject json = JSONObject.fromObject(obj);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
