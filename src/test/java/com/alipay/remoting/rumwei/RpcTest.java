package com.alipay.remoting.rumwei;

import com.alipay.remoting.Connection;
import com.alipay.remoting.rpc.RpcClient;
import com.alipay.remoting.rpc.RpcServer;
import com.alipay.remoting.rpc.common.RequestBody;
import com.alipay.remoting.rpc.common.SimpleServerUserProcessor;
import org.junit.Test;

public class RpcTest {
    private final RpcServer server = new RpcServer(9998, true);
    private final RpcClient client = new RpcClient();

    @Test
    public void rpcTest() throws Exception {
        server.registerUserProcessor(new SimpleServerUserProcessor());
        server.startup();
        client.startup();
        Connection connection = client.getConnection("localhost:9998", 3000);
        RequestBody req = new RequestBody();
        req.setId(1);
        req.setMsg(RequestBody.DEFAULT_ONEWAY_STR);
        Object response = client.invokeSync(connection, req, 3000);
        System.out.println(response);

    }
}
