package com.lucaryholt.Service;

import com.lucaryholt.Model.SendData;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;

public class SystemInfoReader {

    public SendData getSystemInfo(){
        SendData sendData = new SendData();

        Components components = JSensors.get.components();

        Cpu cpu = components.cpus.get(0);
        Gpu gpu = components.gpus.get(0);

        sendData.setCpuName(cpu.name);
        sendData.setCpuCore1Temp(cpu.sensors.temperatures.get(0).value);
        sendData.setCpuCore2Temp(cpu.sensors.temperatures.get(1).value);
        sendData.setCpuCore3Temp(cpu.sensors.temperatures.get(2).value);
        sendData.setCpuCore4Temp(cpu.sensors.temperatures.get(3).value);
        sendData.setCpuTemp(cpu.sensors.temperatures.get(4).value);
        sendData.setCpuCore1Load(cpu.sensors.loads.get(0).value);
        sendData.setCpuCore2Load(cpu.sensors.loads.get(1).value);
        sendData.setCpuCore3Load(cpu.sensors.loads.get(2).value);
        sendData.setCpuCore4Load(cpu.sensors.loads.get(3).value);
        sendData.setCpuLoad(cpu.sensors.loads.get(4).value);

        sendData.setMemoryLoad(cpu.sensors.loads.get(5).value);

        sendData.setGpuName(gpu.name);
        sendData.setGpuTemp(gpu.sensors.temperatures.get(0).value);
        sendData.setGpuFan(gpu.sensors.fans.get(0).value);
        sendData.setGpuCoreLoad(gpu.sensors.loads.get(0).value);
        sendData.setGpuMemoryControllerLoad(gpu.sensors.loads.get(1).value);
        sendData.setGpuVideoEngineLoad(gpu.sensors.loads.get(2).value);
        sendData.setGpuMemoryLoad(gpu.sensors.loads.get(3).value);

        return sendData;
    }

}
