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
package com.alipay.remoting;

import java.util.concurrent.ExecutorService;

/**
 * Remoting processor processes remoting commands.
 *
 * * 这里RemotingProcessor与{@link com.alipay.remoting.rpc.protocol.UserProcessor}的区别在于
 *  * 1. UserProcessor是用户自定义处理逻辑需要实现的接口。这里的用户是指本sofa-bolt组件的使用方
 *  * 2. RemotingProcessor是更为底层的抽象，其实现类包括{@link com.alipay.remoting.rpc.protocol.RpcHeartBeatProcessor},{@link com.alipay.remoting.rpc.protocol.RpcRequestProcessor},{@link com.alipay.remoting.rpc.protocol.RpcResponseProcessor}，即是本
 *  *    项目中实现基础Remoting处理能力需要实现的接口。比如这里要实现RPC功能，在sofa-bolt的rpc模块中就需要实现该接口。理论上该接口不暴露给使用sofa-bolt组件外部用户，
 *  *    除非他们需要实现类似本sofa-bolt项目的RPC模块相同的功能模块。
 * 
 * @version $Id: RemotingProcessor.java, v 0.1 Dec 22, 2015 11:48:43 AM tao Exp $
 */
public interface RemotingProcessor<T extends RemotingCommand> {

    /**
     * Process the remoting command.
     * 
     * @param ctx
     * @param msg
     * @param defaultExecutor
     * @throws Exception
     */
    void process(RemotingContext ctx, T msg, ExecutorService defaultExecutor) throws Exception;

    /**
     * Get the executor.
     * 
     * @return
     */
    ExecutorService getExecutor();

    /**
     * Set executor.
     * 
     * @param executor
     */
    void setExecutor(ExecutorService executor);

}
