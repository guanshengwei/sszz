package com.shunaier.demo.biz.dao;

import com.shunaier.demo.biz.model.bean.ComplaintOrder;
import com.shunaier.demo.biz.model.param.ComplaintOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ComplaintOrderMapper继承基类
 */
public interface ComplaintOrderMapper extends BaseDao<ComplaintOrder, String> {

    /**
     * 根据投诉ID获取投诉单
     * @param complaintIdList
     * @return
     */
    List<ComplaintOrder> getByComplaintIdList(@Param("complaintIdList") List<String> complaintIdList);

    /**
     * 分页查询
     * @param query
     * @return
     */
    List<ComplaintOrder> findList(ComplaintOrderQuery query);

}