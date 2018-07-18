DROP FUNCTION tuserInitialFunction CASCADE;
-- t_userにINSERTされたときに初期処理を行う関数
CREATE FUNCTION
  tuserInitialFunction () RETURNS TRIGGER
  AS
  $tuserInitialFunction$
    BEGIN
      IF (TG_OP = 'INSERT') THEN
        INSERT INTO t_login (user_id) VALUES (NEW.user_id);
        -- ソルトを乱数でユニークに作成する
        UPDATE t_user SET salt =(SELECT md5(clock_timestamp()::text || NEW.user_code) FROM generate_series(1,1)) WHERE user_id = NEW.user_id;
        RETURN NEW;
      END IF;
    END
  $tuserInitialFunction$
LANGUAGE plpgsql;

DROP FUNCTION tuserEndFunction CASCADE;
-- t_userにDELETEされたときにデータをクリアする処理を行う関数
CREATE FUNCTION
  tuserEndFunction () RETURNS TRIGGER
  AS
  $tuserEndFunction$
    BEGIN
      IF (TG_OP = 'DELETE') THEN
        DELETE FROM t_login WHERE user_id = OLD.user_id;
        RETURN OLD;
      END IF;
    END
  $tuserEndFunction$
LANGUAGE plpgsql;

CREATE TRIGGER tuserInsert
  AFTER INSERT ON t_user
  FOR EACH ROW EXECUTE PROCEDURE tuserInitialFunction ();
CREATE TRIGGER tuserDelete
  BEFORE DELETE ON t_user
  FOR EACH ROW EXECUTE PROCEDURE tuserEndFunction ();