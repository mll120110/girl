package com.vision.girl.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * 全局异常处理类
 * 
 * @author Jack Road
 * @since 2019-09-20
 */

/**
 * 该注解可以捕获Controller层的异常信息，并捕获处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * SQL异常sqlExceptio
     * 
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResultBean sqlException(SQLException e) {
        log.error("SQL异常", e);
        return ResultBean.error(500, "SQL异常");
    }

    /**
     * 系统内部异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResultBean Exception(Exception e) {
        log.error("系统内部异常", e);
        return ResultBean.error(500, "系统内部异常" + e);
    }

}
