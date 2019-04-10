/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import java.util.List;

import com.github.jd1015.erythrinavariegataapi.model.json.MaterialListRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialResponseJson;

/**
 * @author lepra
 *
 */
public interface MaterialService {
  /**
   * マテリアルを登録する
   * @param materialRequestJson マテリアルの登録内容
   * @param themeId 登録するマテリアルが属するテーマのID
   * */
  void registerMaterial(MaterialRequestJson materialRequestJson, Long themeId);

  /**
   * マテリアルを取得する
   * @param themeId 取得するマテリアルが属するテーマのID
   * @param materialId 取得するマテリアルのID
   * @return マテリアルのレスポンス
   * */
  MaterialResponseJson getMaterial(Long themeId, Long materialId);

  /**
   * マテリアルのリストを取得する
   * @param themeId 取得するテーマのID
   * @return マテリアルのレスポンス(リスト)
   * */
  List<MaterialResponseJson> getMaterialList(Long themeId);

  /**
   * マテリアルを削除する
   * @param themeId 削除するマテリアルが属するテーマのID
   * @param materialId 削除するマテリアルのID
   * */
  void deleteMaterial(Long themeId, Long materialId);

  /**
   * マテリアルを更新する
   * @param materialRequestJson マテリアルの更新内容
   * @param themeId 更新するマテリアルが属するテーマのID
   * @param materialId 更新するマテリアルのID
   * */
  void updateMaterial(MaterialRequestJson materialRequestJson, Long themeId, Long materialId);

  /**
   * マテリアルlistを更新する
   * @param materialListRequestJson マテリアルlistの更新内容
   * @param themeId 更新するマテリアルが属するテーマのID
   * */
  void updateMaterialList(MaterialListRequestJson materialListRequestJson, Long themeId);
}
