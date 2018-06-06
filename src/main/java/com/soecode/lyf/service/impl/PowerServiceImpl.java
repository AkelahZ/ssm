package com.soecode.lyf.service.impl;

import com.soecode.lyf.IDao.PowerDao;
import com.soecode.lyf.entity.Power;
import com.soecode.lyf.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 *
 * @author ZLC
 */
@Service
public class PowerServiceImpl implements PowerService {
@Autowired
    PowerDao powerDao;
    @Override
    public List<Power> selectAll() {
        return powerDao.selectAll();
    }
}
