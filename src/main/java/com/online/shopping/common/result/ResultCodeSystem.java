package com.online.shopping.common.result;

/**
 *
 * ErrorCode of System For example :14008102,module 14 - interface 8 - error.
 * 102.
 *
 * @author: yemin
 * @date 创建时间：2018年05月13日 下午2:17:55
 *
 */
public final class ResultCodeSystem {

  private ResultCodeSystem() {}

  /**
   * Module : system result code.
   *
   */

  /**
   * 状态码： 0 (success).
   */
  public static final int RESULT_CODE_0 = 0;

  /**
   * 状态消息：add success.
   */
  public static final String ADD_SUCCESS = "add success";

  /**
   * 状态消息：register success.
   */
  public static final String REGISTER_SUCCESS = "register success";

  /**
   * 状态消息：account activation success.
   */
  public static final String ACOUNT_OAUTH_SUCCESS =
      "account activation success";

  /**
   * 状态消息：password reset success.
   */
  public static final String RESET_SUCCESS = "password reset success";

  /**
   * 状态消息：SMS validation success.
   */
  public static final String MSGCODE_CHECK_SUCCESS = "SMS validation success";

  /**
   * 状态消息：login success.
   */
  public static final String LOGIN_SUCCESS = "login success";

  /**
   * 状态消息：select success.
   */
  public static final String SELECT_SUCCESS = "select success";

  /**
   * 状态消息：save success.
   */
  public static final String SAVE_SUCCESS = "save success";

  /**
   * 状态消息：delete success.
   */
  public static final String DELETE_SUCCESS = "delete success";

  /**
   * 状态消息：operate success.
   */
  public static final String OPERATE_SUCCESS = "operate success";

  /**
   * 状态消息：upload success.
   */
  public static final String UPLOAD_SUCCESS = "upload success";

  /**
   * 状态消息：cancel the collection success.
   */
  public static final String CANCEL_COLLECTION_SUCCESS =
      "cancel the collection success";

  /**
   * 状态消息：collection success.
   */
  public static final String COLLECTION_SUCCESS = "collection success";

  /**
   * 状态消息：praise success.
   */
  public static final String PRAISES_SUCCESS = "praise success";

  /**
   * 状态消息：cancel the praise success.
   */
  public static final String CANCEL_PRAISE_SSUCCESS =
      "cancel the praise success";

  /**
   * 状态码： 50.
   */
  public static final int RESULT_CODE_50 = 50;

  /**
   * 状态消息：add failure.
   */
  public static final String ADD_FAIL = "add failure";
  /**
   * 状态消息：register failure.
   */
  public static final String REGISTER_FAIL = "register failure";
  /**
   * 状态消息：account activation failure.
   */
  public static final String ACOUNT_OAUTH_FAIL = "account activation failure";

  /**
   * 状态消息：password reset failure.
   */
  public static final String RESET_FAIL = "password reset failure";

  /**
   * 状态消息：SMS validation failure.
   */
  public static final String MSGCODE_CHECK_FAIL = "SMS validation failure";

  /**
   * 状态消息：login failure.
   */
  public static final String LOGIN_FAIL = "login failure";

  /**
   * 状态消息：select failure.
   */
  public static final String SELECT_FAIL = "select failure";

  /**
   * 状态消息：save failure.
   */
  public static final String SAVE_FAIL = "save failure";

  /**
   * 状态消息：delete failure.
   */
  public static final String DELETE_FAIL = "delete failure";

  /**
   * 状态消息：operate failure.
   */
  public static final String OPERATE_FAIL = "operate failure";

  /**
   * 状态消息：upload failure.
   */
  public static final String UPLOAD_FAIL = "upload failure";

  /**
   * 状态码： (2: no privilege).
   */
  public static final int RESULT_CODE_2 = 2;

  /**
   * 状态消息： (no enough privilege).
   */
  public static final String NO_PRIVILEGE = "no enough privilege";

  /**
   * 状态码： (3: param error).
   */
  public static final int RESULT_CODE_3 = 3;

  /**
   * 状态消息： (parameter error).
   */
  public static final String PARAM_ERROR = "parameter error";

  /**
   * 状态码： (9: no login or token invalid).
   */
  public static final int RESULT_CODE_9 = 9;

  /**
   * 状态消息： (no login or token invalid).
   */
  public static final String INVALID_TOKEN = "no login or token invalid";

  /**
   * 状态码： (10: account is frozen).
   */
  public static final int RESULT_CODE_10 = 10;

  /**
   * 状态消息： (account is frozen).
   */
  public static final String FROZEN_ACCOUNT = "account is frozen";

  /**
   * 状态码： (11: Invalid proxy user).
   */
  public static final int RESULT_CODE_11 = 11;

  /**
   * 状态消息： (Invalid proxy user).
   */
  public static final String INVALID_PROXY_USER = "INVALID_AGENT";
  /**
   * 状态码： (11: Invalid proxy user).
   */
  public static final int RESULT_CODE_12 = 12;

  /**
   * 状态消息： (Invalid proxy user).
   */
  public static final String AGENT_TIME_FAILURE = "AGENT_TIME_EXPIRES";

  /**
   * 状态码： (500: inner error).
   */
  public static final int RESULT_CODE_500 = 500;

  /**
   * 状态消息： (network error, please try again later).
   */
  public static final String INNER_ERROR =
      "network error, please try again later";

  /**
   * 状态码： (401: inner error).
   */
  public static final int RESULT_CODE_401 = 401;

  /**
   * 状态消息： (network error, please try again later).
   */
  public static final String NO_PERMISSION = "无权限";

  /**
   * 状态消息： (remote call error, please try again later).
   */
  public static final String REMOTE_CALL_ERROR =
      "remote call error, please try again later";

  /**
   * 状态消息： (remote call error, please try again later).
   */
  public static final String INCOMPATIBLE_VERSION_ERROR =
      "api version is not compatible, please confirm your version number";



  // =============================
  // no use :: :: :: ::.

  /**
   * 状态码： 101024.
   */
  public static final int RESULT_CODE_101024 = 101024;

  /**
   * 状态消息：101024-The phone number has not registered.
   */
  public static final String RESULT_MSG_101024 =
      "101024-The phone number has not registered ";

  /**
   * 状态码： 101017.
   */
  public static final int RESULT_CODE_101017 = 101017;


  /**
   * 状态消息：101017-incorrect msgcode.
   */
  public static final String RESULT_MSG_101017 = "101017-incorrect msgcode ";

  /**
   * 状态码： 101018.
   */
  public static final int RESULT_CODE_101018 = 101018;

  /**
   * 状态消息：101018-msgcode is expired.
   */
  public static final String RESULT_MSG_101018 = "101018-msgcode is expired ";

  /**
   * 状态码： 101000.
   */
  public static final int RESULT_CODE_101000 = 101000;

  /**
   * 状态消息：101000-The thirdpart user has not registered.
   */
  public static final String RESULT_MSG_101000 =
      "101000-The thirdpart user has not registered";

  /**
   * 状态码： 101020.
   */
  public static final int RESULT_CODE_101020 = 101020;

  /**
   * 状态消息：Request Error: {}.
   */
  public static final String RESULT_MSG_101020 = "Request Error: {}";

  /**
   * 状态码： 101021.
   */
  public static final int RESULT_CODE_101021 = 101021;

  /**
   * 状态消息：Error RpcResponse: {}.
   */
  public static final String RESULT_MSG_101021 = "Error RpcResponse: {}";

  /**
   * 状态消息：Error :{}
   */
  public static final String RESULT_MSG_101022 = "Error: {}";

  /**
   * 状态消息： searchkey
   */
  public static final String RESULT_SEARCH_KEY = "searchkey";
  /**
   * 状态消息： waring:{}
   */
  public static final String RESULT_WARING = "waring : {}";

}
