package com.lucaryholt.Handler;

import com.lucaryholt.Model.ReceiveData;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Disk;
import com.profesorfalken.jsensors.model.components.Gpu;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ConnectionHandler {

    private Socket socket;
    private PrintWriter pw;
    private BufferedReader bufferedReader;

    public boolean initiateConnection(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            socket = serverSocket.accept();

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

    public void send(String data){
        pw.println(data);
    }

    public ReceiveData recvData(){
        JSONParser parser = new JSONParser();

        String recv = recv();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(recv);

            return instantiateReceiveData(jsonObject);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ReceiveData instantiateReceiveData(JSONObject jsonObject){
        ReceiveData receiveData = new ReceiveData();

        receiveData.setCpuName((String)jsonObject.get("cpuName"));
        receiveData.setCpuCore1Temp(getDoubleFromJSONObject("cpuCore1Temp", jsonObject));
        receiveData.setCpuCore2Temp(getDoubleFromJSONObject("cpuCore2Temp", jsonObject));
        receiveData.setCpuCore3Temp(getDoubleFromJSONObject("cpuCore3Temp", jsonObject));
        receiveData.setCpuCore4Temp(getDoubleFromJSONObject("cpuCore4Temp", jsonObject));
        receiveData.setCpuTemp(getDoubleFromJSONObject("cpuTemp", jsonObject));
        receiveData.setCpuCore1Load(getDoubleFromJSONObject("cpuCore1Load", jsonObject));
        receiveData.setCpuCore2Load(getDoubleFromJSONObject("cpuCore2Load", jsonObject));
        receiveData.setCpuCore3Load(getDoubleFromJSONObject("cpuCore3Load", jsonObject));
        receiveData.setCpuCore4Load(getDoubleFromJSONObject("cpuCore4Load", jsonObject));
        receiveData.setCpuLoad(getDoubleFromJSONObject("cpuLoad", jsonObject));

        receiveData.setMemoryLoad(getDoubleFromJSONObject("memoryLoad", jsonObject));

        receiveData.setGpuName((String)jsonObject.get("gpuName"));
        receiveData.setGpuTemp(getDoubleFromJSONObject("gpuTemp", jsonObject));
        receiveData.setGpuFan(getDoubleFromJSONObject("gpuFan", jsonObject));
        receiveData.setGpuCoreLoad(getDoubleFromJSONObject("gpuCoreLoad", jsonObject));
        receiveData.setGpuMemoryControllerLoad(getDoubleFromJSONObject("gpuMemoryControllerLoad", jsonObject));
        receiveData.setGpuVideoEngineLoad(getDoubleFromJSONObject("gpuVideoEngineLoad", jsonObject));
        receiveData.setGpuMemoryLoad(getDoubleFromJSONObject("gpuMemoryLoad", jsonObject));

        return receiveData;
    }

    private double getDoubleFromJSONObject(String key, JSONObject jsonObject){
        return (Double) jsonObject.get(key);
    }

    public String recv(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
