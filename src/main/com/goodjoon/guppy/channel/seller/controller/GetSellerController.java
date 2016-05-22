package com.goodjoon.guppy.channel.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.engine.service.user.model.Seller;
import com.goodjoon.guppy.engine.service.user.proc.GetSellerProc;

@Controller
@RequestMapping(value="/seller", method=RequestMethod.GET)
public class GetSellerController extends BaseController {
	@Autowired
	protected GetSellerProc getSellerProc;
	
	@RequestMapping("/{sellerId}")
	public @ResponseBody Seller getSeller(@PathVariable String sellerId) {
		return getSellerProc.getSeller(sellerId);
	}
}
