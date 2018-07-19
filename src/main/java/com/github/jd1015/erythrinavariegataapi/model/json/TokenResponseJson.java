/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.json;

import com.github.jd1015.erythrinavariegataapi.common.Util;

/**
 * @author lepra
 *
 */
public class TokenResponseJson {
  private String accessToken;
  private String refreshToken;
  private String expiredDate;
  /**
   * @return accessToken
   */
  public String getAccessToken() {
    return accessToken;
  }
  /**
   * @param accessToken セットする accessToken
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
  /**
   * @return refreshToken
   */
  public String getRefreshToken() {
    return refreshToken;
  }
  /**
   * @param refreshToken セットする refreshToken
   */
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
  /**
   * @return expiredDate
   */
  public String getExpiredDate() {
    return expiredDate;
  }
  /**
   * @param expiredDate セットする expiredDate
   */
  public void setExpiredDate(String expiredDate) {
    this.expiredDate = expiredDate;
  }

  @Override
  public String toString() {
    return Util.getJson(this);
  }
}
