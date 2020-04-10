package com.lucaryholt.Handler.GUI;

import com.lucaryholt.Model.Reading;
import com.lucaryholt.Model.ReceiveData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFrameGUI extends JFrame implements GUIHandler {

    private String CELCIUS = "C";
    private String PROCENT = "%";
    private String RPM = "RPM";

    private Reading cpuName = new Reading("", "");
    private Reading cpuCore1Temp = new Reading("#1", CELCIUS);
    private Reading cpuCore2Temp = new Reading("#2", CELCIUS);
    private Reading cpuCore3Temp = new Reading("#3", CELCIUS);
    private Reading cpuCore4Temp = new Reading("#4", CELCIUS);
    private Reading cpuTemp = new Reading("Temp", CELCIUS);
    private Reading cpuCore1Load = new Reading("#1", PROCENT);
    private Reading cpuCore2Load = new Reading("#2", PROCENT);
    private Reading cpuCore3Load = new Reading("#3", PROCENT);
    private Reading cpuCore4Load = new Reading("#4", PROCENT);
    private Reading cpuLoad = new Reading("Load", PROCENT);

    private Reading memoryLoad = new Reading("Memory", PROCENT);

    private Reading gpuName = new Reading("", "");
    private Reading gpuTemp = new Reading("Temp", CELCIUS);
    private Reading gpuFan = new Reading("Fan", RPM);
    private Reading gpuCoreLoad = new Reading("Core load", PROCENT);
    private Reading gpuMemoryControllerLoad = new Reading("MCL", PROCENT);
    private Reading gpuVideoEngineLoad = new Reading("Vid. Eng.", PROCENT);
    private Reading gpuMemoryLoad = new Reading("GPU Mem", PROCENT);

    List<Reading> readingsCPU = new ArrayList<>();
    List<Reading> readingsGPU = new ArrayList<>();

    private JTextArea cpuText = new JTextArea();
    private JTextArea gpuText = new JTextArea();

    public JFrameGUI(){
        super("SystemInfo");
        setSize(350,240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        setupComponents();
    }

    private void setupComponents(){
        addCPUReadings();
        addGPUReadings();

        updateText();

        add(cpuText, BorderLayout.LINE_START);
        add(gpuText, BorderLayout.LINE_END);
    }

    private String stringFromReadings(List<Reading> readings){
        StringBuilder sb = new StringBuilder();

        for(Reading r : readings){
            sb.append(r.getText() + "\n");
        }

        return sb.toString();
    }

    private void updateText(){
        cpuText.setText(stringFromReadings(readingsCPU));
        gpuText.setText(stringFromReadings(readingsGPU));
    }

    private void addCPUReadings(){
        readingsCPU.add(cpuName);
        readingsCPU.add(cpuCore1Temp);
        readingsCPU.add(cpuCore2Temp);
        readingsCPU.add(cpuCore3Temp);
        readingsCPU.add(cpuCore4Temp);
        readingsCPU.add(cpuTemp);
        readingsCPU.add(cpuCore1Load);
        readingsCPU.add(cpuCore2Load);
        readingsCPU.add(cpuCore3Load);
        readingsCPU.add(cpuCore4Load);
        readingsCPU.add(cpuLoad);
        readingsCPU.add(memoryLoad);
    }

    private void addGPUReadings(){
        readingsGPU.add(gpuName);
        readingsGPU.add(gpuTemp);
        readingsGPU.add(gpuFan);
        readingsGPU.add(gpuCoreLoad);
        readingsGPU.add(gpuMemoryControllerLoad);
        readingsGPU.add(gpuVideoEngineLoad);
        readingsGPU.add(gpuMemoryLoad);
    }

    @Override
    public void printWindow(ReceiveData receiveData) {
        setVisible(true);

        cpuName.setText(receiveData.getCpuName());
        cpuCore1Temp.setText(receiveData.getCpuCore1Temp());
        cpuCore2Temp.setText(receiveData.getCpuCore2Temp());
        cpuCore3Temp.setText(receiveData.getCpuCore3Temp());
        cpuCore4Temp.setText(receiveData.getCpuCore4Temp());
        cpuTemp.setText(receiveData.getCpuTemp());
        cpuCore1Load.setText(receiveData.getCpuCore1Load());
        cpuCore2Load.setText(receiveData.getCpuCore2Load());
        cpuCore3Load.setText(receiveData.getCpuCore3Load());
        cpuCore4Load.setText(receiveData.getCpuCore4Load());
        cpuLoad.setText(receiveData.getCpuLoad());

        memoryLoad.setText(receiveData.getMemoryLoad());

        gpuName.setText(receiveData.getGpuName());
        gpuTemp.setText(receiveData.getGpuTemp());
        gpuFan.setText(receiveData.getGpuFan());
        gpuCoreLoad.setText(receiveData.getGpuCoreLoad());
        gpuMemoryControllerLoad.setText(receiveData.getGpuMemoryControllerLoad());
        gpuVideoEngineLoad.setText(receiveData.getGpuVideoEngineLoad());
        gpuMemoryLoad.setText(receiveData.getGpuMemoryLoad());

        updateText();
    }
}
