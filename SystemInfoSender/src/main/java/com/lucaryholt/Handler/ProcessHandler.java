package com.lucaryholt.Handler;

import com.lucaryholt.Model.ConnectionInfo;
import com.lucaryholt.Model.SendData;
import com.lucaryholt.Service.SystemInfoReader;

import java.awt.*;

public class ProcessHandler {

    private ConnectionHandler connectionHandler = new ConnectionHandler();
    private SystemInfoReader systemInfoReader = new SystemInfoReader();
    private String appName = "System Info Sender";

    public void start(ConnectionInfo connectionInfo){
        System.out.println("information received... connecting...");

        TrayIconHandler.displayNotification("System Info Sender", "Trying to connect...", TrayIcon.MessageType.INFO);

        if(connectionHandler.initiateConnection(connectionInfo.getIp(), connectionInfo.getPort())){
            TrayIconHandler.displayNotification(appName, "Connected!", TrayIcon.MessageType.INFO);

            processLoop();
        }else{
            TrayIconHandler.displayNotification(appName, "Could not connect...", TrayIcon.MessageType.ERROR);
            System.exit(1);
        }
    }

    public void processLoop(){
        System.out.println("connected... reading info...");

        while(true){
            SendData sendData = systemInfoReader.getSystemInfo();

            connectionHandler.sendData(sendData);

            System.out.println("info sent...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
