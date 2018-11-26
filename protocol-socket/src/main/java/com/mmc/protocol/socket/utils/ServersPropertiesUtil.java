package com.mmc.protocol.socket.utils;

import com.mmc.protocol.socket.ServerConfig;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @packageName：com.mmc.protocol.socket.utils
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 15:15
 * @history: (version) author date desc
 */
public class ServersPropertiesUtil {

    /**
     * 服务状态
     */
    private static ConcurrentMap<String, ServerConfig> serversMap = new ConcurrentHashMap<>();

    private static Random random = new Random();
    private static Vector<String> serverIds = new Vector<>();


    /**
     * 添加服务信息
     * @param serverId
     * @param port
     */
    public static void addServer(String serverId, String ip, int port) {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setServerId(serverId);
        serverConfig.setIp(ip);
        serverConfig.setPort(port);
        serverConfig.setCount(new AtomicInteger(0));
        serversMap.put(serverId, serverConfig);
        serverIds.add(serverId);
    }

    public static void removeServer(String serverId) {
        serversMap.remove(serverId);
    }

    public static void modifyServer(String serverId) {
        ServerConfig serverConfig = serversMap.get(serverId);
        serverConfig.getCount().incrementAndGet();
        serversMap.put(serverId, serverConfig);
    }

    public static void resetServer(String serverId) {
        ServerConfig serverConfig = serversMap.get(serverId);
        serverConfig.setCount(new AtomicInteger(0));
        serversMap.put(serverId, serverConfig);
    }

    public static ServerConfig getServerConfig() {
        int size = serversMap.size();
        int index = random.nextInt(size);
        ServerConfig serverConfig;
        while ((serverConfig = serversMap.get(serverIds.get(random.nextInt(size)))) != null) {
            if (serverConfig.isUse()) {
                break;
            } else {
                System.out.println(serverConfig + " 服务不可用.....");
            }
        }
        return serverConfig;
    }



}
