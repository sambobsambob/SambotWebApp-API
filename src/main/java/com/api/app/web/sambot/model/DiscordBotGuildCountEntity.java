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

@Entity
@Table(name = "discord_bot_guild_count")
public class DiscordBotGuildCountEntity {

	@Id
	@NotEmpty
	private Long count;

	public DiscordBotGuildCountEntity() {
	}

	public DiscordBotGuildCountEntity(Long count) {
		this.count = count;
	}
	
	public Long getCount() {
		return count;
	}
}
