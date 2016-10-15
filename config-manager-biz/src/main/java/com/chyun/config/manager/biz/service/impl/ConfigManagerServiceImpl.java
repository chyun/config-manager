package com.chyun.config.manager.biz.service.impl;

import com.chyun.config.manager.api.ConfigManagerService;
import com.chyun.config.manager.api.request.ReadPropertyReq;
import com.chyun.config.manager.api.response.ReadPropertyResp;
import com.chyun.config.manager.biz.zk.RemoteConfigManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class ConfigManagerServiceImpl implements ConfigManagerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigManagerServiceImpl.class);

    @Autowired
    private RemoteConfigManager remoteConfigManager;

    public ReadPropertyResp readProperty(ReadPropertyReq request) {
        ReadPropertyResp response = new ReadPropertyResp();
        response.setCode(ReadPropertyResp.CODE.FAIL);
        if (null == request) {
            return response;
        }
        try {
            byte[] value = remoteConfigManager.read(request.getSchema(), request.getKey());
            String ret = new String(value);
            response.setValue(ret);
            response.setCode(ReadPropertyResp.CODE.SUCCESS);
        } catch (Exception e) {
            LOGGER.error("RemoteConfigManager.read.exception", e);
        }
        return response;
    }
}
