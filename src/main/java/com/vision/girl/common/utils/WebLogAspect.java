package com.vision.girl.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web请求API，请求参数，及返回参数打印日志
 *
 * @author Jack_Road
 * @date 2019/11/01 11:06
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    private final ObjectMapper mapper;

    @Autowired
    public WebLogAspect(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 配置多个过滤项
     * 
     * 捕获controller层使用相关类型请求协议类型
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) ||"
        + " @annotation(org.springframework.web.bind.annotation.PostMapping) || "
        + " @annotation(org.springframework.web.bind.annotation.GetMapping)) || "
        + " @annotation(org.springframework.web.bind.annotation.DeleteMapping) || "
        + " @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        for (Object object : joinPoint.getArgs()) {
            if (object instanceof MultipartFile || object instanceof HttpServletRequest
                || object instanceof HttpServletResponse) {
                continue;
            }
            if (log.isDebugEnabled()) {
                log.info(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
                    + " : request parameter : " + mapper.writeValueAsString(object));
            }
        }
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(Object response) throws Throwable {
        if (response != null) {
            log.info("response parameter : " + mapper.writeValueAsString(response));
        }
    }
}
