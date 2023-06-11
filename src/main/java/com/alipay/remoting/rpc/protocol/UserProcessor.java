/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.remoting.rpc.protocol;

import java.util.concurrent.Executor;

import com.alipay.remoting.AsyncContext;
import com.alipay.remoting.BizContext;
import com.alipay.remoting.LifeCycle;
import com.alipay.remoting.RemotingContext;

/**
 * Defined all functions for biz to process user defined request.
 *
 * 这里UserProcessor与{@link com.alipay.remoting.RemotingProcessor}的区别在于
 * 1. UserProcessor是用户自定义处理逻辑需要实现的接口。这里的用户是指本sofa-bolt组件的使用方
 * 2. RemotingProcessor是更为底层的抽象，其实现类包括{@link RpcHeartBeatProcessor},{@link RpcRequestProcessor},{@link RpcResponseProcessor}，即是本
 *    项目中实现基础Remoting处理能力需要实现的接口。比如这里要实现RPC功能，在sofa-bolt的rpc模块中就需要实现该接口。理论上该接口不暴露给使用sofa-bolt组件外部用户，
 *    除非他们需要实现类似本sofa-bolt项目的RPC模块相同的功能模块。
 *
 * @version $Id: UserProcessor.java, v 0.1 May 19, 2016 2:16:13 PM xiaomin.cxm Exp $
 */
public interface UserProcessor<T> extends LifeCycle {

    /**
     * Pre handle request, to avoid expose {@link RemotingContext} directly to biz handle request logic.
     *
     * @param remotingCtx remoting context
     * @param request request
     * @return BizContext
     */
    BizContext preHandleRequest(RemotingContext remotingCtx, T request);

    /**
     * Handle request with {@link AsyncContext}.
     * @param bizCtx biz context
     * @param asyncCtx async context
     * @param request request
     */
    void handleRequest(BizContext bizCtx, AsyncContext asyncCtx, T request);

    /**
     * Handle request in sync way.
     * @param bizCtx biz context
     * @param request request
     */
    Object handleRequest(BizContext bizCtx, T request) throws Exception;

    /**
     * The class name of user request.
     * Use String type to avoid classloader problem.
     *
     * @return interested request's class name
     */
    String interest();

    /**
     * Get user executor.
     * @return executor
     */
    Executor getExecutor();

    /**
     * Get business class loader
     * @return ClassLoader
     */
    ClassLoader getBizClassLoader();

    /**
     * Whether deserialize and process biz logic in io thread.
     * Notice: If return true, this will have a strong impact on performance.
     * @return true for processing in io thread
     */
    boolean processInIOThread();

    /**
     * Whether handle request timeout automatically, we call this fail fast processing when detect timeout.
     *
     * Notice: If you do not want to enable this feature, you need to override this method to return false,
     * and then call {@link BizContext#isRequestTimeout()} to check by yourself if you want.
     *
     * @return true if you want to enable fail fast processing, otherwise return false
     */
    boolean timeoutDiscard();

    /**
     * Use this method to set executor selector.
     * @param executorSelector executor selector
     */
    void setExecutorSelector(ExecutorSelector executorSelector);

    /**
     * Use this method to get the executor selector.
     * @return executor selector
     */
    ExecutorSelector getExecutorSelector();

    /**
     * Executor selector interface.
     * You can implement this and then provide a {@link ExecutorSelector} using method {@link #setExecutorSelector(ExecutorSelector)}
     *
     * @author xiaomin.cxm
     * @version $Id: ExecutorSelector.java, v 0.1 April 24, 2017 17:16:13 PM xiaomin.cxm Exp $
     */
    interface ExecutorSelector {
        Executor select(String requestClass, Object requestHeader);
    }
}
