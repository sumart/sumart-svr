package com.goodjoon.guppy.channel.common.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected void debugRequest(MultipartRequest req) {
		Map<String, MultipartFile> fileMap = req.getFileMap();
		Set<String> keySet = fileMap.keySet();
		for (String keyName : keySet) {
			MultipartFile file = fileMap.get(keyName);
			logger.debug("==== File Attached ====");
			logger.debug("-- Content Type : " + file.getContentType());
			logger.debug("-- Name : " + file.getName());
			logger.debug("-- Original Name : " + file.getOriginalFilename());
			logger.debug("-- Size : " + file.getSize());
		}
	}
	
	protected void debugRequest(HttpServletRequest req) {
		Enumeration e = req.getHeaderNames();
		logger.debug("==== request Debug =====");
		logger.debug("[HEADER]");
		while(e.hasMoreElements()) {
			String headerName = e.nextElement().toString();
			logger.debug(headerName + " : " + req.getHeader(headerName));
		}
		
		logger.debug("[PARAMETER]");
		Map paramMap = req.getParameterMap();
		Object[] p = paramMap.keySet().toArray(); // paramMap 은 무조건 Parameter 를 key = [value] 처럼, Array 로 갖고있음.
		for (Object key : p) {
			if (paramMap.get(key) instanceof Object[]) {
				Object[] oa = (Object[])paramMap.get(key);
				if (oa.length > 1)
					logger.debug(key + " = " + Arrays.toString(oa));
				else
					logger.debug(key + " = " + oa[0]);
			} else {
				logger.debug(key + " = " + paramMap.get(key));
			}
		}
		
//		logger.debug("[ATTRIBUTES]");
//		e = req.getAttributeNames();
//		while(e.hasMoreElements()) {
//			String attributeName = e.nextElement().toString();
//			logger.debug(attributeName + " : " + req.getAttribute(attributeName));
//		}
		
		logger.debug("\n");
	}
}
