/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.dao;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class UserDetails {

		@Id
		@NotEmpty
		private String username;
		@NotEmpty
		private String password;
		@NotEmpty
		private String email;
		@NotEmpty
		private boolean verified;
		@NotEmpty
		private Date premium_ends;
		
		public UserDetails() {
		}
		
		public UserDetails(String username) {
			this.username = username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getUsername() {
			return username;
		}
}
