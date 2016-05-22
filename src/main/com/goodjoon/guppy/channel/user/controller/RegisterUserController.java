package com.goodjoon.guppy.channel.user.controller;

import java.util.HashMap;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.channel.common.model.DefaultResponse;
import com.goodjoon.guppy.engine.service.user.model.User;
import com.goodjoon.guppy.engine.service.user.proc.RegisterUserProc;
import com.goodjoon.guppy.exception.GuppyException;

@Controller
@RequestMapping(value="/user")
public class RegisterUserController extends BaseController {
	
	@Autowired
	RegisterUserProc registerUserProc;

	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody DefaultResponse registerUser(User user) throws GuppyException {
		
		registerUserProc.registerUser(user);
		
		DefaultResponse response = new DefaultResponse();
		response.setSuccess("OK");
		
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("id", user.getId());
		response.setResult(result);
		
		return response;
	}
}
