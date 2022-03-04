package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaDaoTest extends BaseTest{
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3,areaList.size());     
    }
      
}
