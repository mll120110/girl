package com.vision.girl.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * 全局异常处理类，可以根据实际情况进行拓展
 * 
 * @author Jack Road
 * @since 2019-09-20
 */

// 该注解可以捕获Controller层的异常信息，并捕获处理
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * SQL异常sqlExceptio
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean sqlException(SQLException e) {
        log.error("SQL异常", e);
        return ResultBean.error(500, "SQL异常" + e);
    }

    /**
     * 空指针异常
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean nullPointerException(NullPointerException e) {
        log.info("空指针异常", e);
        return ResultBean.error(500, "空指针异常" + e);
    }

    /**
     * 类型强制转换异常
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean classCastException(ClassCastException e) {
        log.info("类型强制转换异常", e);
        return ResultBean.error(500, "类型强制转换异常" + e);
    }

    /**
     * 字符串转换为数字异常
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean numberFormatException(NumberFormatException e) {
        log.info("字符串转换为数字异常", e);
        return ResultBean.error(500, "字符串转换为数字异常" + e);
    }

    /**
     * 方法未找到异常
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean noSuchMethodException(NoSuchMethodException e) {
        log.error("方法未找到异常", e);
        return ResultBean.error(500, "方法未找到异常" + e);
    }

    /**
     * 非法参数异常
     * 
     * @param e
     * @return ResultBean
     */
    @ExceptionHandler
    public ResultBean illegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常", e);
        return ResultBean.error(500, "非法参数异常" + e);
    }
}
