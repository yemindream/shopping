package com.online.shopping.common.exception;

import com.online.shopping.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

    private static Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public final Object handleException(final Exception e,
                                            final HttpServletResponse response) {
        logger.error("request error: ", e);
        Object returnData = ResultUtil.failWithMsg("network error, try again later.");
        return returnData;
    }
}
