package com.lucaryholt.Handler.GUI;

import com.lucaryholt.Model.ReceiveData;

public class ConsolePrinter implements GUIHandler {

    public void printWindow(ReceiveData receiveData){
        clearScreen();

        printLine(1, receiveData.getCpuName(), receiveData.getGpuName());
        printLine(2, ("#1: \t" + receiveData.getCpuCore1Temp() + " C"), ("Temp: \t" + receiveData.getGpuTemp() + " C"));
        printLine(3, ("#2: \t" + receiveData.getCpuCore2Temp() + " C"), ("Fan: \t" + receiveData.getGpuFan() + " RPM"));
        printLine(4, ("#3: \t" + receiveData.getCpuCore3Temp() + " C"), ("Core load: \t" + receiveData.getGpuCoreLoad() + " %"));
        printLine(5, ("#4: \t" + receiveData.getCpuCore4Temp() + " C"), ("MCL: \t" + receiveData.getGpuMemoryControllerLoad() + " %"));
        printLine(6, ("CPU: \t" + receiveData.getCpuTemp()) + " C", ("GPU Mem: \t" + receiveData.getGpuMemoryLoad() + " %"));
        printLine(7, ("#1: \t" + receiveData.getCpuCore1Load() + " %"), ("Vid. Eng.: \t" + receiveData.getGpuVideoEngineLoad() + " %"));
        printLine(8, ("#2: \t" + receiveData.getCpuCore2Load() + " %"), "");
        printLine(9, ("#3: \t" + receiveData.getCpuCore3Load() + " %"), "");
        printLine(10, ("#4: \t" + receiveData.getCpuCore4Load() + " %"), "");
        printLine(11, ("CPU: \t" + receiveData.getCpuLoad() + " %"), "");
        printLine(12, "", "");
        printLine(13, ("RAM: \t" + receiveData.getMemoryLoad() + " %"), "");

    }

    private void moveTo(int x, int y){
        System.out.print("\u001b[" + y + ";" + x + "H"); //move cursor to row y, col x
    }

    private void clearScreen(){
        System.out.print("\u001b[2J"); //clear entire screen
    }

    private void printLine(int y, String one, String two){
        moveTo(1,y);

        System.out.println(one);

        moveTo(40, y);

        System.out.println("||");

        moveTo(45, y);

        System.out.println(two);
    }

}
