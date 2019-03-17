package com.jaceksysiak.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaceksysiak.spring.web.dao.User;
import com.jaceksysiak.spring.web.dao.UsersDao;


@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao;
	
	@Autowired
	public void setUsersDAO(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

 
	public void create(User user) {
		usersDao.create(user);
		
	}

 
}





































