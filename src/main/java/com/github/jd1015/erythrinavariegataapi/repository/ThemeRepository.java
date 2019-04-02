/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.jd1015.erythrinavariegataapi.model.entity.ThemeEntity;

/**
 * @author lepra
 *
 */
@Mapper
public interface ThemeRepository {

  Boolean insert(ThemeEntity themeEntity);
  ThemeEntity selectById(Long themeId);
  List<ThemeEntity> selectAll();
  Boolean deleteById(Long themeId);
  Boolean copyById(Long themeId);
  Boolean updateById(ThemeEntity themeEntity);

}
