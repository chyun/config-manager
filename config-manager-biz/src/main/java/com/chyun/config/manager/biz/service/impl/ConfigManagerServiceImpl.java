package com.chyun.config.manager.biz.service.impl;

import com.chyun.config.manager.api.ConfigManagerService;
import com.chyun.config.manager.api.request.ReadPropertiesBySchemaReq;
import com.chyun.config.manager.api.request.ReadPropertyReq;
import com.chyun.config.manager.api.request.SetPropertyReq;
import com.chyun.config.manager.api.response.ReadPropertiesBySchemaResp;
import com.chyun.config.manager.api.response.ReadPropertyResp;
import com.chyun.config.manager.api.response.SetPropertyResp;
import com.chyun.config.manager.biz.zk.RemoteConfigManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ReadPropertiesBySchemaResp readPropertiesBySchema(ReadPropertiesBySchemaReq request) {
        ReadPropertiesBySchemaResp response = new ReadPropertiesBySchemaResp();
        response.setCode(ReadPropertiesBySchemaResp.CODE.FAIL);
        if (null == request || null == request.getSchema()) {
            LOGGER.error("Request.null");
            return response;
        }
        try {
            List<String> children = remoteConfigManager.readChildren(request.getSchema());
            if (null != children) {
                Map<String, String> retMap = new HashMap<String, String>();
                for (String prop : children) {
                    byte[] value = remoteConfigManager.read(request.getSchema(), prop);
                    String v = new String(value);
                    retMap.put(prop, v);
                }
                response.setCode(ReadPropertiesBySchemaResp.CODE.SUCCESS);
                response.setValues(retMap);
                return response;
            }
        } catch (Exception e) {
            LOGGER.error("ReadChildren occurred exception, schema is " + request.getSchema(), e);
            response.setCode(ReadPropertiesBySchemaResp.CODE.EXCEPTION);
        }

        return response;
    }

    public SetPropertyResp setProperty(SetPropertyReq request) {
        SetPropertyResp response = new SetPropertyResp();
        response.setCode(SetPropertyResp.CODE.FAIL);
        if (null == request || null == request.getSchema() || request.getKey() == null || "".equalsIgnoreCase(request.getKey().trim())) {
            LOGGER.error("Request.null");
            return response;
        }
        try {
            remoteConfigManager.update(request.getSchema(), request.getKey(), request.getValue());
            response.setCode(SetPropertyResp.CODE.SUCCESS);
        } catch (Exception e) {
            LOGGER.error("Request.null");
            response.setCode(SetPropertyResp.CODE.EXCEPTION);
        }
        return response;
    }
}
