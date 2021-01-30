/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.app.web.sambot.model.UserDetailsEntity;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, String> {

	UserDetailsEntity findByUsername(String username);
	UserDetailsEntity findByEmail(String email);
}
