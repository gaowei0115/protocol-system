package com.mmc.protocol.socket.client;

import com.mmc.protocol.socket.utils.ServersPropertiesUtil;

import java.io.IOException;


/**
 * @packageName：com.mmc.protocol.socket.client
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 16:51
 * @history: (version) author date desc
 */
public class ClientApp {

    public static void main(String[] args) {
        // 设置server信息
        ServersPropertiesUtil.addServer("serverNode01", "127.0.0.1", 1111);
        ServersPropertiesUtil.addServer("serverNode02", "127.0.0.1", 2222);

        MockClient mockClient = new MockClient();
        mockClient.onStart();
    }
}
