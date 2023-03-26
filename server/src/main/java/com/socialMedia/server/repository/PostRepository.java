package com.socialMedia.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialMedia.server.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> searchByUserIdNot(String userId);
	
	List<Post> searchByUserId(String userId);
}
