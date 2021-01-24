/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.web.sambot.model.UserDetailsEntity;
import com.api.app.web.sambot.repos.UserDetailsRepository;
import com.api.app.web.sambot.requests.SignUpRequest;

@RestController
public class SignUpController {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@PostMapping("/signUp")
	public HttpStatus signUp(@RequestBody SignUpRequest signUpRequest) {
		System.out.println(signUpRequest.getUsername());
		try {
			UserDetailsEntity userDetails = new UserDetailsEntity(  
					signUpRequest.getUsername(),
					signUpRequest.getEmail(),
					signUpRequest.getPassword(),
					signUpRequest.getVerified(),
					signUpRequest.getPremium(),
					signUpRequest.getPremiumExpires());
			userDetailsRepository.save(userDetails);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

}
