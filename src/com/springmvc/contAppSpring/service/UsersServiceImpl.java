package com.springmvc.contAppSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.contAppSpring.dao.UsersDAO;
import com.springmvc.contAppSpring.models.User;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	@Transactional
	public boolean saveUser(User user) {
		return usersDAO.saveUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	@Transactional
	public boolean deleteUserById(int id) {
		return usersDAO.deleteUserById(id);
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
	    return usersDAO.updateUser(user);
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return usersDAO.getUserById(id);
	}
	
	

}
