package com.online.shopping.common.result;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * response util.
 *
 * @author yemin
 */
public final class ResultUtil {

    private ResultUtil() {
    }

    /**
     * 日志类.
     */
    private static Logger logger = LoggerFactory.getLogger(ResultUtil.class);

    // ======================================================


    /**
     * codeMpa.
     */
    private static Map<Integer, String> msgCodeMap = null; // key:error_code ,
    // value:error_msg

    /**
     * 获取结果.
     *
     * @param resultCode resultCode
     * @return ResultJson
     */
    public static final <T> ResultJson<T> getResult(final int resultCode) {
        return getResult(resultCode, null, null);
    }

    /**
     * 获取结果.
     *
     * @param resultCode resultCode
     * @param data       data
     * @param message    message
     * @returnResultJson
     */
    public static final <T> ResultJson<T> getResult(int resultCode, final T data,
                                                    String message) {

        // Automatic complete resultCode
        if (resultCode < 0) {
            resultCode =
                    (!Strings.isNullOrEmpty(message) && message.indexOf("success") != -1)
                            ? ResultCodeSystem.RESULT_CODE_0
                            : ResultCodeSystem.RESULT_CODE_50;
        }

        // Automatic complete message
        if (Strings.isNullOrEmpty(message)) {
            if (resultCode == 0) {
                message = ResultCodeSystem.OPERATE_SUCCESS;
            } else if (resultCode == 50) {
                message = ResultCodeSystem.OPERATE_FAIL;
            } else if (resultCode == 2) {
                message = ResultCodeSystem.NO_PRIVILEGE;
            } else if (resultCode == 3) {
                message = ResultCodeSystem.PARAM_ERROR;
            } else if (resultCode == 9) {
                message = ResultCodeSystem.INVALID_TOKEN;
            } else if (resultCode == 10) {
                message = ResultCodeSystem.FROZEN_ACCOUNT;
            } else if (resultCode == 500) {
                message = ResultCodeSystem.INNER_ERROR;
            } else if (msgCodeMap.containsKey(resultCode)) {
                message = msgCodeMap.get(resultCode);
            }
        }

        return new ResultJson<>(resultCode, data, message);
    }

    public static ResultJson successWithMsg(String msg) {
        return getResult(ResultCodeSystem.RESULT_CODE_0, null, msg);
    }

    public static ResultJson success() {
        return successWithMsg(null);
    }

    public static ResultJson failWithMsg(String msg) {
        return getResult(ResultCodeSystem.RESULT_CODE_50, null, msg);
    }

    public static ResultJson fail() {
        return failWithMsg(null);
    }

    public static ResultJson<Object> successWithData(Object data) {
        return getResult(ResultCodeSystem.RESULT_CODE_0, data, null);
    }
}
