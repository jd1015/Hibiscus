/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.jd1015.erythrinavariegataapi.model.entity.MaterialEntity;

/**
 * @author lepra
 *
 */
@Mapper
public interface MaterialRepository {

  Boolean insert(MaterialEntity materialEntity);

  MaterialEntity selectByThemeIdAndMaterialId(@Param("themeId") Long themeId, @Param("materialId") Long materialId);

  List<MaterialEntity> selectByThemeId(Long themeId);

  Boolean deleteByThemeIdAndMaterialId(@Param("themeId") Long themeId, @Param("materialId") Long materialId);

  Boolean update(MaterialEntity materialEntity);
}
