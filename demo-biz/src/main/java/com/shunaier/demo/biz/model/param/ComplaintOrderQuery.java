package com.shunaier.demo.biz.model.param;

import lombok.Data;

import java.util.List;

/**
 * 用途描述
 *
 * @author gsw
 * @version $Id: ComplaintOrderQuery, v0.1
 * 
 */
@Data
public class ComplaintOrderQuery {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 指派理商户
     */
    private String merchantId;

    /**
     * 状态
     */
    private List<Integer> complaintStateList;

}
