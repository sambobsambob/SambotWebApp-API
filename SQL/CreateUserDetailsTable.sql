DROP TABLE IF EXISTS user_details;
CREATE TABLE user_details (
username VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
verified BOOLEAN NOT NULL,
premium BOOLEAN NOT NULL,
premium_expires BIGINT NOT NULL
);

INSERT INTO user_details
VALUES ('test','user','pass', true, false, 0);

commit;