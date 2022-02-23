package com.lolorsun.myblog;

//import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author lolorsun
 * @Date 2022/2/20 15:04
 * @Version 1.0
 */
//如果要跳转到对应的异常，还要使用注解置顶对应的状态码
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(String message, Throwable cause){
        super(message,cause);
    }

}
