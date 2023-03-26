package com.socialMedia.server.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.socialMedia.server.controller.Friend;

@Document(collection = "users")
public class User {
	private String _id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String picturePath;
	private List<Friend> friends;
	private String location;
	private String occupation;
	private List<String> likes;
	private int viewedProfile;
	private int impressions;

	public User() {

	}
	
	@Override
	public String toString() {
		return "User [_id=" + _id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", picturePath=" + picturePath + ", friends=" + friends + ", location="
				+ location + ", occupation=" + occupation + ", likes=" + likes + ", viewedProfile=" + viewedProfile
				+ ", impressions=" + impressions + "]";
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getViewedProfile() {
		return viewedProfile;
	}
	public void setViewedProfile(int viewedProfile) {
		this.viewedProfile = viewedProfile;
	}
	public int getImpressions() {
		return impressions;
	}
	public void setImpressions(int impressions) {
		this.impressions = impressions;
	}

}
