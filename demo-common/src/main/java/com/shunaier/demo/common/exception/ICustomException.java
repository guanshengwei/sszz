package com.shunaier.demo.common.exception;

/**
 * 异常消息类接口
 * @author yuanjiangnan
 */
public interface ICustomException {

	/**
	 * 错误码
	 * @return
	 */
	String getCode();

	/**
	 * 错误消息
	 * @return
	 */
    String getMessage();
	
}
