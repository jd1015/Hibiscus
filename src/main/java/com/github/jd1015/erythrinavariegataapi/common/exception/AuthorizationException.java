/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.common.exception;

/**
 * 認可に失敗した場合に発生させるExceptionクラス
 * @author lepra
 *
 */
public class AuthorizationException extends RuntimeException {

  /**
   * @param message
   */
  public AuthorizationException(String message) {
    super(message);
  }

}
