package com.javabull.ssm.blog.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//返回数据
public class Msg implements Serializable {
    //操作码，100 成功，200 失败
    private int code;
    //返回操作信息
    private String msg;
    //包装数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.code = 100;
        msg.msg = "操作成功!";
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.code = 200;
        msg.msg = "操作失败!";
        return msg;
    }

    public static Msg fail(String msg) {
        Msg msg1 = new Msg();
        msg1.code = 100;
        msg1.msg = msg;
        return msg1;
    }

    public static Msg success(String msg) {
        Msg msg1 = new Msg();
        msg1.code = 200;
        msg1.msg = msg;
        return msg1;
    }

    public Msg add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public Msg setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Msg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public Msg setExtend(Map<String, Object> extend) {
        this.extend = extend;
        return this;
    }
}
