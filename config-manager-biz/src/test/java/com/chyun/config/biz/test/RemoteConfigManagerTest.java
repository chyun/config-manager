package com.chyun.config.biz.test;

import com.chyun.config.manager.biz.zk.RemoteConfigManager;

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
            String s = new String(rcm.read("config-manager", "test.key1"));
            System.out.println("Value for key:" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
