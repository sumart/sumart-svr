package com.goodjoon.guppy.engine.service.shop.dao;

import com.goodjoon.guppy.engine.common.dao.BaseDao;
import com.goodjoon.guppy.engine.service.shop.model.Shop;

public interface ShopDao extends BaseDao{
	void insertShop(Shop shop);
	void insertShopImages(Shop shop);
}
