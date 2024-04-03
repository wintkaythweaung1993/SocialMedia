package com.wint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Post;
import com.wint.models.User;
import com.wint.repository.PostRepository;
import com.wint.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepository postRepository;
	

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository ;

	@Override
	public Post createNewPost(Post post, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user1 = userService.findUserByID(userId);
		Post newPost= new Post();
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setUser(user1);
		return newPost;
		
		
	}


	@Override
	public String deletePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostbyId(postId);
		User user = userService.findUserByID(userId);
		if(post.getUser().getiD()!= user.getiD())
		{
			throw new Exception ("You can't delete anther user's post");
		}
		postRepository.delete(post);
		return "Post deleted successfully";
	}

	@Override
	public List<Post> findpostByUserId(Integer userId) {
		
		
		
		return postRepository.findPostByuserId(userId);
	}
	


	@Override
	public Post findPostbyId(Integer postId) throws Exception {
		
		Optional<Post> opt = postRepository.findById(postId);
		if(opt.isEmpty())
		{
			throw new Exception ("Post not found " +postId );
		}
		return opt.get();
	}


	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}


	@Override
	public Post savedPost(Integer postId, Integer userId) throws Exception {

		Post post = findPostbyId(postId);
		User user =userService.findUserByID(userId);
		if(user.getSavedPost().contains(post))
		{
			user.getSavedPost().remove(post);
		}
		else 
		{
			user.getSavedPost().add(post);
		}
		
		 userRepository.save(user);
		 return post;
	}


	@Override
	public Post LikePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostbyId(postId);
		User user =userService.findUserByID(userId);
		if (post.getLiked().contains(user))
		{
			post.getLiked().remove(user);
		}
		else 
		{
			post.getLiked().add(user);
		}
	
		return postRepository.save(post);
	}

}
	