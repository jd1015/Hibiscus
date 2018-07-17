
/* Drop Tables */

DROP TABLE IF EXISTS t_login;
DROP TABLE IF EXISTS t_user;




/* Create Tables */

CREATE TABLE t_login
(
	login_id bigserial NOT NULL,
	-- ユーザーID
	user_id bigint NOT NULL,
	access_token varchar DEFAULT 'dummy' NOT NULL UNIQUE,
	refresh_token varchar DEFAULT 'dummy' NOT NULL UNIQUE,
	expired_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (login_id)
) WITHOUT OIDS;


CREATE TABLE t_user
(
	-- ユーザーID
	user_id bigint NOT NULL,
	user_code varchar UNIQUE,
	hash_password varchar DEFAULT 'dummy' NOT NULL,
	salt varchar DEFAULT 'dummy' NOT NULL,
	created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (user_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE t_login
	ADD FOREIGN KEY (user_id)
	REFERENCES t_user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON COLUMN t_login.user_id IS 'ユーザーID';
COMMENT ON COLUMN t_user.user_id IS 'ユーザーID';



