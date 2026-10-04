package com.techcompare.backend.service;

import com.techcompare.backend.dto.DeviceSearchDTO;
import com.techcompare.backend.model.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceSearchMapper {

    public DeviceSearchDTO toDTO(Device device) {

        return new DeviceSearchDTO(
                device.getId(),
                device.getBrand(),
                device.getModelName(),
                device.getCategory(),
                device.getReleaseYear(),
                device.getPriceUsd(),
                device.getImageUrl(),
                device.getRamGb(),
                device.getStorageGb()
        );
    }
}