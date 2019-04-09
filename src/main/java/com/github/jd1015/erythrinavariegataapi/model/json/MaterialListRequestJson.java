/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import java.util.List;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class MaterialListRequestJson {

  private List<Material> materialList;
  public static class Material {
    private Long materialId;
    private String title;
    private String content;
    @Override
    public String toString() {
      return Util.getJson(this);
    }
    /**
     * @return materialId
     */
    public Long getMaterialId() {
      return materialId;
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
  @Override
  public String toString() {
    return Util.getJson(this);
  }
  /**
   * @return materialList
   */
  public List<Material> getMaterialList() {
    return materialList;
  }
}
