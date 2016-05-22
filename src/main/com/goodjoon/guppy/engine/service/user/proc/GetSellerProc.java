package com.goodjoon.guppy.engine.service.user.proc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goodjoon.guppy.engine.common.proc.BaseProc;
import com.goodjoon.guppy.engine.service.user.dao.UserDao;
import com.goodjoon.guppy.engine.service.user.model.Seller;

@Component
public class GetSellerProc extends BaseProc {
	
	@Autowired
	UserDao sellerDao;
	
	public Seller getSeller(String sellerId) {
		return sellerDao.getSeller(sellerId);
	}
}
