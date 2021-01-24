/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.requests;

public class SignUpRequest {
	
	private String username;
	private String email;
	private String password;
	private boolean verified;
	private Boolean premium;
	private long premium_expires;
	
	SignUpRequest() {
	}

	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getVerified() {
		return verified;
	}
	
	public boolean getPremium() {
		return premium;
	}
	
	public long getPremiumExpires() {
		return premium_expires;
	}
}
