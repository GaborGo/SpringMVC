 package com.springmvc.contAppSpring.service;

import java.util.List;

import com.springmvc.contAppSpring.models.User;

public interface UsersService {
	
   public boolean saveUser(User user);
   
   public boolean deleteUserById(int id);
   
   public List<User> getAllUsers();
   
   public boolean updateUser(User user);
   
   public User getUserById(int id);
}

