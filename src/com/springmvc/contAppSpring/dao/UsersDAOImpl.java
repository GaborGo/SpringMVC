package com.springmvc.contAppSpring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.springmvc.contAppSpring.models.User;

@Repository
public class UsersDAOImpl implements UsersDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public boolean saveUser(User user) {
			boolean saveFlag = true;
			try {
				Session currentSession = sessionFactory.getCurrentSession();
				currentSession.save(user);
			} catch (Exception ex) {
				ex.printStackTrace();
				saveFlag = false;
			}
		    return saveFlag;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			Query<User> query = currentSession.createQuery("From User", User.class);
			users = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean deleteUserById(int id) {
		boolean deleteFlag = true;
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			User user = (User)currentSession.load(User.class, id);
		    currentSession.delete(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updateFlag = true;
		User userToUpdate;
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			userToUpdate = (User)currentSession.load(User.class, user.getId());
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setRole(user.getRole());
			userToUpdate.setFirmId(user.getFirmId());
			currentSession.update(userToUpdate);
		} catch (Exception ex) {
			updateFlag = false;
			ex.printStackTrace();
		}
		return updateFlag;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			user = (User)currentSession.load(User.class, id);
		} catch (Exception ex) {
		ex.printStackTrace();
	}
		return user;
	}
}
	



