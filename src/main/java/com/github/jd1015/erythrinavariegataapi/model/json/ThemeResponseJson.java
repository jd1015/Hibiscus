/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class ThemeResponseJson {
  private Long themeId;
  private String title;
  private String content;
  /**
   * @param themeId セットする themeId
   */
  public void setThemeId(Long themeId) {
    this.themeId = themeId;
  }
  /**
   * @param title セットする title
   */
  public void setTitle(String title) {
    this.title = title;
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
  /**
   * @return themeId
   */
  public Long getThemeId() {
    return themeId;
  }
  /**
   * @return title
   */
  public String getTitle() {
    return title;
  }
  /**
   * @return content
   */
  public String getContent() {
    return content;
  }

}
