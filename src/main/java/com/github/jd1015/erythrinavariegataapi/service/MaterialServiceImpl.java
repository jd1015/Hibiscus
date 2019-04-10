/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jd1015.erythrinavariegataapi.common.Util;
import com.github.jd1015.erythrinavariegataapi.model.entity.MaterialEntity;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialListRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.MaterialResponseJson;
import com.github.jd1015.erythrinavariegataapi.repository.MaterialRepository;

/**
 * @author lepra
 *
 */
@Service
public class MaterialServiceImpl implements MaterialService {

  private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

  @Autowired
  MaterialRepository materialRepository;

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.MaterialService#registerMaterial(com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson)
   */
  @Override
  public void registerMaterial(MaterialRequestJson materialRequestJson, Long themeId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    MaterialEntity materialEntity = convertToMaterialEntity(materialRequestJson, themeId, null);

    // FIXME 存在しないテーマのIDを指定するとエラーが発生するので要検討。
    materialRepository.insert(materialEntity);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.MaterialService#getMaterial(java.lang.Long, java.lang.Long)
   */
  @Override
  public MaterialResponseJson getMaterial(Long themeId, Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    // FIXME 存在しないマテリアルを指定した場合にエラーを発生させる。
    MaterialEntity materialEntity = materialRepository.selectByThemeIdAndMaterialId(themeId, materialId);

    MaterialResponseJson materialResponseJson = convertToMaterialResponseJson(materialEntity);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialResponseJson;
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.MaterialService#getMaterialList(java.lang.Long)
   */
  @Override
  public List<MaterialResponseJson> getMaterialList(Long themeId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    // FIXME 存在しないテーマを指定した場合にエラーを発生させる。
    List<MaterialEntity> materialEntityList = materialRepository.selectByThemeId(themeId);

    List<MaterialResponseJson> materialResponseJsonList = new ArrayList<>();
    materialEntityList.stream().forEach(materialEntity -> {
      MaterialResponseJson materialResponseJson = convertToMaterialResponseJson(materialEntity);
      materialResponseJsonList.add(materialResponseJson);
    });

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialResponseJsonList;
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.MaterialService#deleteMaterial(java.lang.Long, java.lang.Long)
   */
  @Override
  public void deleteMaterial(Long themeId, Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    // FIXME 存在しないマテリアルを指定した場合にエラーを発生させる。
    materialRepository.deleteByThemeIdAndMaterialId(themeId, materialId);
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }

  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.MaterialService#updateMaterial(com.github.jd1015.erythrinavariegataapi.model.json.MaterialRequestJson, java.lang.Long, java.lang.Long)
   */
  @Override
  public void updateMaterial(MaterialRequestJson materialRequestJson, Long themeId, Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    MaterialEntity materialEntity = convertToMaterialEntity(materialRequestJson, themeId, materialId);

    // FIXME 更新対象が存在しない場合にエラーを発生させる
    materialRepository.update(materialEntity);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }

  }

  /**
   * マテリアルのエンティティをレスポンスにする
   * @param materialEntity マテリアルのエンティティ
   * @return マテリアルのレスポンス
   * */
  private MaterialResponseJson convertToMaterialResponseJson(MaterialEntity materialEntity) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    MaterialResponseJson materialResponseJson = new MaterialResponseJson();
    materialResponseJson.setThemeId(materialEntity.getThemeId());
    materialResponseJson.setMaterialId(materialEntity.getMaterialId());
    materialResponseJson.setTitle(materialEntity.getTitle());
    materialResponseJson.setContent(materialEntity.getContent());

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialResponseJson;
  }

  /**
   * マテリアルのリクエストをエンティティにする
   * @param materialRequestJson マテリアルのリクエスト
   * @param themeId テーマのID
   * @param materialId マテリアルのID
   * @return マテリアルのエンティティ
   * */
  private MaterialEntity convertToMaterialEntity(MaterialRequestJson materialRequestJson, Long themeId,
      Long materialId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    MaterialEntity materialEntity = new MaterialEntity();
    materialEntity.setThemeId(themeId);
    materialEntity.setMaterialId(materialId);
    materialEntity.setTitle(materialRequestJson.getTitle());
    materialEntity.setContent(materialRequestJson.getContent());

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return materialEntity;
  }

  @Override
  public void updateMaterialList(MaterialListRequestJson materialListRequestJson, Long themeId) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    List<MaterialEntity> materialEntityList = new ArrayList<>();
    materialListRequestJson.getMaterialList().stream().forEach(material->{
      MaterialEntity materialEntity = new MaterialEntity();
      materialEntity.setThemeId(themeId);
      materialEntity.setMaterialId(material.getMaterialId());
      materialEntity.setTitle(material.getTitle());
      materialEntity.setContent(material.getContent());
      materialEntityList.add(materialEntity);
    });
    materialRepository.updateList(materialEntityList);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
  }

}
