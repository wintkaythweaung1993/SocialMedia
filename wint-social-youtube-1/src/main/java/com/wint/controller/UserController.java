package com.wint.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wint.models.User;
import com.wint.repository.UserRepository;
import com.wint.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User CreateUser(@RequestBody User user)
	{	
		
		User savedUser = userService.registeredUser(user);
		return savedUser;
	}
	
	
	@GetMapping("/users")
	public List<User> getUser()
	{	
		List<User> users=userRepository.findAll();
		return users;
		
	}
	
	public User getUser(@PathVariable("userId")Integer id)
	{
		
		
		
		return null; 
	}
	
	
	
	@GetMapping("users/{userId}")
	public User getUserById(@PathVariable("userId")Integer id)throws Exception
	{
	User user=userService.findUserByID(id);
	return user;
	
	}
	
	
	
	@PutMapping("/users/{userId}")
	public User UpdateUser(@RequestBody User user,@PathVariable Integer userId)throws Exception
	{
	 User UpdatedUser = userService.updateUser(user, userId);
	 return UpdatedUser;
	}
	
	@PutMapping("/users/follow/{userId1}/{userId2}")
	public User followUserHandler(@PathVariable Integer userId1,@PathVariable Integer userId2) throws Exception {
		User user= userService.followUser(userId1, userId2);
		return user;
	}
	
	
	
	@GetMapping("/users/search")
	public List<User> searchUser(@RequestParam ("query")String query){
		List<User> users = userService.searchUser(query);
		
		return users;
	}
	
	
	
	
	
	
	
//	@DeleteMapping("users/{userId}")
//	public String DeleteUser(@PathVariable ("userId")Integer userId) throws Exception
//	{
//		 Optional<User> user = userRepository.findById(userId);
//		 if (user.isEmpty())
//			{
//				throw new Exception("User doesn't exit with this id " +userId);
//			}
//		 userRepository.delete(user.get());
//		 return "User deleted succesfully with id "+ userId;
//		
//	}
}
