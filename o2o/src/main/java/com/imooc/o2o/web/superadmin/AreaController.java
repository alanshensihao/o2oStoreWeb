package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    // when areaService used, inject areaService impl
    private AreaService areaService;

    // post vs get
    // post is relatively safe, get will print on UI
    @RequestMapping(value="/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
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
        return modelMap;
    }
}
