package com.mmc.protocol.socket;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @packageName：com.mmc.protocol.socket
 * @desrciption: 模拟SocketServer node1
 * @author: gaowei
 * @date： 2018-11-26 13:53
 * @history: (version) author date desc
 */
public class MockServerNode01 {


    public static void main(String[] args) {
        onStart(1111);
    }

    /**
     * 启动服务
     * @param port
     */
    public static void onStart(int port){
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("server node01 start.............");
            Socket socket;
            int count = 0;
            while (true) {
               socket = ss.accept();
                InputStream is = socket.getInputStream();
//                byte[] buffer = new byte[1024];
//                int len;
//                StringBuffer sb = new StringBuffer();
//                while ((len = is.read(buffer)) != -1) {
//                    sb.append(new String(buffer, "UTF-8"));
//                }
                ObjectInputStream ois = new ObjectInputStream(is);

                System.out.println("client number : " + ++count);
                System.out.println("server node01 get message : " + ois.readObject().toString());
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
        }
    }


    public static void stop() {

    }
}
