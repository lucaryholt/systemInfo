package com.lucaryholt.Main;

import com.lucaryholt.Handler.GUIHandler;
import com.lucaryholt.Handler.ProcessHandler;

public class Main {

    public static void main(String[] args) {
        GUIHandler guiHandler = new GUIHandler();

        guiHandler.setVisible(true);

        new ProcessHandler().start(guiHandler.getConnectionInfo());
    }

}
