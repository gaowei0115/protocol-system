package com.mmc.protocol.exam;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @packageName：com.mmc.protocol.exam
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 14:21
 * @history: (version) author date desc
 */
public class SocketClient {

    public static void main(String[] args) {
        try {
            while (true) {
                Socket socket = new Socket("127.0.0.1", 5353);
                System.out.println(socket.isConnected());
                OutputStream ops = socket.getOutputStream();
                ops.write("hello socket".getBytes());
                ops.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
