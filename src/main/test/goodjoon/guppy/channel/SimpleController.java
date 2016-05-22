package test.goodjoon.guppy.channel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import test.goodjoon.guppy.channel.model.MyFamily;
import test.goodjoon.guppy.channel.model.SimplePostParam;

import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.channel.common.model.DefaultResponse;

@Controller
@RequestMapping("/test")
public class SimpleController extends BaseController{
	
	@RequestMapping(value="/simple", method=RequestMethod.GET)
	public @ResponseBody DefaultResponse simpleGetTest(HttpServletRequest req) {
		debugRequest(req);
		
		DefaultResponse res = new DefaultResponse();
		res.setSuccess("OK");
		res.setResult(new Object() {
			public String getName() {
				return "myName";
			}
			public int getNumber() {
				return 100;
			}
		});
		
		return res;
	}
	
	@RequestMapping(value="/simple/type", method=RequestMethod.POST)
	public @ResponseBody DefaultResponse simplePostTestWithType(MyFamily family, HttpServletRequest req) {
		debugRequest(req);
		
		logger.debug("Family : " + family.getName() + " / " + family.getAge());
		
		DefaultResponse res = new DefaultResponse();
		res.setSuccess("OK");
		res.setResult(new Object() {
			public String getName() {
				return "myName";
			}
			public int getNumber() {
				return 100;
			}
		});
		
		return res;
	}
	
	@RequestMapping(value="/simple", method=RequestMethod.POST)
	public @ResponseBody DefaultResponse simplePostTest(SimplePostParam param, HttpServletRequest req) {
		debugRequest(req);

		logger.debug("RESULT : " + param.getAge() + " / " + param.getName());
		for (String car : param.getCars() )
			logger.debug(car);
		for (int year : param.getYears())
			logger.debug("" + year);
		
		DefaultResponse res = new DefaultResponse();
		res.setSuccess("OK");
		res.setResult(new Object() {
			public String getName() {
				return "myName";
			}
			public int getNumber() {
				return 100;
			}
		});
		
		return res;
	}
}