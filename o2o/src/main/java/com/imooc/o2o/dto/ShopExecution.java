package com.imooc.o2o.dto;

import java.util.List;

import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;

public class ShopExecution {
    // result state
    private int state;

    // state info
    private String stateInfo;

    // shop quantity
    private int count;

    // shop object
    private Shop shop;

    // shop list (query purpose)
    private List<Shop> shopList;

    public ShopExecution() {

    }

    // constructor for shop when created failed
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // constructor for shop when created successfully
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    // constructor for shop when created successfully
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }


    /**
     * 
     * @param state
     */
    public int getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * 
     * @return stateInfo
     */
    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * @param stateInfo the stateInfo to set
     */
    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    /**
     * @return int return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return Shop return the shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * @return List<Shop> return the shopList
     */
    public List<Shop> getShopList() {
        return shopList;
    }

    /**
     * @param shopList the shopList to set
     */
    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

}
