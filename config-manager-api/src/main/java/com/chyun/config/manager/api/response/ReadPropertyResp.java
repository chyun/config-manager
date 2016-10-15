package com.chyun.config.manager.api.response;

import java.io.Serializable;

/**
 * 类的实现描述: Created by Calix on 15/10/16.
 */
public class ReadPropertyResp implements Serializable {
    public interface CODE {
        int FAIL = 0;
        int SUCCESS = 1;
        int EXCEPTION = -1;
    }

    private int code; //0:fail, 1:success, -1:exception

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
