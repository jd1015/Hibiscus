/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jd1015.erythrinavariegataapi.common.Util;
import com.github.jd1015.erythrinavariegataapi.model.json.LoginRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.TokenResponseJson;
import com.github.jd1015.erythrinavariegataapi.service.AuthorizationService;

/**
 * @author lepra
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthorizationController {

  private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

  @Autowired
  AuthorizationService authorizationService;

  /**
   * "/auth/token"でトークンを発行する
   * @param loginRequestJson ログイン情報
   * @return トークン情報
   * */
  @PostMapping
  @RequestMapping(value = "/token")
  public TokenResponseJson postToken(@RequestBody LoginRequestJson loginRequestJson) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
      logger.debug(loginRequestJson.toString());
    }

    TokenResponseJson tokenResponseJson = authorizationService.tokenIssued(loginRequestJson);

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return tokenResponseJson;
  }

}
