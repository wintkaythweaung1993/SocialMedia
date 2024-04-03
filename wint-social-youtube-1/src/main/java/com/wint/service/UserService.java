package com.wint.service;

import java.util.List;

import com.wint.models.User;

public interface UserService {

	public User registeredUser(User user);
	
	public User findUserByID(Integer userId) throws Exception;
	
	public User findUserByEmail(String email);
	
	public  User followUser(Integer userId1,Integer userId2) throws Exception  ;
	
	public User updateUser(User user,Integer UserId) throws Exception;
	
	public List<User> searchUser(String query) ;
}
