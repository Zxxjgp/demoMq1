package com.example.demo1.exception;

import com.example.demo1.core.ActionResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName ExceptionHandler
 * @date 2019/10/30  19:46
 */
@RestControllerAdvice
public class JgpExceptionHandler {

    @ExceptionHandler(JgpException.class)
    public ActionResult handleException(JgpException e) {
        if ( null != e ) {
            if (!StringUtils.isEmpty(e.getMessage())) {
                return new ActionResult(e.getErrCode(), e.getMessage());
            }
            return ActionResult.error();
        }
        return new ActionResult(500, "未知异常");
    }

}
