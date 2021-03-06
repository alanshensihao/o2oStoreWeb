package com.imooc.o2o.service.impl;

import java.io.InputStream;
import java.util.Date;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional 
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        // check if shop null
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        
        // shop category, shop area, shop id null check

        try {
            // initialize shop
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            // add shop info
            int effectedNum = shopDao.insertShop(shop);
            // runtime exception test
            // throw new ShopOperationException("shop creation failed");
            if(effectedNum <= 0) {
                // rollback
                throw new ShopOperationException("shop creation failed");
            } else {
                if (shopImgInputStream != null) {
                    // store pictures
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error:" + e.getMessage());
                    }

                    // update shop picture address
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new ShopOperationException("updateShopImg error:");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }


        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        // retrieve shop relative address from PathUtil 
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);

        shop.setShopImg(shopImgAddr);
    }
}
