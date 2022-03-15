package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {
    /*** 
     * add new shop
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * update shop information
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
