package com.shunaier.demo.server.advice;

import com.shunaier.demo.common.exception.SNEBizException;
import com.shunaier.demo.common.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用途描述
 *
 * @author gsw
 * @version $Id: SNEExceptionHandler, v0.1
 * @company 
 * @date 2019年09月09日 4:40 PM gsw Exp $
 */
@Slf4j
@ControllerAdvice
public class SNEExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle(Exception e){
        if (e instanceof SNEBizException){
            SNEBizException bizException = (SNEBizException) e;
            return JsonResult.error(bizException.getCode(),bizException.getMessage());
        }else {
            //将系统异常以打印出来
            log.info("ExceptionAdvice [系统异常]{}", e);
            return JsonResult.error("-1","未知错误");
        }
    }

}
