/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import java.util.List;

import com.github.jd1015.erythrinavariegataapi.model.json.ThemeRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.ThemeResponseJson;

/**
 * @author lepra
 *
 */
public interface ThemeService {
  /**
   * テーマを登録する
   * @param themeRequestJson テーマの登録内容
   * */
  void registerTheme(ThemeRequestJson themeRequestJson);

  /**
   * テーマを取得する
   * @param themeId 取得するテーマのID
   * @return テーマのレスポンス
   * */
  ThemeResponseJson getTheme(Long themeId);

  /**
   * テーマを取得する
   * @return テーマのレスポンス(リスト)
   * */
  List<ThemeResponseJson> getThemeList();

  /**
   * テーマを削除する
   * @param themeId 削除するテーマのID
   * */
  void deleteTheme(Long themeId);

  /**
   * テーマを複製する
   * @param themeId 複製するテーマのID
   * */
  void copyTheme(Long themeId);

  /**
   * テーマを更新する
   * @param themeRequestJson テーマの更新内容
   * @param themeId 更新するテーマのID
   * */
  void updateTheme(ThemeRequestJson themeRequestJson, Long themeId);

  /**
   * 逆さ表示フラグを更新する
   * @param themeId 更新するテーマのID
   * @param reverseDisplayFlg 更新後の逆さ表示フラグ
   * */
  void updateReverseDisplayFlg(Long themeId, Boolean reverseDisplayFlg);
}
