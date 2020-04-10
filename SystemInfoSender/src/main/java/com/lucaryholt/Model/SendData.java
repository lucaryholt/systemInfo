package com.lucaryholt.Model;


import java.util.List;

public class SendData {

    private String cpuName;
    private double cpuCore1Temp;
    private double cpuCore2Temp;
    private double cpuCore3Temp;
    private double cpuCore4Temp;
    private double cpuTemp;
    private double cpuCore1Load;
    private double cpuCore2Load;
    private double cpuCore3Load;
    private double cpuCore4Load;
    private double cpuLoad;

    private double memoryLoad;

    private String gpuName;
    private double gpuTemp;
    private double gpuFan;
    private double gpuCoreLoad;
    private double gpuMemoryControllerLoad;
    private double gpuVideoEngineLoad;
    private double gpuMemoryLoad;

    public SendData() {
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public double getCpuCore1Temp() {
        return cpuCore1Temp;
    }

    public void setCpuCore1Temp(double cpuCore1Temp) {
        this.cpuCore1Temp = cpuCore1Temp;
    }

    public double getCpuCore2Temp() {
        return cpuCore2Temp;
    }

    public void setCpuCore2Temp(double cpuCore2Temp) {
        this.cpuCore2Temp = cpuCore2Temp;
    }

    public double getCpuCore3Temp() {
        return cpuCore3Temp;
    }

    public void setCpuCore3Temp(double cpuCore3Temp) {
        this.cpuCore3Temp = cpuCore3Temp;
    }

    public double getCpuCore4Temp() {
        return cpuCore4Temp;
    }

    public void setCpuCore4Temp(double cpuCore4Temp) {
        this.cpuCore4Temp = cpuCore4Temp;
    }

    public double getCpuTemp() {
        return cpuTemp;
    }

    public void setCpuTemp(double cpuTemp) {
        this.cpuTemp = cpuTemp;
    }

    public double getCpuCore1Load() {
        return cpuCore1Load;
    }

    public void setCpuCore1Load(double cpuCore1Load) {
        this.cpuCore1Load = cpuCore1Load;
    }

    public double getCpuCore2Load() {
        return cpuCore2Load;
    }

    public void setCpuCore2Load(double cpuCore2Load) {
        this.cpuCore2Load = cpuCore2Load;
    }

    public double getCpuCore3Load() {
        return cpuCore3Load;
    }

    public void setCpuCore3Load(double cpuCore3Load) {
        this.cpuCore3Load = cpuCore3Load;
    }

    public double getCpuCore4Load() {
        return cpuCore4Load;
    }

    public void setCpuCore4Load(double cpuCore4Load) {
        this.cpuCore4Load = cpuCore4Load;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(double cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public double getMemoryLoad() {
        return memoryLoad;
    }

    public void setMemoryLoad(double memoryLoad) {
        this.memoryLoad = memoryLoad;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public double getGpuTemp() {
        return gpuTemp;
    }

    public void setGpuTemp(double gpuTemp) {
        this.gpuTemp = gpuTemp;
    }

    public double getGpuFan() {
        return gpuFan;
    }

    public void setGpuFan(double gpuFan) {
        this.gpuFan = gpuFan;
    }

    public double getGpuCoreLoad() {
        return gpuCoreLoad;
    }

    public void setGpuCoreLoad(double gpuCoreLoad) {
        this.gpuCoreLoad = gpuCoreLoad;
    }

    public double getGpuMemoryControllerLoad() {
        return gpuMemoryControllerLoad;
    }

    public void setGpuMemoryControllerLoad(double gpuMemoryControllerLoad) {
        this.gpuMemoryControllerLoad = gpuMemoryControllerLoad;
    }

    public double getGpuVideoEngineLoad() {
        return gpuVideoEngineLoad;
    }

    public void setGpuVideoEngineLoad(double gpuVideoEngineLoad) {
        this.gpuVideoEngineLoad = gpuVideoEngineLoad;
    }

    public double getGpuMemoryLoad() {
        return gpuMemoryLoad;
    }

    public void setGpuMemoryLoad(double gpuMemoryLoad) {
        this.gpuMemoryLoad = gpuMemoryLoad;
    }

    @Override
    public String toString() {
        return "SendData{" +
                "cpuName='" + cpuName + '\'' +
                ", cpuCore1Temp=" + cpuCore1Temp +
                ", cpuCore2Temp=" + cpuCore2Temp +
                ", cpuCore3Temp=" + cpuCore3Temp +
                ", cpuCore4Temp=" + cpuCore4Temp +
                ", cpuTemp=" + cpuTemp +
                ", cpuCore1Load=" + cpuCore1Load +
                ", cpuCore2Load=" + cpuCore2Load +
                ", cpuCore3Load=" + cpuCore3Load +
                ", cpuCore4Load=" + cpuCore4Load +
                ", cpuLoad=" + cpuLoad +
                ", memoryLoad=" + memoryLoad +
                ", gpuName='" + gpuName + '\'' +
                ", gpuTemp=" + gpuTemp +
                ", gpuFan=" + gpuFan +
                ", gpuCoreLoad=" + gpuCoreLoad +
                ", gpuMemoryControllerLoad=" + gpuMemoryControllerLoad +
                ", gpuVideoEngineLoad=" + gpuVideoEngineLoad +
                ", gpuMemoryLoad=" + gpuMemoryLoad +
                '}';
    }
}
