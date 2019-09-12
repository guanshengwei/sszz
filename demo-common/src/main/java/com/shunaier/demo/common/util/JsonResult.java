package com.shunaier.demo.common.util;

import com.shunaier.demo.common.enums.SystemErrorEnum;
import com.shunaier.demo.common.exception.ICustomException;

import java.io.Serializable;

/**
 * json 接口返回数据结构
 * @author yuanjiangnan
 */
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -2420994155211715217L;

    private SubJsonResult result;
    private T data;

    public JsonResult() {
    }

    public SubJsonResult getResult() {
        return this.result;
    }

    public void setResult(SubJsonResult result) {
        this.result = result;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 创建返回值
     * @param data
     * @param subJsonResult
     * @param <T>
     * @return
     */
    public static <T> JsonResult createResult(T data, SubJsonResult subJsonResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(data);
        jsonResult.setResult(subJsonResult);
        return jsonResult;
    }

    /**
     * 当正确时返回的值
     * @param data
     * @return
     */
    public static <T> JsonResult success(T data){
        return createResult(data, SubJsonResult.createDefault(SystemErrorEnum.SUCCESS.getMessage()));
    }

    /**
     * 当正确时返回的值
     * @return
     */
    public static JsonResult success(){
        return success(null);
    }

    /**
     * 当错误时返回的值
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult error(String code, String msg){
        return JsonResult.createResult(null, SubJsonResult.createDefault(msg, code));
    }


    /**
     * 当错误时返回的值
     * @param codeEnum
     * @return
     */
    public static JsonResult error(ICustomException codeEnum){
        return error(codeEnum.getCode(), codeEnum.getMessage());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JsonResult{");
        sb.append("result=").append(this.result);
        sb.append(", data=").append(this.data);
        sb.append('}');
        return sb.toString();
    }

}