package com.wint.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Integer PostID;


private String Caption;

private String image ;

private String Video;

@ManyToOne
private User user ;

private LocalDateTime createdAt;

@OneToMany
private List<User> liked = new ArrayList<>();



/**
 * 
 */
public Post() {
	super();
}

/**
 * @param postID
 * @param caption
 * @param image
 * @param video
 * @param user
 * @param createdAt
 */
public Integer getPostID() {
	return PostID;
}

public void setPostID(Integer postID) {
	PostID = postID;
}

public String getCaption() {
	return Caption;
}

public void setCaption(String caption) {
	Caption = caption;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getVideo() {
	return Video;
}

public void setVideo(String video) {
	Video = video;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public LocalDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

public List<User> getLiked() {
	return liked;
}

public void setLiked(List<User> liked) {
	this.liked = liked;
}

/**
 * @param postID
 * @param caption
 * @param image
 * @param video
 * @param user
 * @param createdAt
 */





}