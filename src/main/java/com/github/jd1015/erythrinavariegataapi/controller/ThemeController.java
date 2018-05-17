/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jd1015.erythrinavariegataapi.common.Util;
import com.github.jd1015.erythrinavariegataapi.model.json.ThemeRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.ThemeResponseJson;
import com.github.jd1015.erythrinavariegataapi.service.ThemeService;

/**
 * @author lepra
 *
 */
@RestController
@RequestMapping("/theme")
public class ThemeController {

  private static final Logger logger = LoggerFactory.getLogger(ThemeController.class);

  @Autowired
  ThemeService themeService;

  /**
   * "/theme"でテーマを登録する
   * @param themeRequestJson 登録するテーマの内容
   * */
  @RequestMapping(method=RequestMethod.POST)
  public void postTheme(@RequestBody ThemeRequestJson themeRequestJson) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
      logger.debug(themeRequestJson.toString());
    }
    themeService.registerTheme(themeRequestJson);
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }

  /**
   * "/theme/xx"で指定したIDのテーマを取得する
   * @param id 取得するテーマのID
   * @return テーマ
   * */
  @RequestMapping(value="/{id}",method=RequestMethod.GET)
  public ThemeResponseJson getTheme(@PathVariable Long id) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    ThemeResponseJson themeResponseJson = themeService.getTheme(id);
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return themeResponseJson;
  }

  /**
   * "/theme"でテーマのリストを取得する
   * @return テーマのリスト
   * */
  @RequestMapping(method=RequestMethod.GET)
  public List<ThemeResponseJson> getThemes() {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    List<ThemeResponseJson> themeResponseJsonList = themeService.getThemeList();
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return themeResponseJsonList;
  }

  /**
   * "/theme/xx"で指定したIDのテーマを削除する
   * @param id 削除するテーマのID
   * */
  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  public void deleteTheme(@PathVariable Long id) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    themeService.deleteTheme(id);
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }
  /**
   * "/theme/xx"で指定したテーマのIDの内容を更新する
   * @param themeRequestJson 更新するテーマの内容
   * @param id 更新するテーマのID
   * */
  @PutMapping(value="/{id}")
  public void putTheme(@RequestBody ThemeRequestJson themeRequestJson, @PathVariable Long id) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
      logger.debug(themeRequestJson.toString());
    }
    themeService.updateTheme(themeRequestJson, id);
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }
  // FIXME コピー機能の実装
}
