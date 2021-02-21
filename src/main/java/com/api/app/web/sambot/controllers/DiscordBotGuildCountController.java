/************************************************************************** 
 * Copyright (C) 2021 Sam Canham
 * Unauthorised copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Sam Canham <canhamsam@gmail.com>, January 2021
 **************************************************************************/
package com.api.app.web.sambot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.web.sambot.model.DiscordBotGuildCountEntity;
import com.api.app.web.sambot.repos.DiscordBotGuildCountRepository;

@RestController
public class DiscordBotGuildCountController {

	@Autowired
	private DiscordBotGuildCountRepository discordBotGuildCountRepository;
	
	@GetMapping("/getDiscordBotGuildCount")
	public String getDiscordBotGuildCount() {
		List<DiscordBotGuildCountEntity> data = discordBotGuildCountRepository.findAll();
		if (!data.isEmpty()) {
			return ""+data.get(0).getCount();
		} else {
			return "0";
		}
	}
	
}
