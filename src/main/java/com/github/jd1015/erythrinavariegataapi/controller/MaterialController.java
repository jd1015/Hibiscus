/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.jd1015.erythrinavariegataapi.common.Util;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialResponseJson;
import com.github.jd1015.erythrinavariegataapi.service.MaterialService;

/**
 * @author lepra
 *
 */
@RestController
@RequestMapping("/theme")
public class MaterialController {

  private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

  @Autowired
  MaterialService materialService;

  /**
   * "/theme/{themeId}/material"でマテリアルを登録する
   * @param themeId 登録するマテリアルが属するテーマのID
   * @param materialRequestJson 登録するマテリアルの内容
   * */
  @RequestMapping(value = "/{themeId}/material", method = RequestMethod.POST)
  public void postMaterial(@PathVariable Long themeId, @RequestBody MaterialRequestJson materialRequestJson) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
      logger.debug(materialRequestJson.toString());
    }

    materialService.registerMaterial(materialRequestJson, themeId);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }

  /**
   * "/theme/{themeId}/material/{materialId}"でマテリアルを取得する
   * @param themeId 取得するマテリアルが属するテーマのID
   * @param materialId 取得するマテリアルのID
   * @return マテリアル
   * */
  @RequestMapping(value = "/{themeId}/material/{materialId}", method = RequestMethod.GET)
  public MaterialResponseJson getMaterial(@PathVariable Long themeId, @PathVariable Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    MaterialResponseJson materialResponseJson = materialService.getMaterial(themeId, materialId);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialResponseJson;
  }

  /**
   * "/theme/{themeId}/material"でテーマに所属する全てのマテリアルを取得する
   * @param themeId 取得するマテリアルが属するテーマのID
   * @return マテリアルのリスト
   * */
  @RequestMapping(value = "/{themeId}/material")
  public List<MaterialResponseJson> getMaterialList(@PathVariable Long themeId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    List<MaterialResponseJson> materialResponseJsonList = materialService.getMaterialList(themeId);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialResponseJsonList;
  }

  /**
   * "/theme/{themeId}/material/{materialId}"でマテリアルを削除する
   * @param themeId 削除するマテリアルが属するテーマのID
   * @param materialId 削除するマテリアルのID
   * @return マテリアル
   * */
  @RequestMapping(value = "/{themeId}/material/{materialId}", method = RequestMethod.DELETE)
  public void deleteMaterial(@PathVariable Long themeId, @PathVariable Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    materialService.deleteMaterial(themeId, materialId);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }

  /**
   * "/theme/{themeId}/material/{materialId}"でマテリアルを更新する
   * @param themeId 更新するマテリアルが属するテーマのID
   * @param materialId 更新するマテリアルのID
   * @return マテリアル
   * */
  @RequestMapping(value = "/{themeId}/material/{materialId}", method = RequestMethod.PUT)
  public void putMaterial(@PathVariable Long themeId, @PathVariable Long materialId,
      @RequestBody MaterialRequestJson materialRequestJson) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
      logger.debug(materialRequestJson.toString());
    }

    materialService.updateMaterial(materialRequestJson, themeId, materialId);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }
}
