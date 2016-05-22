package com.goodjoon.guppy.engine.service.user.proc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goodjoon.guppy.engine.common.proc.BaseProc;
import com.goodjoon.guppy.engine.service.user.dao.UserDao;
import com.goodjoon.guppy.engine.service.user.model.User;

@Component
public class RegisterUserProc extends BaseProc {
	
	@Autowired
	UserDao userDao;
	
	public void registerUser(User user) {
		userDao.insertUser(user);
	}
}
