package com.shunaier.demo.common.util;

import java.io.Serializable;

/**
 * 用途描述
 *
 * @author gsw
 * @version $Id: SubJsonResult, v0.1
 * 
 */
public class SubJsonResult implements Serializable {

    private static final long serialVersionUID = 2172033550893444596L;

    private String message;
    private String code;

    public SubJsonResult() {
    }

    public static SubJsonResult createDefault(String message) {
        return createDefault(message, "200");
    }

    public static SubJsonResult createDefault(String message, String code) {
        SubJsonResult subJsonResult = new SubJsonResult();
        subJsonResult.setMessage(message);
        subJsonResult.setCode(code);
        return subJsonResult;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubJsonResult{");
        sb.append("message='").append(this.message).append('\'');
        sb.append(", code='").append(this.code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
