package com.shunaier.demo.common.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shunaier.demo.common.enums.SystemErrorEnum;
import com.shunaier.demo.common.exception.ICustomException;
import com.shunaier.demo.common.exception.SNEBizException;

/**
 * 断言类
 * @author yuanjiangnan
 */
public class AssertUtil {
	
	private AssertUtil(){

    }

    private static final Pattern MOBILE_PATTERN = Pattern.compile("^[1][0-9]{10}$");

    /**
     * 断言对象不为空，为空时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isNotNull(Object obj, ICustomException customException) {
        if (obj == null) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言对象不为空，为空时抛异常
     *
     * @param obj      对象
     * @param paramName 错误码
     */
    public static void isNotNullParam(Object obj, String paramName) {
        if (obj == null) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言字符串不为空，为空时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isNotEmpty(String obj, ICustomException customException) {
        if (obj == null || "".equals(obj)) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言集合不为空，为空时抛异常
     *
     * @param collection 集合
     * @param customException   错误码
     */
    public static void isNotEmpty(Collection collection, ICustomException customException) {
        if (collection == null || collection.isEmpty()) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言Map不为空，为空时抛异常
     *
     * @param map      集合
     * @param customException 错误码
     */
    public static void isNotEmpty(Map map, ICustomException customException) {
        if (map == null || map.isEmpty()) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言字符串字符串参数不为空，为空时抛参数异常
     *
     * @param obj      对象
     * @param paramName 参数名
     */
    public static void isNotEmptyParam(String obj, String paramName) {
        if (obj == null || "".equals(obj)) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言字符串字符串参数不为空，为空时抛参数异常
     *
     * @param collection      对象
     * @param paramName 参数名
     */
    public static void isNotEmptyParam(Collection collection, String paramName) {
        if (collection == null || collection.isEmpty()) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言字符串字符串参数不为空，为空时抛参数异常
     *
     * @param map      对象
     * @param paramName 参数名
     */
    public static void isNotEmptyParam(Map map, String paramName) {
        if (map == null || map.isEmpty()) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言对象为空，不为空时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isNull(Object obj, ICustomException customException) {
        if (obj != null) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言字符串为空，不为空时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isEmpty(String obj, ICustomException customException) {
        if (obj != null && !"".equals(obj)) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言集合不为空，为空时抛异常
     *
     * @param collection 集合
     * @param customException   错误码
     */
    public static void isEmpty(Collection collection, ICustomException customException) {
        if (collection != null && !collection.isEmpty()) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言Map不为空，为空时抛异常
     *
     * @param map      集合
     * @param customException 错误码
     */
    public static void isEmpty(Map map, ICustomException customException) {
        if (map != null && !map.isEmpty()) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言对象为空，不为空时抛异常
     *
     * @param obj      对象
     * @param paramName 错误码
     */
    public static void isNullParam(Object obj, String paramName) {
        if (obj != null) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言字符串为空，不为空时抛异常
     *
     * @param obj      对象
     * @param paramName 错误码
     */
    public static void isEmptyParam(String obj, String paramName) {
        if (obj != null && !"".equals(obj)) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言集合不为空，为空时抛异常
     *
     * @param collection 集合
     * @param paramName   错误码
     */
    public static void isEmptyParam(Collection collection, String paramName) {
        if (collection != null && !collection.isEmpty()) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言Map不为空，为空时抛异常
     *
     * @param map      集合
     * @param paramName 错误码
     */
    public static void isEmptyParam(Map map, String paramName) {
        if (map != null && !map.isEmpty()) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言对象为TRUE，FALSE时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isTrue(Boolean obj, ICustomException customException) {
        if (obj == null || Boolean.FALSE.equals(obj)) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言对象为TRUE，FALSE时抛异常
     *
     * @param obj      对象
     * @param paramName 错误码
     */
    public static void isTrueParam(Boolean obj, String paramName) {
        if (obj == null || Boolean.FALSE.equals(obj)) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言对象为FALSE，TRUE时抛异常
     *
     * @param obj      对象
     * @param customException 错误码
     */
    public static void isFalse(Boolean obj, ICustomException customException) {
        if (obj == null || Boolean.TRUE.equals(obj)) {
            throw new SNEBizException(customException);
        }
    }

    /**
     * 断言对象为FALSE，TRUE时抛异常
     *
     * @param obj      对象
     * @param paramName 错误码
     */
    public static void isFalseParam(Boolean obj, String paramName) {
        if (obj == null || Boolean.TRUE.equals(obj)) {
            throw new SNEBizException(paramName + "不能为空", SystemErrorEnum.PARAMETER_ANOMALY.getCode());
        }
    }

    /**
     * 断言为手机号
     *
     * @param obj 手机号字符串
     * @return
     */
    public static void isMobile(String obj, ICustomException customException) {
        isNotEmpty(obj, customException);

        Matcher m = MOBILE_PATTERN.matcher(obj);
        if (!m.matches()) {
            throw new SNEBizException(customException);
        }
    }
    
}
