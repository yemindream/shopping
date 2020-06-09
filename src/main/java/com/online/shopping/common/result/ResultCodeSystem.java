package com.online.shopping.common.result;

/**
 *
 * ErrorCode of System For example :14008102,module 14 - interface 8 - error.
 * 102.
 *
 */
public final class ResultCodeSystem {

  private ResultCodeSystem() {}

  /**
   * Module : system result code.
   *
   */

  /**
   * status code: 0 (success).
   */
  public static final int RESULT_CODE_0 = 0;

  /**
   * status message: add success.
   */
  public static final String ADD_SUCCESS = "add success";

  /**
   * status message: register success.
   */
  public static final String REGISTER_SUCCESS = "register success";

  /**
   * status message: account activation success.
   */
  public static final String ACOUNT_OAUTH_SUCCESS =
      "account activation success";

  /**
   * status message: password reset success.
   */
  public static final String RESET_SUCCESS = "password reset success";

  /**
   * status message: SMS validation success.
   */
  public static final String MSGCODE_CHECK_SUCCESS = "SMS validation success";

  /**
   * status message: login success.
   */
  public static final String LOGIN_SUCCESS = "login success";

  /**
   * status message: select success.
   */
  public static final String SELECT_SUCCESS = "select success";

  /**
   * status message: save success.
   */
  public static final String SAVE_SUCCESS = "save success";

  /**
   * status message: delete success.
   */
  public static final String DELETE_SUCCESS = "delete success";

  /**
   * status message: operate success.
   */
  public static final String OPERATE_SUCCESS = "operate success";

  /**
   * status message: upload success.
   */
  public static final String UPLOAD_SUCCESS = "upload success";

  /**
   * status message: cancel the collection success.
   */
  public static final String CANCEL_COLLECTION_SUCCESS =
      "cancel the collection success";

  /**
   * status message: collection success.
   */
  public static final String COLLECTION_SUCCESS = "collection success";

  /**
   * status message: praise success.
   */
  public static final String PRAISES_SUCCESS = "praise success";

  /**
   * status message: cancel the praise success.
   */
  public static final String CANCEL_PRAISE_SSUCCESS =
      "cancel the praise success";

  /**
   * status code: 50.
   */
  public static final int RESULT_CODE_50 = 50;

  /**
   * status message: add failure.
   */
  public static final String ADD_FAIL = "add failure";
  /**
   * status message: register failure.
   */
  public static final String REGISTER_FAIL = "register failure";
  /**
   * status message: account activation failure.
   */
  public static final String ACOUNT_OAUTH_FAIL = "account activation failure";

  /**
   * status message: password reset failure.
   */
  public static final String RESET_FAIL = "password reset failure";

  /**
   * status message: SMS validation failure.
   */
  public static final String MSGCODE_CHECK_FAIL = "SMS validation failure";

  /**
   * status message: login failure.
   */
  public static final String LOGIN_FAIL = "login failure";

  /**
   * status message: select failure.
   */
  public static final String SELECT_FAIL = "select failure";

  /**
   * status message: save failure.
   */
  public static final String SAVE_FAIL = "save failure";

  /**
   * status message: delete failure.
   */
  public static final String DELETE_FAIL = "delete failure";

  /**
   * status message: operate failure.
   */
  public static final String OPERATE_FAIL = "operate failure";

  /**
   * status message: upload failure.
   */
  public static final String UPLOAD_FAIL = "upload failure";

  /**
   * status code: (2: no privilege).
   */
  public static final int RESULT_CODE_2 = 2;

  /**
   * status message: (no enough privilege).
   */
  public static final String NO_PRIVILEGE = "no enough privilege";

  /**
   * status code: (3: param error).
   */
  public static final int RESULT_CODE_3 = 3;

  /**
   * status message:  (parameter error).
   */
  public static final String PARAM_ERROR = "parameter error";

  /**
   * status code: (9: no login or token invalid).
   */
  public static final int RESULT_CODE_9 = 9;

  /**
   * status message:  (no login or token invalid).
   */
  public static final String INVALID_TOKEN = "no login or token invalid";

  /**
   * status code: (10: account is frozen).
   */
  public static final int RESULT_CODE_10 = 10;

  /**
   * status message: (account is frozen).
   */
  public static final String FROZEN_ACCOUNT = "account is frozen";

  /**
   * status code: (11: Invalid proxy user).
   */
  public static final int RESULT_CODE_11 = 11;

  /**
   * status message:  (Invalid proxy user).
   */
  public static final String INVALID_PROXY_USER = "INVALID_AGENT";
  /**
   * status code:  (11: Invalid proxy user).
   */
  public static final int RESULT_CODE_12 = 12;

  /**
   * status message:  (Invalid proxy user).
   */
  public static final String AGENT_TIME_FAILURE = "AGENT_TIME_EXPIRES";

  /**
   * status code:  (500: inner error).
   */
  public static final int RESULT_CODE_500 = 500;

  /**
   * status message:  (network error, please try again later).
   */
  public static final String INNER_ERROR =
      "network error, please try again later";

  /**
   * status code:  (401: inner error).
   */
  public static final int RESULT_CODE_401 = 401;

  /**
   * status message:  (network error, please try again later).
   */
  public static final String NO_PERMISSION = "permission denied";

  /**
   * status message:  (remote call error, please try again later).
   */
  public static final String REMOTE_CALL_ERROR =
      "remote call error, please try again later";

  /**
   * status message:  (remote call error, please try again later).
   */
  public static final String INCOMPATIBLE_VERSION_ERROR =
      "api version is not compatible, please confirm your version number";



  // =============================
  // no use :: :: :: ::.

  /**
   * status code:  101024.
   */
  public static final int RESULT_CODE_101024 = 101024;

  /**
   * status message: 101024-The phone number has not registered.
   */
  public static final String RESULT_MSG_101024 =
      "101024-The phone number has not registered ";

  /**
   * status code:  101017.
   */
  public static final int RESULT_CODE_101017 = 101017;


  /**
   * status message: 101017-incorrect msgcode.
   */
  public static final String RESULT_MSG_101017 = "101017-incorrect msgcode ";

  /**
   * status code:  101018.
   */
  public static final int RESULT_CODE_101018 = 101018;

  /**
   * status message: 101018-msgcode is expired.
   */
  public static final String RESULT_MSG_101018 = "101018-msgcode is expired ";

  /**
   * status code:  101000.
   */
  public static final int RESULT_CODE_101000 = 101000;

  /**
   * status message: 101000-The thirdpart user has not registered.
   */
  public static final String RESULT_MSG_101000 =
      "101000-The thirdpart user has not registered";

  /**
   * status code:  101020.
   */
  public static final int RESULT_CODE_101020 = 101020;

  /**
   * status message: Request Error: {}.
   */
  public static final String RESULT_MSG_101020 = "Request Error: {}";

  /**
   * status code:  101021.
   */
  public static final int RESULT_CODE_101021 = 101021;

  /**
   * status message: Error RpcResponse: {}.
   */
  public static final String RESULT_MSG_101021 = "Error RpcResponse: {}";

  /**
   * status message: Error :{}
   */
  public static final String RESULT_MSG_101022 = "Error: {}";

  /**
   * status message:  searchkey
   */
  public static final String RESULT_SEARCH_KEY = "searchkey";
  /**
   * status message:  waring:{}
   */
  public static final String RESULT_WARING = "waring : {}";

}
