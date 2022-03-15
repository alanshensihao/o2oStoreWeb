package com.imooc.o2o.enums;

public enum ShopStateEnum {
    CHECK(0, "under review"), OFFLINE(-1, "invalid shop"), SUCCESS(1, "modification sucess"),
    PASS(2, "review passed"), INNER_ERROR(-1001,"internal system error"),
    NULL_SHOPID(-1002,"ShopId is empty"),
    NULL_SHOP(-1003,"Shop info is empty");

    private int state;
    private String stateInfo;
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }


    /**
     * return corresponding enum value
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum stateEnum: values()) {
            if(stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    /**
     * @return String return the stateInfo
     */
    public String getStateInfo() {
        return stateInfo;
    }

    public int getState() {
        return state;
    }

}