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
import com.github.jd1015.erythrinavariegataapi.model.entity.ThemeEntity;
import com.github.jd1015.erythrinavariegataapi.model.json.ThemeRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.ThemeResponseJson;
import com.github.jd1015.erythrinavariegataapi.repository.ThemeRepository;

/**
 * @author lepra
 *
 */
@Service
public class ThemeServiceImpl implements ThemeService {

  private static final Logger logger = LoggerFactory.getLogger(ThemeServiceImpl.class);

  @Autowired
  ThemeRepository themeRepository;

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.ThemeService#registerTheme(com.github.jd1015.erythrinavariegataapi.model.json.ThemeRequestJson)
   */
  @Override
  public void registerTheme(ThemeRequestJson themeRequestJson) {
    logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    ThemeEntity themeEntity = new ThemeEntity();
    themeEntity.setTitle(themeRequestJson.getTitle());
    themeEntity.setContent(themeRequestJson.getContent());
    themeRepository.insert(themeEntity);
    logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.ThemeService#getTheme(java.lang.Long)
   */
  @Override
  public ThemeResponseJson getTheme(Long themeId) {
    logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    // FIXME 空の時にエラーを発生させる。
    ThemeEntity themeEntity = themeRepository.selectById(themeId);
    ThemeResponseJson themeResponseJson = new ThemeResponseJson();
    themeResponseJson.setThemeId(themeEntity.getThemeId());
    themeResponseJson.setTitle(themeEntity.getTitle());
    themeResponseJson.setContent(themeEntity.getContent());
    logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    return themeResponseJson;
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.ThemeService#getThemeList()
   */
  @Override
  public List<ThemeResponseJson> getThemeList() {
    logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    // FIXME 空の時にエラーを発生させる。
    List<ThemeEntity> themeEntityList = themeRepository.selectAll();
    List<ThemeResponseJson> themeResponseList = new ArrayList<>();
    themeEntityList.stream().forEach(themeEntity -> {
      ThemeResponseJson themeResponseJson = new ThemeResponseJson();
      themeResponseJson.setThemeId(themeEntity.getThemeId());
      themeResponseJson.setTitle(themeEntity.getTitle());
      themeResponseJson.setContent(themeEntity.getContent());
      themeResponseList.add(themeResponseJson);
    });
    logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    return themeResponseList;
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.ThemeService#deleteTheme(java.lang.Long)
   */
  @Override
  public void deleteTheme(Long themeId) {
    logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    // FIXME falseの時にエラーを発生させる。
    Boolean successFlag = themeRepository.deleteById(themeId);
    logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.ThemeService#copyTheme(java.lang.Long)
   */
  @Override
  public void copyTheme(Long themeId) {
    logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    // FIXME falseの時にエラーを発生させる。
    Boolean successFlag = themeRepository.copyById(themeId);
    logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
  }
}
