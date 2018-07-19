/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.repository;

import com.github.jd1015.erythrinavariegataapi.model.entity.UserEntity;

/**
 * @author lepra
 *
 */
public interface AuthorizationRepository {

  UserEntity selectUserByUserCode(String userCode);

}
