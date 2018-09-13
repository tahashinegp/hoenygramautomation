package com.honeygramtest.configuration;

public class Device {
    String deviceID;
    String deviceName;
    String osInfo;
    String modelName;

    public Device(){

    }
    public Device(String deviceID, String deviceName, String osInfo, String modelName) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.osInfo = osInfo;
        this.modelName = modelName;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(String osInfo) {
        this.osInfo = osInfo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
