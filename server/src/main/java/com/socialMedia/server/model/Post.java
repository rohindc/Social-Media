package com.socialMedia.server.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {
	private String _id;
	private String userId;
	private String firstName;
	private String lastName;
	private String location;
	private String description;
	private String picturePath;
	private String userPicturePath;
	private List<String> likes;
	private String Comment [];
	
	public Post() {
		
	}

	@Override
	public String toString() {
		return "Post [_id=" + _id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", location=" + location + ", description=" + description + ", picturePath=" + picturePath
				+ ", userPicturePath=" + userPicturePath + ", likes=" + likes + ", Comment=" + Arrays.toString(Comment)
				+ "]";
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getUserPicturePath() {
		return userPicturePath;
	}
	public void setUserPicturePath(String userPicturePath) {
		this.userPicturePath = userPicturePath;
	}
	public String[] getComment() {
		return Comment;
	}
	public void setComment(String[] comment) {
		Comment = comment;
	}
	

}
