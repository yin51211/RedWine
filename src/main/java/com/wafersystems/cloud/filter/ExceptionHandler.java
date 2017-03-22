package com.wafersystems.cloud.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wafersystems.cloud.global.GlobalConstant;
import com.wafersystems.cloud.vo.ReturnMsg;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class ExceptionHandler implements HandlerExceptionResolver {
	private static final Logger LOGGER = Logger
			.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(new ReturnMsg(GlobalConstant.RESULT_FAIL, "后台捕获全局异常:"+e.getMessage()+"，请联系后台开发人员检查！"));
			LOGGER.error(e.getMessage(), e);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
		} finally {
			out.close();
		}
		return null;
	}

}