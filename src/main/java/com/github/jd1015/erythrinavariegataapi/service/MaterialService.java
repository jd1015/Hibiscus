/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import java.util.List;

import com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialResponseJson;

/**
 * @author lepra
 *
 */
public interface MaterialService {
  /**
   * マテリアルを登録する
   * @param materialRequestJson マテリアルのリクエストオブジェクト
   * */
  void registerMaterial(MaterialRequestJson materialRequestJson);

  /**
   * マテリアルを取得する
   * @param themeId テーマのID
   * @param materialId マテリアルのID
   * @return マテリアルのレスポンス
   * */
  MaterialResponseJson getMaterial(Long themeId, Long materialId);

  /**
   * マテリアルのリストを取得する
   * @param themeId テーマのID
   * @return マテリアルのレスポンス(リスト)
   * */
  List<MaterialResponseJson> getMaterialList(Long themeId);

  /**
   * マテリアルを削除する
   * @param themeId テーマのID
   * @param materialId マテリアルのID
   * */
  void deleteMaterial(Long themeId, Long materialId);

  /**
   * マテリアルを更新する
   * @param materialRequestJson マテリアルのリクエスト
   * @param themeId テーマのID
   * @param materialId マテリアルのID
   * */
  void updateMaterial(MaterialRequestJson materialRequestJson, Long themeId, Long materialId);
}
