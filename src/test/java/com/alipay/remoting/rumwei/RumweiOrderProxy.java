/**
 * @(#)RumweiOrderProxy.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import com.alipay.remoting.exception.RemotingException;

/**
 * @guthor guwei
 */
public interface RumweiOrderProxy {

    RumweiOrderResponse order(RumweiOrderRequest request) throws RemotingException, InterruptedException;
}