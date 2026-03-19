package com.projeto.teste.dto;

public class PostDTO {
	private Long id;
	private String title;
	private String description;
	private String imgURL;
	private Long user_id;
	private String postType;
	
	
	public Long getId() {
		return id;
	}
	
	

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser(Long user_id) {
		this.user_id = user_id;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}



	public String getPostType() {
		return postType;
	}



	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	
	
	
	
	
	

}
