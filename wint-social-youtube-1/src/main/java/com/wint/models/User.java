package com.wint.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID; 
	//@Column(name="my_name")
    private String FirstName;
	private String lastName; 
	private  String email;
	private String password;
	private  String gender;
	
	
	private List<Integer> followers = new ArrayList<>();;
	
	private List<Integer> followings = new ArrayList<>();
	
	@ManyToMany
	private List<Post>savedPost= new ArrayList<>();
	

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param gender
	 * @param followers
	 * @param followings
	 */
	public User(Integer iD, String firstName, String lastName, String email, String password, String gender,
			List<Integer> followers, List<Integer> followings) {
		super();
		this.ID = iD;
		FirstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.followers = followers;
		this.followings = followings;
	}




	public Integer getiD() {
		return ID;
	}




	public void setiD(Integer iD) {
		this.ID = iD;
	}




	public String getFirstName() {
		return FirstName;
	}




	public void setFirstName(String firstName) {
		FirstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public List<Integer> getFollowers() {
		return followers;
	}




	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}




	public List<Integer> getFollowings() {
		return followings;
	}




	public void setFollowings(List<Integer> followings) {
		this.followings = followings;
	}




	public Integer getID() {
		return ID;
	}




	public void setID(Integer iD) {
		ID = iD;
	}




	public List<Post> getSavedPost() {
		return savedPost;
	}




	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}
	
	
	
}
	