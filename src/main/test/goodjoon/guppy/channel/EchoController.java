package test.goodjoon.guppy.channel;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.goodjoon.guppy.channel.common.controller.BaseController;

@Controller
@RequestMapping("/echo")
public class EchoController extends BaseController {
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> echoGet(@RequestParam LinkedHashMap<String, Object> reqParam, 
			HttpServletRequest req) {
		debugRequest(req);
		
		return req.getParameterMap();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Map<String, Object> echoPost(MultipartRequest multipart, HttpServletRequest req) {
		debugRequest(req);
		debugRequest(multipart);
		
		Map<String, Object> map = req.getParameterMap();
		
		Map<String, MultipartFile> mmap = multipart.getFileMap();
		for (String keyName : mmap.keySet()) {
			map.put(keyName, "" + mmap.get(keyName).getOriginalFilename() + " / " +  mmap.get(keyName).getSize() + 
					" bytes / Content Type : " + mmap.get(keyName).getContentType());
		}
		
		return map;
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes={"application/x-www-form-urlencoded"})
	public @ResponseBody Map<String, Object> echoPost(HttpServletRequest req) {
		debugRequest(req);
		
		return req.getParameterMap();
	}
}
