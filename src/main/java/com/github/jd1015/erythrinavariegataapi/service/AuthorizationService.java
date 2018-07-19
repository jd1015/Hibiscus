/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import com.github.jd1015.erythrinavariegataapi.model.json.LoginRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.TokenResponseJson;

/**
 * @author lepra
 *
 */
public interface AuthorizationService {

  /**
   * トークンを発行する
   * @param LoginRequestJson ログイン情報
   * @return トークン情報
   * */
  TokenResponseJson tokenIssued (LoginRequestJson loginRequestJson);
}
