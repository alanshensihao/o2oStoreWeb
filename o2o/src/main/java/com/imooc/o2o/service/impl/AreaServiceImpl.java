package com.imooc.o2o.service.impl;

import java.util.List;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.entity.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
