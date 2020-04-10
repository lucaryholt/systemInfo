package com.lucaryholt.Main;

import com.lucaryholt.Handler.GUI.ConsolePrinter;
import com.lucaryholt.Handler.GUI.JFrameGUI;
import com.lucaryholt.Handler.ProcessHandler;

public class Main {

    public static void main(String[] args) {
        ProcessHandler processHandler = new ProcessHandler();
        processHandler.setGuiHandler(new JFrameGUI());
        int port = 0;

        //jlabels med farvet tekst?

        if(args.length != 0){
            for(int i = 0; i < args.length; i++){
                if(args[i].equals("nogui")){
                    processHandler.setGuiHandler(new ConsolePrinter());
                } else if(args[i].equals("-p")){
                    port = Integer.parseInt(args[i + 1]);
                    i++;
                } else{
                    System.out.println("could not understand command: " + args[i] + "...");
                }
            }
        }

        if(port == 0){
            processHandler.start();
        } else{
            processHandler.startConnection(port);
        }
    }

}
