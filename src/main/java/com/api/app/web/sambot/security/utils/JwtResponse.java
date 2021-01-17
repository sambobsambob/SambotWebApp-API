/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.security.utils;

public class JwtResponse {

	private final String token;
	
	public JwtResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
