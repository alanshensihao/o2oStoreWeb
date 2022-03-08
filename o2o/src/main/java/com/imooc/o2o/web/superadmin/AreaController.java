package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    // when areaService used, inject areaService impl
    @Autowired
    private AreaService areaService;

    // post vs get
    // post is relatively safe, get will print on UI
    @RequestMapping(value="/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        logger.info("===start===");
        long startTime = System.currentTimeMillis();
        // non duplicate areas
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // create area list
        List<Area> list = new ArrayList<Area>();
        try{
            list = areaService.getAreaList();
            // match easyUI terminologies
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        logger.error("test error!");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("===end===");
        return modelMap;
    }
}
