package com.mmc.protocol.socket;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @packageName：com.mmc.protocol.socket
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 16:00
 * @history: (version) author date desc
 */
public class ServerConfig {

    private String serverId;
    private String ip;
    private int port;
    private AtomicInteger count;
    private boolean isUse = true;


    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public boolean isUse() {
        if (getCount().get() > 2) {
            return false;
        }
        return isUse;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ServerConfig{" +
                "serverId='" + serverId + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", count=" + count +
                ", isUse=" + isUse +
                '}';
    }
}
