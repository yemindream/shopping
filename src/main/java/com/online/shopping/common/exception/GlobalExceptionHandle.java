package com.online.shopping.common.exception;

import com.online.shopping.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理(未被controller正常捕获的异常，都会到这里)
 * <p/>
 * Created by min.ye on 2020/1/15.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

    private static Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public final Object handleException(final Exception e,
                                            final HttpServletResponse response) {
        logger.error("请求出现错误:", e);
        Object returnData = ResultUtil.failWithMsg("网络异常，请稍后重试");
        return returnData;
    }
}
