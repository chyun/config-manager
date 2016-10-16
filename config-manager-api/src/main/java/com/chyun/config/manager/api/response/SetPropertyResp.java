package com.chyun.config.manager.api.response;

import java.io.Serializable;

/**
 * 类的实现描述: Created by Calix on 16/10/16.
 */
public class SetPropertyResp implements Serializable {
    private static final long serialVersionUID = -4373843165203615497L;
    public interface CODE {
        int FAIL = 0;
        int SUCCESS = 1;
        int EXCEPTION = -1;
    }
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
