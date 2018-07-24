package com.yx.photo.system;

import java.io.Serializable;

/**
 * 数据字典实体类
 * @author yangxiang
 * @date 2018/7/18 17:13
 */
public class DictData implements Serializable{

    private String id;
    private String dictCode;
    private String enumCode;
    private String enumName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getEnumCode() {
        return enumCode;
    }

    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode;
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }
}
