package com.goodjoon.guppy.engine.service.shop.proc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goodjoon.guppy.engine.common.proc.BaseProc;
import com.goodjoon.guppy.engine.common.util.DataUtils;
import com.goodjoon.guppy.engine.service.shop.dao.ShopDao;
import com.goodjoon.guppy.engine.service.shop.model.Shop;
import com.goodjoon.guppy.engine.service.user.dao.UserDao;
import com.goodjoon.guppy.engine.service.user.model.Seller;
import com.goodjoon.guppy.exception.BizException;
import com.goodjoon.guppy.exception.GuppyException;

@Component
public class RegisterShopProc extends BaseProc {
	@Autowired
	protected ShopDao shopDao;
	
	@Autowired
	protected UserDao sellerDao;
	
	@Transactional
	public String registerShop(Shop shop) throws BizException{
		// 사용자 Validation
		Seller seller = sellerDao.getSeller(shop.getUserId());
		if (seller == null)
			throw new BizException("일치하는 사용자가 없습니다");
		
		// Shop ID 생성
		shop.setId(DataUtils.makeRandomUUIDString(true));
		
		// Shop 기본 저장 
		shopDao.insertShop(shop);
		
		// Shop 좌표 저장 
		
		
		// Shop-Staff 저장
		
		return shop.getId();
	}
	
	public void registerShopImages(Shop shop) throws BizException {
		shopDao.insertShopImages(shop);
	}
}
