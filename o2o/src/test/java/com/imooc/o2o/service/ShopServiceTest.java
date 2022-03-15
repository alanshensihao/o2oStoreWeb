package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        shop.setShopCategory(shopCategory);
        shop.setOwner(owner);
        shop.setArea(area);

        shopCategory.setShopCategoryId(1L);
        owner.setUserId(1L);
        area.setAreaId(2);
        shop.setShopName("service test");
        shop.setShopDesc("service test");
        shop.setPhone("service test");
        shop.setCreateTime(new Date());
        // enum update
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("under review");       
        // shopImg 
        File shopImg = new File("B:/VS_Project/Java/eCommerce/image/moose.jpg");
        ShopExecution se = shopService.addShop(shop,shopImg);
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
