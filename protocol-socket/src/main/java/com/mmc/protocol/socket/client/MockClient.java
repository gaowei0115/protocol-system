package com.mmc.protocol.socket.client;

import com.mmc.protocol.socket.KeepAlive;
import com.mmc.protocol.socket.ServerConfig;
import com.mmc.protocol.socket.utils.ServersPropertiesUtil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @packageName：com.mmc.protocol.socket.client
 * @desrciption: 模拟Socket客户端操作
 * @author: gaowei
 * @date： 2018-11-26 15:02
 * @history: (version) author date desc
 */
public class MockClient {


    private boolean isRunning;

    private Socket socket;
    private String serverId;


    public MockClient() {
        isRunning = false;
    }

    public void onStart() {
        if (isRunning) {
            return;
        }

        ServerConfig serverConfig = ServersPropertiesUtil.getServerConfig();
        serverId = serverConfig.getServerId();
        try {
            socket = new Socket(serverConfig.getIp(), serverConfig.getPort());
        } catch (IOException e) {
            System.out.println(serverId + " 启动服务加载配置异常 : " + e.getMessage());
            ServersPropertiesUtil.modifyServer(serverId);
            return;
        }
        System.out.println("local port : " + socket.getLocalPort());
        isRunning = true;
        // 启动监听
        new Thread(new KeepAliveWatch(this, isRunning, serverId)).start();
    }

    public void sendMessage(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println(serverId + "send message : " + obj);
        oos.writeObject(obj);
        oos.flush();
    }



    class KeepAliveWatch implements Runnable {

        private final MockClient client;
        private final boolean isRunning;
        private final String serverId;

        public KeepAliveWatch(MockClient client, boolean isRunning, String serverId) {
            this.client = client;
            this.isRunning = isRunning;
            this.serverId = serverId;
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    client.sendMessage(new KeepAlive());
                } catch (IOException e) {
                    System.out.println(serverId + " 监听服务异常 : " + e.getMessage());
                    ServersPropertiesUtil.modifyServer(serverId);
                }
            }
        }
    }
}
