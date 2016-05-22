package com.goodjoon.guppy.engine.service.user.dao;

import com.goodjoon.guppy.engine.common.dao.BaseDao;
import com.goodjoon.guppy.engine.service.user.model.Seller;
import com.goodjoon.guppy.engine.service.user.model.User;

public interface UserDao extends BaseDao {
	Seller getSeller(String sellerId);
	
	void insertUser(User user);
}
