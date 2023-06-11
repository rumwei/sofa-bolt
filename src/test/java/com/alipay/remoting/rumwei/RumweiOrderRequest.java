/**
 * @(#)RumweiOrderRequest.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @guthor guwei
 */
public class RumweiOrderRequest implements Serializable {
    private String guestName;
    private BigDecimal price;
    private String hotel;
    private String addr;

    public RumweiOrderRequest(String guestName, BigDecimal price, String hotel, String addr) {
        this.guestName = guestName;
        this.price = price;
        this.hotel = hotel;
        this.addr = addr;
    }

    public RumweiOrderRequest() {
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}