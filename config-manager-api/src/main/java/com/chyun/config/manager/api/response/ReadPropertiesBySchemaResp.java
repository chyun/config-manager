package com.chyun.config.manager.api.response;

import java.io.Serializable;
import java.util.Map;

/**
 * 类的实现描述: Created by Calix on 16/10/16.
 */
public class ReadPropertiesBySchemaResp implements Serializable {
    private static final long serialVersionUID = 399078790474988245L;
    public interface CODE {
        int FAIL = 0;
        int SUCCESS = 1;
        int EXCEPTION = -1;
    }
    private int code; //0:fail, 1:success, -1:exception

    private Map<String, String> values;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}
