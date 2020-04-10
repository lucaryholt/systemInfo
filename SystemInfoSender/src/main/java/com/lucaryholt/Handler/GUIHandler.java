package com.lucaryholt.Handler;

import com.lucaryholt.Model.ConnectionInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIHandler extends JFrame {

    private JTextField jTextField;
    private JLabel jLabel;
    private JButton jButton;
    private ConnectionInfo connectionInfo;
    private ActionListener actionListener;
    private boolean infoWritten = false;

    public GUIHandler(){
        super("SystemInfoSender");
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        connectionInfo = new ConnectionInfo();

        new TrayIconHandler().initiateSystemTray();

        setupComponents();
    }

    private void setupComponents(){
        setLayout(new BorderLayout());

        makeJTextArea();

        makeJLabel();

        makeJButton();

        makeLayout();
    }

    private void makeJTextArea(){
        jTextField = new JTextField(20);
    }

    private void makeJLabel(){
        jLabel = new JLabel("What IP?");
    }

    private void makeJButton(){
        jButton = new JButton("OK");
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                connectionInfo.setIp(jTextField.getText());
                System.out.println("ip typed...");
                askForPort();
            }
        };
        jButton.addActionListener(actionListener);

        getRootPane().setDefaultButton(jButton);
    }

    private void makeLayout(){
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();

        panelTop.add(jLabel);
        panelTop.add(jTextField);

        panelBottom.add(jButton);

        add(panelTop, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
    }

    private void askForPort(){
        jLabel.setText("What port?");
        jButton.removeActionListener(actionListener);

        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("port typed...");

                connectionInfo.setPort(jTextField.getText());
                infoWritten = true;
                endStage();
            }
        };
        jButton.addActionListener(actionListener);

        jTextField.setText("");
    }

    private void endStage(){
        setVisible(false);
    }

    public ConnectionInfo getConnectionInfo() {
        while(!infoWritten){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connectionInfo;
    }
}

class TrayIconHandler{

    private static TrayIcon trayIcon = null;

    public void initiateSystemTray(){
        try {
            if(SystemTray.isSupported()) {
                // get the SystemTray instance
                SystemTray tray = SystemTray.getSystemTray();
                // load an image
                Image image = new ImageIcon("icon0.png").getImage();
                ActionListener listener = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("exiting...");

                        System.exit(1);
                    }
                };
                // create a popup menu
                PopupMenu popup = new PopupMenu();
                // create menu item for the default action
                MenuItem defaultItem = new MenuItem("Exit");
                defaultItem.addActionListener(listener);
                popup.add(defaultItem);
                /// ... add other items
                // construct a TrayIcon
                trayIcon = new TrayIcon(image, "SystemInfoSender", popup);
                // set the TrayIcon properties
                trayIcon.addActionListener(listener);
                // ...
                // add the tray image
                try {
                    tray.add(trayIcon);
                } catch (AWTException e) {
                    System.err.println(e);
                }
                // ...
                //System.out.println("system tray OK");
            } else {
                // disable tray option in your application or
                // perform other actions
                //...
                System.out.println("System tray not available.");
            }
            // ...
            // some time later
            // the application state has changed - update the image
            if (trayIcon != null) {
                //trayIcon.setImage(updatedImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void displayNotification(String title, String notif, TrayIcon.MessageType type){
        trayIcon.displayMessage(title, notif, type);
    }

}
