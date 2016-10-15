package com.chyun.config.manager.api.request;

import java.io.Serializable;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class ReadPropertyReq implements Serializable{
    private static final long serialVersionUID = 5568288623251966558L;
    private String schema;
    private String key;
    private String property;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
