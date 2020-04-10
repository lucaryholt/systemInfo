package com.lucaryholt.Handler;

import com.lucaryholt.Model.SendData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler {

    private Socket socket;
    private PrintWriter pw;
    private BufferedReader bufferedReader;

    public boolean initiateConnection(String ip, int port){
        try {
            socket = new Socket(ip, port);

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            pw = new PrintWriter(socket.getOutputStream(), true);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection(){
        try {
            bufferedReader.close();

            pw.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendData(SendData sendData){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("cpuName", sendData.getCpuName());
        jsonObject.put("cpuCore1Temp", sendData.getCpuCore1Temp());
        jsonObject.put("cpuCore2Temp", sendData.getCpuCore2Temp());
        jsonObject.put("cpuCore3Temp", sendData.getCpuCore3Temp());
        jsonObject.put("cpuCore4Temp", sendData.getCpuCore4Temp());
        jsonObject.put("cpuTemp", sendData.getCpuTemp());
        jsonObject.put("cpuCore1Load", sendData.getCpuCore1Load());
        jsonObject.put("cpuCore2Load", sendData.getCpuCore2Load());
        jsonObject.put("cpuCore3Load", sendData.getCpuCore3Load());
        jsonObject.put("cpuCore4Load", sendData.getCpuCore4Load());
        jsonObject.put("cpuLoad", sendData.getCpuLoad());

        jsonObject.put("memoryLoad", sendData.getMemoryLoad());

        jsonObject.put("gpuName", sendData.getGpuName());
        jsonObject.put("gpuTemp", sendData.getGpuTemp());
        jsonObject.put("gpuFan", sendData.getGpuFan());
        jsonObject.put("gpuCoreLoad", sendData.getGpuCoreLoad());
        jsonObject.put("gpuMemoryControllerLoad", sendData.getGpuMemoryControllerLoad());
        jsonObject.put("gpuVideoEngineLoad", sendData.getGpuVideoEngineLoad());
        jsonObject.put("gpuMemoryLoad", sendData.getGpuMemoryLoad());

        send(jsonObject.toJSONString());
    }

    private void send(String data){
        pw.println(data);
    }

    private String recv(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
