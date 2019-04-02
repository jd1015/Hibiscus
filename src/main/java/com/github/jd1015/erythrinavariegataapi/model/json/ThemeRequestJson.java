/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class ThemeRequestJson {
  private String title;
  private String content;
  private Boolean reverseDisplayFlg;
  private Boolean contentDisplayFlg;
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
  /**
   * @return reverseDisplayFlg
   */
  public Boolean getReverseDisplayFlg() {
    return reverseDisplayFlg;
  }
  /**
   * @return contentDisplayFlg
   */
  public Boolean getContentDisplayFlg() {
    return contentDisplayFlg;
  }
  @Override
  public String toString() {
    return Util.getJson(this);
  }

}
