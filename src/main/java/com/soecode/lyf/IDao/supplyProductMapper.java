package com.soecode.lyf.IDao;

import com.soecode.lyf.entity.supplyProduct;

import java.util.List;

public interface supplyProductMapper {
    int deleteByPrimaryKey(Integer supplyResourceId);

    int insert(supplyProduct record);

    int insertSelective(supplyProduct record);

    supplyProduct selectByPrimaryKey(Integer supplyResourceId);

    List<supplyProduct> selectBySPK(Integer supplyId);

    int updateByPrimaryKeySelective(supplyProduct record);

    int updateByPrimaryKey(supplyProduct record);
}