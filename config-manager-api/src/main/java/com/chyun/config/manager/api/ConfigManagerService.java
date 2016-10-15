package com.chyun.config.manager.api;

import com.chyun.config.manager.api.request.ReadPropertyReq;
import com.chyun.config.manager.api.response.ReadPropertyResp;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public interface ConfigManagerService {
    ReadPropertyResp readProperty(ReadPropertyReq request);
}
