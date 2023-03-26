package com.socialMedia.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialMedia.server.repository.PostRepository;
import com.socialMedia.server.model.Post;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/post")
	public List<Post> getAllPost() {
		return postRepo.findAll();
		
	}
	
	@PostMapping("/post")
	public List<Post> newPost(@RequestBody Post post) {
		postRepo.save(post);
		return postRepo.searchByUserIdNot(post.getUserId());
	}
	
	@PostMapping("/postall")
	public List<Post> getPosts(@RequestBody Post post) {
		return postRepo.searchByUserIdNot(post.getUserId());
		
	}
	
	@GetMapping("/home/{userId}")
	public List<Post> getPosts1(@PathVariable String userId) {
		return postRepo.searchByUserIdNot(userId);
		
	}	
	
	@GetMapping("/posts/{userId}/posts")
	public List<Post> getUserPosts(@PathVariable String userId) {
		return postRepo.searchByUserId(userId);
		
	}
	
	@PutMapping("/posts/{postId}/like")
	public Optional<Post> patchLike(@PathVariable String postId, @RequestBody String userId){
		Post post = postRepo.findById(postId).orElse(null);
		if(post.getLikes().contains(userId)) {
			post.getLikes().remove(userId);
		}
		else {
		post.getLikes().add(userId);
		}
		postRepo.save(post);
		return postRepo.findById(postId);
	}

}
