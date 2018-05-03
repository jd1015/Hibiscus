/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class MaterialRequestJson {
  private String title;
  private String content;

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

  @Override
  public String toString() {
    return Util.getJson(this);
  }

}
