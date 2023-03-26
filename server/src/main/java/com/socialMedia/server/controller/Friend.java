package com.socialMedia.server.controller;

public class Friend {
	
	private String id;
	private String name;
	private String occupation;
	private String picturePath;
	
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", occupation=" + occupation + ", picturePath=" + picturePath
				+ "]";
	}
	public Friend() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
}
