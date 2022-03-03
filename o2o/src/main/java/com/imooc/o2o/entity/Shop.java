package com.imooc.o2o.entity;

import java.util.Date;

public class Shop {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    // -1 not enabled, 0 under review, 1 enabled
    private Integer enableStatus;
    // admin suggestions to the shop owner
    private String advice;
    // category info
    // shop area, owner, and category shop under
    private Area area;
    private PersonInfo owner;
    private ShopCategory shopCategory;

    /**
     * @return Long return the shopId
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId the shopId to set
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return String return the shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName the shopName to set
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * @return String return the shopDesc
     */
    public String getShopDesc() {
        return shopDesc;
    }

    /**
     * @param shopDesc the shopDesc to set
     */
    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    /**
     * @return String return the shopAddr
     */
    public String getShopAddr() {
        return shopAddr;
    }

    /**
     * @param shopAddr the shopAddr to set
     */
    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String return the shopImg
     */
    public String getShopImg() {
        return shopImg;
    }

    /**
     * @param shopImg the shopImg to set
     */
    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    /**
     * @return Integer return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return Date return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return Date return the lastEditTime
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * @param lastEditTime the lastEditTime to set
     */
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    /**
     * @return Integer return the enableStatus
     */
    public Integer getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus the enableStatus to set
     */
    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return String return the advice
     */
    public String getAdvice() {
        return advice;
    }

    /**
     * @param advice the advice to set
     */
    public void setAdvice(String advice) {
        this.advice = advice;
    }

    /**
     * @return Area return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return PersonInfo return the owner
     */
    public PersonInfo getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(PersonInfo owner) {
        this.owner = owner;
    }

    /**
     * @return ShopCategory return the shopCategory
     */
    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    /**
     * @param shopCategory the shopCategory to set
     */
    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

}
