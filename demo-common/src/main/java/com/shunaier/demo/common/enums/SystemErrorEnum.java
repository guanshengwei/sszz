package com.shunaier.demo.common.enums;

import com.shunaier.demo.common.exception.ICustomException;

/**
 * 系统异常枚举
 * @author yuanjiangnan
 */
public enum SystemErrorEnum implements ICustomException {

	/**
     * 失败
     */
    FAIL("100", "失败"),
	
	/**
     * 成功
     */
    SUCCESS("200", "成功"),

    /**
     * 对不起，系统发生异常
     */
    SYSTEM_BUSY("300", "处理中，请稍后"),

    /**
     * 对不起，系统发生异常
     */
    SYSTEM_ANOMALY("400", "对不起，数据异常"),

    /**
     * 对不起，参数异常
     */
    PARAMETER_ANOMALY("500", "对不起，参数异常"),

    ;
	
    /**
     * 错误Code值
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 构造方法
     * @param code    错误Code
     * @param message 错误信息
     */
    SystemErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
