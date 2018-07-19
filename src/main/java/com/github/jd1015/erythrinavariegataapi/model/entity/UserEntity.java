/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.model.entity;

/**
 * @author lepra
 *
 */
public class UserEntity {
  private Long userId;
  private String hashPassword;
  private String salt;
  /**
   * @return userId
   */
  public Long getUserId() {
    return userId;
  }
  /**
   * @param userId セットする userId
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  /**
   * @return hashPassword
   */
  public String getHashPassword() {
    return hashPassword;
  }
  /**
   * @param hashPassword セットする hashPassword
   */
  public void setHashPassword(String hashPassword) {
    this.hashPassword = hashPassword;
  }
  /**
   * @return salt
   */
  public String getSalt() {
    return salt;
  }
  /**
   * @param salt セットする salt
   */
  public void setSalt(String salt) {
    this.salt = salt;
  }

}
