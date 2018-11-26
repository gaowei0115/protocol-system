package com.mmc.protocol.socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName：com.mmc.protocol.socket
 * @desrciption: 模拟SocketServer node1
 * @author: gaowei
 * @date： 2018-11-26 13:53
 * @history: (version) author date desc
 */
public class MockServerNode02 {


    public static void main(String[] args) {
        onStart(2222);
    }

    /**
     * 启动服务
     * @param port
     */
    public static void onStart(int port){
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("server node02 start.............");
            while (true) {
               Socket socket = ss.accept();
               InputStream is = socket.getInputStream();
//               byte[] buffer = new byte[1024];
//               int len;
//               StringBuffer sb = new StringBuffer();
//               while ((len = is.read(buffer)) != -1) {
//                   sb.append(new String(buffer, "UTF-8"));
//               }
                ObjectInputStream ois = new ObjectInputStream(is);
                System.out.println("server node02 get message : " + ois.readObject().toString());
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
        }
    }


    public static void stop() {

    }
}
