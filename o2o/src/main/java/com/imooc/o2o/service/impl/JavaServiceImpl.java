package com.imooc.o2o.service.impl;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.ShopService;

public class JavaServiceImpl implements ShopService {

    @Override
    public ShopExecution addShop(Shop shop, Enum enumState) {
        // check if shop null
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        
        // shop category, shop area, shop id null check

        return null;
    }
}
