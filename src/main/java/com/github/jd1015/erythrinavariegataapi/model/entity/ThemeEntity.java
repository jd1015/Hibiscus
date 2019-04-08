/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.entity;

/**
 * @author lepra
 *
 */
public class ThemeEntity {
  private Long themeId;
  private String title;
  private String content;
  private Boolean contentDisplayFlg;
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
  /**
   * @return contentDisplayFlg
   */
  public Boolean getContentDisplayFlg() {
    return contentDisplayFlg;
  }
  /**
   * @param contentDisplayFlg セットする contentDisplayFlg
   */
  public void setContentDisplayFlg(Boolean contentDisplayFlg) {
    this.contentDisplayFlg = contentDisplayFlg;
  }

}
