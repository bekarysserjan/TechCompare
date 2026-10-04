package com.techcompare.backend.service;

import com.techcompare.backend.dto.DeviceDetailDTO;
import com.techcompare.backend.dto.DeviceSearchDTO;
import com.techcompare.backend.exception.DeviceNotFoundException;
import com.techcompare.backend.model.Device;
import com.techcompare.backend.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceSearchMapper deviceSearchMapper;
    private final DeviceDetailMapper deviceDetailMapper;

    public DeviceService(
            DeviceRepository deviceRepository,
            DeviceSearchMapper deviceSearchMapper,
            DeviceDetailMapper deviceDetailMapper) {

        this.deviceRepository = deviceRepository;
        this.deviceSearchMapper = deviceSearchMapper;
        this.deviceDetailMapper = deviceDetailMapper;
    }

    public List<DeviceSearchDTO> searchDevices(
            String category,
            String query) {

        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException(
                    "Category is required"
            );
        }

        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException(
                    "Search query is required"
            );
        }

        List<Device> devices = deviceRepository.searchDevices(
                category.trim(),
                query.trim()
        );

        return devices.stream()
                .map(deviceSearchMapper::toDTO)
                .toList();
    }

    public DeviceDetailDTO getDevice(Long id) {

        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));

        return deviceDetailMapper.toDTO(device);
    }
}