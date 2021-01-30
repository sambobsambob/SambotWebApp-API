/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.web.sambot.security.utils.JwtRequest;
import com.api.app.web.sambot.security.utils.JwtResponse;
import com.api.app.web.sambot.security.utils.JwtTokenUtil;
import com.api.app.web.sambot.security.utils.JwtUserDetailsService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest authenticationRequest) {
		Boolean validCredentials = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		if (Boolean.TRUE.equals(validCredentials)) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}
	}
	
	private boolean authenticate(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@PostMapping("/isValidToken")
	public ResponseEntity<String> validateToken(@RequestBody JwtResponse jwtResponse) {
		Boolean validToken = jwtTokenUtil.validateToken(jwtResponse.getToken());
		if (Boolean.TRUE.equals(validToken)) {
			return ResponseEntity.status(HttpStatus.OK).body("Valid Token");
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Token");
		}
	}
}
