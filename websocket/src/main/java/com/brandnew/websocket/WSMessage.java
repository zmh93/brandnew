package com.brandnew.websocket;

public class WSMessage {
    private String name; //操作人名称
    private String opt;  //具体操作
    private String path; //前端路径后缀

    public WSMessage() {
    }

    public WSMessage(String name, String opt, String path) {
        this.name = name;
        this.opt = opt;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
