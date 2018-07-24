/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.jd1015.erythrinavariegataapi.common.Util;
import com.github.jd1015.erythrinavariegataapi.common.exception.AuthorizationException;
import com.github.jd1015.erythrinavariegataapi.model.entity.UserEntity;
import com.github.jd1015.erythrinavariegataapi.model.json.LoginRequestJson;
import com.github.jd1015.erythrinavariegataapi.model.json.TokenResponseJson;
import com.github.jd1015.erythrinavariegataapi.repository.AuthorizationRepository;

/**
 * @author lepra
 *
 */
public class AuthorizationServiceImpl implements AuthorizationService {

  private static final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

  @Autowired
  AuthorizationRepository authorizationRepository;

  @Autowired
  PasswordEncoder bCryptPasswordEncoder;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /* (非 Javadoc)
   * @see com.github.jd1015.erythrinavariegataapi.service.AuthorizationService#tokenIssued(com.github.jd1015.erythrinavariegataapi.model.json.LoginRequestJson)
   */
  @Override
  public TokenResponseJson tokenIssued(LoginRequestJson loginRequestJson) {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }

    UserEntity userEntity = authorizationRepository.selectUserByUserCode(loginRequestJson.getUserCode());

    Boolean isSuccess = bCryptPasswordEncoder.matches(loginRequestJson.getPassword(), userEntity.getHashPassword());

    if (!isSuccess) {
      throw new AuthorizationException("パスワードが間違えています。");
    }

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return null;
  }

}
