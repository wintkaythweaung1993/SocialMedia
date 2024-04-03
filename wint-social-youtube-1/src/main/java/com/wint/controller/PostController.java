package com.wint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.protocol.x.Ok;
import com.wint.models.Post;
import com.wint.response.ApiResponse;
import com.wint.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/posts/user/{userId}")
	public ResponseEntity<Post> createPost(@RequestBody Post post ,@PathVariable Integer userId) throws Exception
	{
		Post createdPost = postService.createNewPost(post, userId);
		return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId , @PathVariable Integer userId) throws Exception
	{
		String message = postService.deletePost(postId, userId);
		ApiResponse res= new ApiResponse(message,true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception
	{
		Post post = postService.findPostbyId(postId);
		
	 return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/posts/user/{userId}")
	public ResponseEntity<List<Post>>findUserPost(@PathVariable Integer userId)
	{
		List <Post> posts = postService.findpostByUserId(userId);
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
		
	}
	@GetMapping("/posts")
	public ResponseEntity<List<Post>>findAllPost()
	{
		List <Post> posts = postService.findAllPost();
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
		
	}
	///////
	
	
	@PutMapping("/posts/{postId}/user/{userId}")
	public ResponseEntity<Post>SavePostHandler(@PathVariable Integer postId ,@PathVariable Integer userId) throws Exception
	{
		Post post= postService.savedPost(postId, userId);
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}


	@PutMapping("/posts/like/{postId}/user/{userId}")
	public ResponseEntity<Post>LikePostHandler(@PathVariable Integer postId ,@PathVariable Integer userId) throws Exception
	{
		Post post= postService.LikePost(postId, userId);
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
}
