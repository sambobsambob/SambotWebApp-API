DB = sambot_webapp

DROP TABLE IF EXISTS user_details;
DROP TABLE IF EXISTS discord_bot_guild_count;

CREATE TABLE user_details (
username VARCHAR(255) PRIMARY KEY,
email VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
admin BOOLEAN NOT NULL,
verified BOOLEAN NOT NULL,
premium BOOLEAN NOT NULL,
premium_expires BIGINT NOT NULL
);

CREATE TABLE discord_bot_guild_count (
count INT NOT NULL
);

commit;
