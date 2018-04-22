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
   * @param themeRequestJson テーマのリクエストオブジェクト
   * */
  void registerTheme(ThemeRequestJson themeRequestJson);

  /**
   * テーマを取得する
   * @param themeId テーマのID
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
   * @param themeId テーマのID
   * */
  void deleteTheme(Long themeId);

  /**
   * テーマを複製する
   * @param themeId テーマのID
   * */
  void copyTheme(Long themeId);
}
