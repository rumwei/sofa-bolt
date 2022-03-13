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

import com.alipay.remoting.config.Configuration;
import com.alipay.remoting.rpc.protocol.UserProcessor;

/**
 * @author chengyi (mark.lx@antfin.com) 2018-06-16 06:55
 */
public interface RemotingServer extends Configuration, LifeCycle {

    /**
     * Get the ip of the server.
     * @return ip
     */
    String ip();

    /**
     * Get the port of the server.
     * @return listened port
     */
    int port();

    /**
     * Register processor for command with the command code.
     * gw-通过protocolCode找到对应的protocol，再将commandCode和processor注册到protocol.CommandHandler中去
     *
     * @param protocolCode protocol code
     * @param commandCode command code
     * @param processor processor
     */
    void registerProcessor(byte protocolCode, CommandCode commandCode,
                           RemotingProcessor<?> processor);

    /**
     * Register default executor service for server.
     * gw-通过protocolCode找到对应的protocol，再将executor注册到protocol.CommandHandler中去
     *
     * @param protocolCode protocol code
     * @param executor the executor service for the protocol code
     */
    void registerDefaultExecutor(byte protocolCode, ExecutorService executor);

    /**
     * Register user processor.
     * @param processor user processor which can be a single-interest processor or a multi-interest processor
     */
    void registerUserProcessor(UserProcessor<?> processor);
}
