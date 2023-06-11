/**
 * @(#)OrderServer.java, 6月 08, 2023.
 * <p>
 * Copyright 2023 sona.com. All rights reserved.
 * SONA.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.alipay.remoting.rumwei;

import com.alipay.remoting.*;
import com.alipay.remoting.rpc.RpcServer;
import com.alipay.remoting.rpc.protocol.UserProcessor;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @guthor guwei
 */
public class OrderServer {

    private final RpcServer server = new RpcServer(9998, true);

    public OrderServer() {
        server.registerUserProcessor(new UserProcessor<RumweiOrderRequest>() {
            @Override
            public BizContext preHandleRequest(RemotingContext remotingCtx, RumweiOrderRequest request) {
                return new BizContext() {
                    @Override
                    public String getRemoteAddress() {
                        return null;
                    }

                    @Override
                    public String getRemoteHost() {
                        return null;
                    }

                    @Override
                    public int getRemotePort() {
                        return 0;
                    }

                    @Override
                    public Connection getConnection() {
                        return null;
                    }

                    @Override
                    public boolean isRequestTimeout() {
                        return false;
                    }

                    @Override
                    public int getClientTimeout() {
                        return 1000;
                    }

                    @Override
                    public long getArriveTimestamp() {
                        return 100;
                    }

                    @Override
                    public void put(String key, String value) {

                    }

                    @Override
                    public String get(String key) {
                        return null;
                    }

                    @Override
                    public InvokeContext getInvokeContext() {
                        return remotingCtx.getInvokeContext();
                    }
                };
            }

            @Override
            public void handleRequest(BizContext bizCtx, AsyncContext asyncCtx, RumweiOrderRequest request) {

            }

            @Override
            public Object handleRequest(BizContext bizCtx, RumweiOrderRequest request) throws Exception {
                long arriveTimestamp = bizCtx.getArriveTimestamp();
                int clientTimeout = bizCtx.getClientTimeout();
                return new RumweiOrderResponse(0, true, 1, "17771068815");
            }

            @Override
            public String interest() {
                return RumweiOrderRequest.class.getName();
            }

            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public ClassLoader getBizClassLoader() {
                return null;
            }

            @Override
            public boolean processInIOThread() {
                return false;
            }

            @Override
            public boolean timeoutDiscard() {
                return false;
            }

            @Override
            public void setExecutorSelector(ExecutorSelector executorSelector) {

            }

            @Override
            public ExecutorSelector getExecutorSelector() {
                return null;
            }

            @Override
            public void startup() throws LifeCycleException {

            }

            @Override
            public void shutdown() throws LifeCycleException {

            }

            @Override
            public boolean isStarted() {
                return false;
            }
        });
        server.startup();
    }

    public static void main(String[] args) throws IOException {
        new OrderServer();
        System.in.read();
        System.out.println(2);
    }
}