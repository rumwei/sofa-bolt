/**
 * @(#)RumweiOrderResponse.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import java.io.Serializable;

/**
 * @guthor guwei
 */
public class RumweiOrderResponse implements Serializable {
    private int code;
    private boolean success;
    private long orderNo;
    private String phone;

    public RumweiOrderResponse(int code, boolean success, long orderNo, String phone) {
        this.code = code;
        this.success = success;
        this.orderNo = orderNo;
        this.phone = phone;
    }

    public RumweiOrderResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}