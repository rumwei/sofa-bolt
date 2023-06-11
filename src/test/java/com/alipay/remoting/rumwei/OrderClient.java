/**
 * @(#)OrderClient.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import com.alipay.remoting.exception.RemotingException;

import java.math.BigDecimal;

/**
 * @guthor guwei
 */
public class OrderClient {
    public static void main(String[] args) throws RemotingException, InterruptedException {
        RumweiOrderProxy rumweiOrderProxy = new RumweiOrderProxyImpl();
        RumweiOrderResponse response = rumweiOrderProxy.order(new RumweiOrderRequest(
                "xiaoming",
                new BigDecimal(100),
                "Boz Hotel",
                "Olin Street"));
        System.out.println();
    }
}