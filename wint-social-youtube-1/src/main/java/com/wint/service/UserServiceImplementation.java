package com.wint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.User;
import com.wint.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository ;
	
	@Override
	public User registeredUser(User user) {
		User newUser=new User();
		newUser.setiD(user.getiD());
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}

	@Override
	public User findUserByID(Integer userId) throws Exception{
		
Optional<User> user=userRepository.findById(userId);
		
		if(user.isPresent())
		{
			return user.get();
		}
		throw new Exception("User doesn't exit with" +userId) ; 
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		return user;
	
	}
	

	@Override
	public User updateUser(User user ,Integer userId) throws Exception {
		// TODO Auto-generated method stub
Optional<User> user1 = userRepository.findById(userId);
		
		if (user1.isEmpty())
		{
			throw new Exception("User doesn't exit with this id " +userId);
		}
	
		User oldUser= user1.get();
		if(user.getFirstName()!=null)
		{
			oldUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName()!=null)
		{
			oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null)
		{
			oldUser.setEmail(user.getEmail());
		}
		if(user.getPassword()!=null)
		{
			oldUser.setPassword(user.getPassword());
		}
		
		User updatedUser = userRepository.save(oldUser);
		
		return updatedUser;

	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		
		
		return userRepository.searchUser(query);
	}

	@Override
	public User followUser(Integer userId1, Integer userId2) throws Exception {
		User user1 = findUserByID(userId1);
		User user2= findUserByID(userId2);
	
		user2.getFollowers().add(user1.getiD());
		user1.getFollowings().add(user2.getiD());
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		return user1;
	
	}


	
}
