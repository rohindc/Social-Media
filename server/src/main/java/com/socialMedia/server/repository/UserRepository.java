package com.socialMedia.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.socialMedia.server.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User searchByEmailAndPassword(String email, String password);

	User searchBy_id(String _id);
	
	@Query("{ 'id' : ?0 }")
    User addFriend(String id, String friendName);

}
