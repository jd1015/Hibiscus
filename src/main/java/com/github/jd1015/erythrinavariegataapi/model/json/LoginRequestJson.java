/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class LoginRequestJson {
  private String userCode;
  private String password;
  /**
   * @return userCode
   */
  public String getUserCode() {
    return userCode;
  }
  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    String json = "{"
        + "userCode:\"" + userCode + "\","
        + "password:\"" + "xxx" + "\"}";
    return json;
  }


}
