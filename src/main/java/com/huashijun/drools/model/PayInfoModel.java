package com.huashijun.drools.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author huashijun
 */
public class PayInfoModel {

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 订单金额
     */
    private Integer amount;

    /**
     * 用户类型
     */
    private UserType userType;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}