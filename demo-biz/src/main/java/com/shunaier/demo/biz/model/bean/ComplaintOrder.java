package com.shunaier.demo.biz.model.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ps_complaint_order
 * @author 
 */
@Data
public class ComplaintOrder implements Serializable {
    /**
     * 投诉ID
     */
    private String complaintId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用马甲包
     */
    private String appName;

    /**
     * 显示名称
     */
    private String appNameView;

    /**
     * 投诉商户ID
     */
    private String complaintMerchantId;

    /**
     * 投诉商户名称
     */
    private String complaintMerchantName;

    /**
     * 投诉产品ID
     */
    private String complaintProductId;

    /**
     * 投诉产品名称
     */
    private String complaintProductName;

    /**
     * 投诉类型
     */
    private Integer complaintType;

    /**
     * 投诉标题
     */
    private String complaintTitle;

    /**
     * 投诉内容
     */
    private String complaintContent;

    /**
     * 指派理商户
     */
    private String assignMerchantId;

    /**
     * 指派产品
     */
    private String assignProductId;

    /**
     * 状态
     */
    private Integer complaintState;

    /**
     * 处理结果
     */
    private String handleResult;

    /**
     * 解决投诉截止时间
     */
    private Date planEndDate;

    /**
     * 实际解决投诉时间
     */
    private Date actualEndDate;

    /**
     * 删除标识
     */
    private Integer isDelete;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    private static final long serialVersionUID = 1L;

}