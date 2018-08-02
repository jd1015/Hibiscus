/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import org.apache.ibatis.annotations.Param;

import com.github.jd1015.erythrinavariegataapi.model.entity.UserEntity;

/**
 * @author lepra
 *
 */
public interface AuthorizationRepository {

  UserEntity selectUserByUserCode(String userCode);
  Boolean updateTokenByUserId (@Param("accessToken") String accessToken,
    @Param("refreshToken") String refreshToken,
    @Param("expiredAt") String expiredAt,
    @Param("userId") Long userId);

}
