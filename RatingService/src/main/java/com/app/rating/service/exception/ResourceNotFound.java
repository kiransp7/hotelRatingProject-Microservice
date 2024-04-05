package com.app.rating.service.exception;

@SuppressWarnings("all")
public class ResourceNotFound extends RuntimeException {
	
	String Resource;
	String userId;
	public ResourceNotFound(String Resource, String userId) {
		super(Resource + " Not Found ID : " + userId);
		this.Resource = Resource;
		this.userId = userId;
	}
	
	
}
