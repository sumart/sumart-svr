package com.goodjoon.guppy.channel.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.channel.common.model.DefaultResponse;
import com.goodjoon.guppy.engine.service.shop.model.RadiusShopSearchParam;
import com.goodjoon.guppy.engine.service.shop.model.SimpleShop;

@Controller
@RequestMapping("/shop")
public class GetShopController extends BaseController {
	
	@RequestMapping(value="/list/radius", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody DefaultResponse getShopListByRadius(RadiusShopSearchParam searchParam, HttpServletRequest req) {
		debugRequest(req);
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			logger.debug("serchParam : " + jsonMapper.writeValueAsString(searchParam));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		ArrayList<SimpleShop> simpleShopList = new ArrayList<SimpleShop>();
		
		SimpleShop simpleShop = new SimpleShop();
		simpleShop.setName("쭌이네분식");
		simpleShop.setCoordLat(Double.valueOf(37.495001));
		simpleShop.setCoordLong(Double.valueOf(126.752174));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("001,005,091");
		simpleShopList.add(simpleShop);
		
		//37.493647,126.752088
		simpleShop = new SimpleShop();
		simpleShop.setName("개미네부동산");
		simpleShop.setCoordLat(Double.valueOf(37.493647));
		simpleShop.setCoordLong(Double.valueOf(126.752088));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("010,201,111");
		simpleShopList.add(simpleShop);
		
		//37.49329,126.754577
		simpleShop = new SimpleShop();
		simpleShop.setName("가자주류백화점");
		simpleShop.setCoordLat(Double.valueOf(37.49329));
		simpleShop.setCoordLong(Double.valueOf(126.754577));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("010,201,111");
		simpleShopList.add(simpleShop);

		//37.491341,126.75168
		simpleShop = new SimpleShop();
		simpleShop.setName("없는거빼고 다 있는 우리내 닭갈비집");
		simpleShop.setCoordLat(Double.valueOf(37.491341));
		simpleShop.setCoordLong(Double.valueOf(126.75168));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("002,003,121");
		simpleShopList.add(simpleShop);
		
		//37.490668,126.751809
		simpleShop = new SimpleShop();
		simpleShop.setName("Simple But Elegant 커피타운");
		simpleShop.setCoordLat(Double.valueOf(37.490668));
		simpleShop.setCoordLong(Double.valueOf(126.751809));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("041,001,888");
		simpleShopList.add(simpleShop);
		
		//37.490081,126.752635
		simpleShop = new SimpleShop();
		simpleShop.setName("만물백화점 - 1000냥도 아까운집");
		simpleShop.setCoordLat(Double.valueOf(37.490081));
		simpleShop.setCoordLong(Double.valueOf(126.752635));
		simpleShop.setPhone("01033111188");
		simpleShop.setCategory("033,027,008");
		simpleShopList.add(simpleShop);
		
		DefaultResponse response = new DefaultResponse();
		response.setResult(simpleShopList);
		
		response.setSuccess("OK");
		
		try {
			logger.debug("결과 : " + jsonMapper.writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response; 
	}
}
