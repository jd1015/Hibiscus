/**
 *
 */
package com.github.jd1015.erythrinavariegataapi.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lepra
 *
 */
public class Util {

  /**
   * 実行中のメソッド名を取得します。
   * @return メソッド名
   */
  public static String getMethodName() {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }

  /**
   * 実行中のクラス名を取得します。
   * @return クラス名
   */
  public static String getClassName() {
    return Thread.currentThread().getStackTrace()[2].getClassName();
  }

  /**
   * 実行中のクラス名を取得します。
   * @return クラス名
   */
  public static String getJson(Object object) {
    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return json;
  }
}
