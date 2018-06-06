package com.soecode.lyf.service;

import com.soecode.lyf.entity.Supply;
import com.soecode.lyf.entity.Supply_Result;
import com.soecode.lyf.entity.supplyProduct;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
public interface SupplyService {
    List<Supply> selectAll();
    int deleteByPK(Integer supply_Id);
    int insertSelective(Supply supply);
    int insertSupplyPSelective(supplyProduct supplyproduct);
    int updateSupply(Supply supply);
    Supply selectSByPk(Integer supply_id);
    List<supplyProduct> selectSPbySPK(Integer supply_id);

    List<Supply_Result> getAllsupplyProduct();
}
