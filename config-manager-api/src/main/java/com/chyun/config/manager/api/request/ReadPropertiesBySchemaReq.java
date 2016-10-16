package com.chyun.config.manager.api.request;

import java.io.Serializable;

/**
 * 类的实现描述: Created by Calix on 16/10/16.
 */
public class ReadPropertiesBySchemaReq implements Serializable {
    private static final long serialVersionUID = 7169492086178788614L;

    private String schema;

    private int code; //0:fail, 1:success, -1:exception

    private String value;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
