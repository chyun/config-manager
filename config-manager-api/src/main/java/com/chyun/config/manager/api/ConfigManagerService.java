package com.chyun.config.manager.api;

import com.chyun.config.manager.api.request.ReadPropertiesBySchemaReq;
import com.chyun.config.manager.api.request.ReadPropertyReq;
import com.chyun.config.manager.api.request.SetPropertyReq;
import com.chyun.config.manager.api.response.ReadPropertiesBySchemaResp;
import com.chyun.config.manager.api.response.ReadPropertyResp;
import com.chyun.config.manager.api.response.SetPropertyResp;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public interface ConfigManagerService {
    ReadPropertyResp readProperty(ReadPropertyReq request);
    ReadPropertiesBySchemaResp readPropertiesBySchema(ReadPropertiesBySchemaReq request);
    SetPropertyResp setProperty(SetPropertyReq request);
}
