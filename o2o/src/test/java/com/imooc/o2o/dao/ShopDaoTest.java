package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ShopDaoTest extends BaseTest{
    @Autowired
    private ShopDao shopDao;
    
    @Test
    @Ignore
    public void testInsertShop() {
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

        shop.setShopName("test");
        shop.setShopDesc("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("under review");

        System.out.println(shop.getShopCategory().getShopCategoryId());
        // retrieve effect number of rows
        int effectNum = shopDao.insertShop(shop);
        assertEquals(1,effectNum);
    }
    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(36L);
        shop.setShopDesc("test updated");
        shop.setShopAddr("test updated");
        shop.setLastEditTime(new Date());
        
        int effectNum = shopDao.updateShop(shop);
        assertEquals(1,effectNum);
    }
}
