
/* Drop Tables */

DROP TABLE IF EXISTS t_material;
DROP TABLE IF EXISTS t_theme;




/* Create Tables */

-- ネタテーブル
CREATE TABLE t_material
(
	-- テーマID
	theme_id bigint NOT NULL,
	-- ネタID
	material_id bigint NOT NULL,
	-- 名前
	title varchar,
	-- 内容
	content varchar,
	UNIQUE (theme_id, material_id)
) WITHOUT OIDS;


-- テーマ
CREATE TABLE t_theme
(
	-- テーマID
	theme_id bigserial NOT NULL,
	-- 名前
	title varchar DEFAULT '',
	-- 内容
	content varchar,
	PRIMARY KEY (theme_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE t_material
	ADD FOREIGN KEY (theme_id)
	REFERENCES t_theme (theme_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON TABLE t_material IS 'ネタテーブル';
COMMENT ON COLUMN t_material.theme_id IS 'テーマID';
COMMENT ON COLUMN t_material.material_id IS 'ネタID';
COMMENT ON COLUMN t_material.title IS '名前';
COMMENT ON COLUMN t_material.content IS '内容';
COMMENT ON TABLE t_theme IS 'テーマ';
COMMENT ON COLUMN t_theme.theme_id IS 'テーマID';
COMMENT ON COLUMN t_theme.title IS '名前';
COMMENT ON COLUMN t_theme.content IS '内容';

/* contentを表示するかどうかのフラグ */
ALTER TABLE t_theme ADD COLUMN content_display_flg boolean DEFAULT true;
COMMENT ON COLUMN t_theme.content_display_flg IS 'falseの場合contentを表示しない';

