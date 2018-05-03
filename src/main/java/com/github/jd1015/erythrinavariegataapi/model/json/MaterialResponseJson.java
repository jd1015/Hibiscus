/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class MaterialResponseJson {
  private Long themeId;
  private Long materialId;
  private String title;
  private String content;

  /**
   * @return themeId
   */
  public Long getThemeId() {
    return themeId;
  }

  /**
   * @param themeId セットする themeId
   */
  public void setThemeId(Long themeId) {
    this.themeId = themeId;
  }

  /**
   * @return materialId
   */
  public Long getMaterialId() {
    return materialId;
  }

  /**
   * @param materialId セットする materialId
   */
  public void setMaterialId(Long materialId) {
    this.materialId = materialId;
  }

  /**
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title セットする title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content セットする content
   */
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return Util.getJson(this);
  }
}
