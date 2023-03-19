package com.huashijun.drools.model;

/**
 * @author huashijun
 */
public enum UserType {

    /**
     * 一级会员
     */
    FIRSTLEVEL,

    /**
     * 二级会员
     */
    SECONDLEVEL,

    /**
     * 新用户
     */
    NEW;

    public String getValue() {
        return this.toString();
    }
}
