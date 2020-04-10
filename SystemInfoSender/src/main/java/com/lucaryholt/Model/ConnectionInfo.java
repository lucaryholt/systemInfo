package com.lucaryholt.Model;

public class ConnectionInfo {

    private String ip;
    private int port;

    public ConnectionInfo() {
    }

    public ConnectionInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public ConnectionInfo(String ip, String port){
        this.ip = ip;
        this.port = Integer.parseInt(port);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    public void setPort(int port){
        this.port = port;
    }
}
