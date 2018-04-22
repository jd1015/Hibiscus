/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import java.util.List;

import com.github.jd1015.erythrinavariegataapi.model.entity.ThemeEntity;

/**
 * @author lepra
 *
 */
public interface ThemeRepository {

  Boolean insert(ThemeEntity themeEntity);
  ThemeEntity selectById(Long thmeId);
  List<ThemeEntity> selectAll();
  Boolean deleteById(Long thmeId);
  Boolean copyById(Long thmeId);

}
