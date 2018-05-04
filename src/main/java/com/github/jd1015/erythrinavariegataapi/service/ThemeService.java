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
}
