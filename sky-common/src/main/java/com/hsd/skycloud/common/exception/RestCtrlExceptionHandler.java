package com.hsd.skycloud.common.exception;


import com.hsd.skycloud.common.utils.ResultUtil;
import com.hsd.skycloud.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Exrickx
 */
@Slf4j
@RestControllerAdvice
public class RestCtrlExceptionHandler {

    @ExceptionHandler(XCloudException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleXCloudException(XCloudException e) {
        String errorMsg = "XCloud exception";
        if (e!=null){
            errorMsg=e.getMessage();
            log.warn(e.toString());
        }
        return new ResultUtil<>().setErrorMsg(500, errorMsg);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleException(Exception e) {
        String errorMsg = "Exception";
        if (e!=null){
            errorMsg=e.getMessage();
            log.warn(e.toString());
        }
        return new ResultUtil<>().setErrorMsg(500, errorMsg);
    }
}
