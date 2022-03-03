package com.imooc.o2o.entity;

import java.util.Date;

public class WechatAuth {
    private Long wechatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;
    

    /**
     * @return Long return the wechatAuthId
     */
    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    /**
     * @param wechatAuthId the wechatAuthId to set
     */
    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    /**
     * @return String return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
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
     * @return PersonInfo return the personInfo
     */
    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    /**
     * @param personInfo the personInfo to set
     */
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

}
