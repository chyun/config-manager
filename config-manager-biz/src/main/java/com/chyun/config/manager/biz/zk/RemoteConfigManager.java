package com.chyun.config.manager.biz.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class RemoteConfigManager {
    private static final String DEFAULT_NAMESPACE = "/config-center";
    private static final String DEFAULT_DECODE = "utf-8";
    private CuratorFramework zkClient;
    private String zkConnectString;

    public void init() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        zkClient = CuratorFrameworkFactory.newClient(zkConnectString, retryPolicy);
        zkClient.start();
        //initServicePath()
    }

    public boolean initSchema(String schema) {
        try {
            if (zkClient.checkExists().forPath(DEFAULT_NAMESPACE) == null) {
                zkClient.create().withMode(CreateMode.PERSISTENT).forPath(DEFAULT_NAMESPACE);
            }
            String node = generateServicePath(schema);
            if (zkClient.checkExists().forPath(node) != null) {
                throw new RuntimeException("this service config have been inited for servicePath:" + schema);
            } else {
                zkClient.create().withMode(CreateMode.PERSISTENT).forPath(node);
            }
        } catch (Exception e) {
            //logger.error("checkServiceConfigExists exception:{}",e);
            return false;
        }
        return true;
    }

    private void initServicePath(String servicePath) {
        try {
            if (zkClient.checkExists().forPath(DEFAULT_NAMESPACE) == null) {
                zkClient.create().withMode(CreateMode.PERSISTENT).forPath(DEFAULT_NAMESPACE);
            }
            if (zkClient.checkExists().forPath(servicePath) == null) {
                zkClient.create().withMode(CreateMode.PERSISTENT).forPath(servicePath);
            }
        } catch (Exception e) {
            //logger.error("checkServiceConfigExists exception:{}", e);
        }
    }

    private String generateServicePath(String schema) {
        return DEFAULT_NAMESPACE.concat("/").concat(schema);
    }

    private String generateKeyPath(String schema, String key) {
        return generateServicePath(schema).concat("/").concat(key);
    }

    public void update(String schema, String key, String value) throws Exception {
        final String keyPath = generateKeyPath(schema, key);
        if (zkClient.checkExists().forPath(keyPath) == null) {
            zkClient.create().withMode(CreateMode.PERSISTENT).forPath(keyPath);
        }
        zkClient.setData().forPath(keyPath, value.getBytes(DEFAULT_DECODE));
    }

    public void delete(String schema, String key) throws Exception {
        final String keyPath = generateKeyPath(schema, key);
        zkClient.delete().forPath(keyPath);
    }

    public byte[] read(String schema, String key) throws Exception {
        final String keyPath = generateKeyPath(schema, key);
        return zkClient.getData().forPath(keyPath);
    }

    public List<String> readChildren(String schema) throws Exception {
        final String keyPath = generateServicePath(schema);
        List<String> children = zkClient.getChildren().forPath(keyPath);
        return children;
    }

    public void setZkConnectString(String zkConnectString) {
        this.zkConnectString = zkConnectString;
    }

    public String getZkConnectString() {
        return this.zkConnectString;
    }
}
