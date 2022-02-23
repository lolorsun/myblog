package com.lolorsun.myblog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author lolorsun
 * @Date 2022/2/20 15:29
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //定义一个切面
    @Pointcut("execution(* com.lolorsun.myblog.web.*.*(..))")
    public void log(){

    }
    //切面执行前需要执行的
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest =  attributes.getRequest();
        String url = servletRequest.getRequestURL().toString();
        String ip = servletRequest.getRemoteHost();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+'.'+joinPoint.getSignature().getName();
        Object []args = joinPoint.getArgs();
        RequestLog requestLog =  new RequestLog(url,ip,classMethod,args);
//        logger.info("----doBefore----");
        logger.info("Request:{}",requestLog);
    }
    //切面执行后的需要执行的
    @After("log()")
    public void doAfter(){
//        logger.info("----doAfter----");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result:{}",result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
