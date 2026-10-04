package com.techcompare.backend.exception;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException(Long id) {
        super("Device with id " + id + " not found");
    }
}