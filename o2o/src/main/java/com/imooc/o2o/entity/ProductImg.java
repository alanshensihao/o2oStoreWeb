package com.imooc.o2o.entity;

import java.util.Date;

public class ProductImg {
    private Long productImgId;
    private String imgAddr;
    private String imgDesc;
    private Integer priority;
    private Date createTime;
    private Long productId;

    /**
     * @return Long return the productImgId
     */
    public Long getProductImgId() {
        return productImgId;
    }

    /**
     * @param productImgId the productImgId to set
     */
    public void setProductImgId(Long productImgId) {
        this.productImgId = productImgId;
    }

    /**
     * @return String return the imgAddr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * @param imgAddr the imgAddr to set
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    /**
     * @return String return the imgDesc
     */
    public String getImgDesc() {
        return imgDesc;
    }

    /**
     * @param imgDesc the imgDesc to set
     */
    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
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
     * @return Long return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
