/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.jd1015.erythrinavariegataapi.model.entity.MaterialEntity;

/**
 * @author lepra
 *
 */
@Mapper
public interface MaterialRepository {

  Boolean insert(MaterialEntity materialEntity);

  MaterialEntity selectByThemeIdAndMaterialId(Long themeId, Long materialId);

  List<MaterialEntity> selectByThemeId(Long themeId);

  Boolean deleteByThemeIdAndMaterialId(Long themeId, Long materialId);

  Boolean update(MaterialEntity materialEntity);
}
