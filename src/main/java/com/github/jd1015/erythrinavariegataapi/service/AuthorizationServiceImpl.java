/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

  private static int TOKEN_LENGTH = 16;//16*2=32バイト

  @Value("${erythrinavariegata.expiredminute}")
  private long expiredMinute;

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

    // トークン情報を生成する
    TokenResponseJson tokenResponseJson = new TokenResponseJson();
    tokenResponseJson.setAccessToken(getCsrfToken());
    tokenResponseJson.setRefreshToken(getCsrfToken());
    tokenResponseJson.setExpiredDate(java.time.LocalDateTime.now().plusMinutes(expiredMinute).toString());

    // トークン情報を更新する
    authorizationRepository.updateTokenByUserId(tokenResponseJson.getAccessToken(),
      tokenResponseJson.getRefreshToken(), tokenResponseJson.getExpiredDate(), userEntity.getUserId());

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return tokenResponseJson;
  }

  /**
   * 32バイトのCSRFトークンを作成
   * @return CSRFトークン
   */
  private static String getCsrfToken() {
    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 開始", Util.getClassName(), Util.getMethodName());
    }
    byte token[] = new byte[TOKEN_LENGTH];
    StringBuffer buf = new StringBuffer();
    SecureRandom random = null;

    try {
      random = SecureRandom.getInstance("SHA1PRNG");
      random.nextBytes(token);

      for (int i = 0; i < token.length; i++) {
        buf.append(String.format("%02x", token[i]));
      }

    } catch (NoSuchAlgorithmException ex) {
      if (logger.isErrorEnabled()) {
        logger.error(ex.getMessage(), ex);
      }
      throw new AuthorizationException("CSRFトークンが作成できませんでした。");
    }

    if (logger.isDebugEnabled()) {
      logger.debug("{}.{} 終了", Util.getClassName(), Util.getMethodName());
    }
    return buf.toString();
  }

}
