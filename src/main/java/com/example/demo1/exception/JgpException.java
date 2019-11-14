package com.example.demo1.exception;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName JgpException
 * @date 2019/10/30  19:43
 */

public class JgpException extends RuntimeException {

    public Integer errCode;

    public JgpException(String msg, Integer errCode) {
        super(msg);
        this.errCode = errCode;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
