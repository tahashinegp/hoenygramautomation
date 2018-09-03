package com.honeygram.CustomException;

public class DeviceNotfoundException extends Exception {
    public DeviceNotfoundException() {
    }

    public DeviceNotfoundException(String message) {
        super(message);
    }
}
