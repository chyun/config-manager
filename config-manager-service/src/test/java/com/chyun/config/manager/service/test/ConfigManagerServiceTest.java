package com.chyun.config.manager.service.test;

import com.chyun.config.manager.api.ConfigManagerService;
import com.chyun.config.manager.api.request.ReadPropertyReq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class ConfigManagerServiceTest extends AbstractIntegerityTest {

    @Autowired
    private ConfigManagerService configManagerService;

    @Test
    public void testReadProperty() {
        ReadPropertyReq req = new ReadPropertyReq();
        req.setSchema("config-manager");
        req.setKey("test.key1");
        System.out.println("Property is: " + configManagerService.readProperty(req).getValue());
    }
}
