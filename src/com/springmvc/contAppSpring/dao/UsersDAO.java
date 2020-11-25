 package com.springmvc.contAppSpring.dao;

import java.util.List;

import com.springmvc.contAppSpring.models.User;

public interface UsersDAO {
	
    public boolean saveUser(User user);
    
    public List<User> getAllUsers();
    
    public boolean deleteUserById(int id);
    
    public boolean updateUser(User user);

	public User getUserById(int id);
}
