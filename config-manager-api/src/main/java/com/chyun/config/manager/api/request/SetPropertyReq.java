package com.chyun.config.manager.api.request;

import java.io.Serializable;

/**
 * 类的实现描述: Created by Calix on 16/10/16.
 */
public class SetPropertyReq implements Serializable {
    private static final long serialVersionUID = 7348025901098495829L;
    private String schema;
    private String key;
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
