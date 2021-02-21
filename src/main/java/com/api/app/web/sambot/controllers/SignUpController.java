/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.web.sambot.model.UserDetailsEntity;
import com.api.app.web.sambot.repos.UserDetailsRepository;
import com.api.app.web.sambot.requests.SignUpRequest;

@RestController
public class SignUpController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
		boolean usernameExists = userDetailsRepository.findByUsername(signUpRequest.getUsername()) != null;
		boolean emailExists = userDetailsRepository.findByEmail(signUpRequest.getEmail()) != null;
		if (!usernameExists && !emailExists) {
			Date date = new Date();
			try {
				String password = bcryptEncoder.encode(signUpRequest.getPassword());
				UserDetailsEntity userDetails = new UserDetailsEntity(  
						signUpRequest.getUsername(),
						signUpRequest.getEmail(),
						password,
						false,
						false,
						false,
						date.getTime());
				userDetailsRepository.save(userDetails);
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				return ResponseEntity.status(500).build();
			}
		} else {
			return ResponseEntity.status(403).build();
		}
	}

}
