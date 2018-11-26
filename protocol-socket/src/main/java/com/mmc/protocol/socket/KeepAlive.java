package com.mmc.protocol.socket;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName：com.mmc.protocol.socket
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-26 15:06
 * @history: (version) author date desc
 */
public class KeepAlive implements Serializable {

    private static final long serialVersionUID = 68618073360050916L;

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Override
    public String toString() {
        return dataFormat.format(new Date()) + "\t keepalive connect";
    }
}
