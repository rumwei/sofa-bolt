/**
 * @(#)RumweiOrderProxyImpl.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import com.alipay.remoting.Connection;
import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcClient;


/**
 * @guthor guwei
 */
public class RumweiOrderProxyImpl implements RumweiOrderProxy {

    private final RpcClient client = new RpcClient();

    public RumweiOrderProxyImpl() {
        client.startup();
    }

    @Override
    public RumweiOrderResponse order(RumweiOrderRequest request) throws RemotingException, InterruptedException {
        Connection connection = client.getConnection("localhost:9998", 3000);
        return (RumweiOrderResponse) client.invokeSync(connection, request, 3000);
    }
}