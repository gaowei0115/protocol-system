package com.mmc.protocol.exam;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName：com.mmc.protocol.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 14:19
 * @history: (version) author date desc
 */
public class SocketServerTest {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5353);

            System.out.println("socket server start ..... ");
            while (true) {
                Socket socket = ss.accept();

                InputStream is = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                StringBuilder sb = new StringBuilder();
                while ((len = is.read(bytes)) != -1) {
                    //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }
                System.out.println("get message from client: " + sb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
