/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class UserDetailsEntity {

	@Id
	@NotEmpty
	private String username;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@NotNull
	private boolean verified;
	@NotNull
	private boolean premium;
	@NotNull
	private long premium_expires;
	
	public UserDetailsEntity() {
	}

	public UserDetailsEntity(String username, String email, String password, boolean verified, boolean premium, long premium_expires) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.verified = verified;
		this.premium = premium;
		this.premium_expires = premium_expires;
	}
}
