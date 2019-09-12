package com.shunaier.demo.biz.dao;

import java.io.Serializable;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @param <T> The Model Class 这里是泛型不是Model类
 * @param <P> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface BaseDao<T, P extends Serializable> {
    int deleteByPrimaryKey(P id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(P id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);


}