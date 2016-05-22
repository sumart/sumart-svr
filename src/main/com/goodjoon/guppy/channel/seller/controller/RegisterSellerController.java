package com.goodjoon.guppy.channel.seller.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.channel.common.model.DefaultResponse;
import com.goodjoon.guppy.engine.service.user.model.Seller;
import com.goodjoon.guppy.exception.GuppyException;

/**
 * 상인으로 전화등록 하는 Business 처리하는 API
 * @author korean44
 *
 */
@Controller
@RequestMapping(value="/seller", method=RequestMethod.POST)
public class RegisterSellerController extends BaseController{
	
	@RequestMapping
	public @ResponseBody DefaultResponse registerSeller(Seller seller, HttpServletRequest req) throws GuppyException {
		
		
		return null;
	}
}
