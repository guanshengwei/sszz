package com.shunaier.demo.common.exception;

/**
 * 业务异常类
 * @author yuanjiangnan
 */
public class SNEBizException extends RuntimeException {
	
	private static final long serialVersionUID = 1235196442382516631L;
	
	private String code;
    private ICustomException ICustomException;

    public SNEBizException(ICustomException ICustomException) {
        super(ICustomException.getMessage());
        this.code = ICustomException.getCode();
        this.ICustomException = ICustomException;
    }

    public SNEBizException(String message, String code) {
        super(message);
        this.code = code;
    }

    public SNEBizException(String message, Throwable cause, String code, ICustomException ICustomException) {
        super(message, cause);
        this.code = code;
        this.ICustomException = ICustomException;
    }

    public SNEBizException(Throwable cause, String code, ICustomException ICustomException) {
        super(cause);
        this.code = code;
        this.ICustomException = ICustomException;
    }

    public SNEBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, ICustomException ICustomException) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.ICustomException = ICustomException;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ICustomException getICustomException() {
        return this.ICustomException;
    }

    public void setICustomException(ICustomException ICustomException) {
        this.ICustomException = ICustomException;
    }
}