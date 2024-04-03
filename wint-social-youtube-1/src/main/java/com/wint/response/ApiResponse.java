package com.wint.response;

public class ApiResponse {
	private String message;
	private boolean status;
	/**
	 * 
	 */
	
	/**
	 * @param b 
	 * @param message2 
	 * @param message
	 * @param status
	 */
	
	public ApiResponse(String message2, boolean b) {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
