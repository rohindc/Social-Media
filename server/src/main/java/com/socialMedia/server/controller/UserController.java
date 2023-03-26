package com.socialMedia.server.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialMedia.server.model.User;
import com.socialMedia.server.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/user/{_id}")
	public Optional<User> getUserById(@PathVariable String _id) {
		return userRepo.findById(_id);
	}

	@PostMapping("/user")
	public User getUser(@RequestBody User user) {
		return userRepo.searchByEmailAndPassword(user.getEmail(), user.getPassword());

	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userRepo.save(user);
	}

	@PutMapping("/{_id}/addFriend/{friendId}")
	public List<Friend> addFriend(@PathVariable String _id, @PathVariable String friendId) {
		User user = userRepo.findById(_id).orElse(null);
		boolean check = false;
		Friend frnd = null;
		for (Friend friend : user.getFriends()) {
	        if (friend.getId().equals(friendId)) {
	        	check = true;
	        	frnd = friend;
	        	break;
	        }
	    }
		if(check && frnd != null) {
			user.getFriends().remove(frnd);
			userRepo.save(user);
		}
		else {
			user.getFriends().add(updatedFriend(friendId));
			userRepo.save(user);
		}
		
		return user.getFriends();
	}
	
	public Friend updatedFriend (String id) {
		User user = userRepo.findById(id).orElse(null);
		Friend friend = new Friend();
		friend.setId(id);
		friend.setName(user.getFirstName() +" " +user.getLastName());
		friend.setOccupation(user.getOccupation());
		friend.setPicturePath(user.getPicturePath());
		return friend;
	}
	
	
	@GetMapping("/users/{_id}/friends")
	public List<Friend> getFriends(@PathVariable String _id) {
		User user = userRepo.findById(_id).orElse(null);

		return user.getFriends();
	}

}
