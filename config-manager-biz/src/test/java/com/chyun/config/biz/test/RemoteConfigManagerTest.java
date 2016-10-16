package com.chyun.config.biz.test;

import com.chyun.config.manager.biz.zk.RemoteConfigManager;

import java.util.List;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class RemoteConfigManagerTest {
    public static void main(String[] args) {
        RemoteConfigManager rcm = new RemoteConfigManager();
        rcm.setZkConnectString("127.0.0.1:2181");
        rcm.init();
        rcm.initSchema("config-manager");
        try {
            rcm.update("config-manager", "test.key1", "value1");
            rcm.update("config-manager", "test.key2", "value2");
            String s = new String(rcm.read("config-manager", "test.key2"));
            List<String> ch = rcm.readChildren("config-manager");
            System.out.println("Value for key:" + ch.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
