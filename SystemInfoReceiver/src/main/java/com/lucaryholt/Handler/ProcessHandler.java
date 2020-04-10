package com.lucaryholt.Handler;

import com.lucaryholt.Handler.GUI.GUIHandler;
import com.lucaryholt.Model.ReceiveData;

import java.util.Scanner;

public class ProcessHandler {

    private Scanner scanner = new Scanner(System.in);
    private ConnectionHandler connectionHandler = new ConnectionHandler();
    private GUIHandler guiHandler;

    public void setGuiHandler(GUIHandler guiHandler) {
        this.guiHandler = guiHandler;
    }

    public void start(){
        System.out.println("What port?");

        int port = scanner.nextInt(); scanner.nextLine();

        startConnection(port);
    }

    public void startConnection(int port){
        connectionHandler.initiateConnection(port);

        processLoop();
    }

    private void processLoop(){
        while(true){
            ReceiveData receiveData = connectionHandler.recvData();
            //ReceiveData receiveData = testData();

            guiHandler.printWindow(receiveData);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private ReceiveData testData(){
//        ReceiveData receiveData = new ReceiveData();
//
//        receiveData.setCpuName("Intel Core i9 6700K");
//        receiveData.setCpuCore1Temp(27.0);
//        receiveData.setCpuCore2Temp(28.0);
//        receiveData.setCpuCore3Temp(33.0);
//        receiveData.setCpuCore4Temp(22.0);
//        receiveData.setCpuTemp(34.0);
//        receiveData.setCpuCore1Load(2.0);
//        receiveData.setCpuCore2Load(3.89898);
//        receiveData.setCpuCore3Load(2.31233);
//        receiveData.setCpuCore4Load(3.99898);
//        receiveData.setCpuLoad(5.17387);
//
//        receiveData.setMemoryLoad(22.8998);
//
//        receiveData.setGpuName("Nvidea Geforce 1080");
//        receiveData.setGpuTemp(33.0);
//        receiveData.setGpuFan(300.0);
//        receiveData.setGpuCoreLoad(3.3233);
//        receiveData.setGpuMemoryControllerLoad(4.7879);
//        receiveData.setGpuVideoEngineLoad(6.7877);
//        receiveData.setGpuMemoryLoad(34.08898);
//
//        return receiveData;
//    }

}
