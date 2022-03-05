package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaServiceTest extends BaseTest {
    @Autowired
    // with autowired, if areaService is used, spring will inject implemented methods
    // it is a service level class
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        // 
        List<Area>areaList = areaService.getAreaList();
        assertEquals("north end",areaList.get(0).getAreaName());
        
    }
}
