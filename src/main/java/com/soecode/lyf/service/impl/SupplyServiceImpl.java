package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.SupplyDao;
import com.soecode.lyf.IDao.Supply_ResultDao;
import com.soecode.lyf.IDao.supplyProductMapper;
import com.soecode.lyf.entity.Supply;
import com.soecode.lyf.entity.Supply_Result;
import com.soecode.lyf.entity.supplyProduct;
import com.soecode.lyf.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 *
 * @author ZLC
 */
@Service
public class SupplyServiceImpl implements SupplyService{
    @Autowired
    private SupplyDao supplyDao;
    @Autowired
    private supplyProductMapper supplyprductMapper;
    @Autowired
    private Supply_ResultDao supply_resultDao;
    @Override
    public List<Supply> selectAll() {
        return supplyDao.selectAll();
    }

    @Override
    public int deleteByPK(Integer supply_Id) {
        return supplyDao.deleteByPrimaryKey(supply_Id);
    }

    @Override
    public int insertSelective(Supply supply) {
        return supplyDao.insertSelective(supply);
    }

    @Override
    public int insertSupplyPSelective(supplyProduct supplyproduct) {
        return supplyprductMapper.insertSelective(supplyproduct);
    }

    @Override
    public int updateSupply(Supply supply) {
        return supplyDao.updateByPrimaryKeySelective(supply);
    }


    @Override
    public Supply selectSByPk(Integer supply_id) {
        return supplyDao.selectByPrimaryKey(supply_id);
    }

    @Override
    public List<supplyProduct> selectSPbySPK(Integer supply_id){
        return supplyprductMapper.selectBySPK(supply_id);
    }

    @Override
    public List<Supply_Result> getAllsupplyProduct() {
        return supply_resultDao.selectAll();
    }
}
