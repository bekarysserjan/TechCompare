package com.techcompare.backend.controller;

import com.techcompare.backend.dto.DeviceDetailDTO;
import com.techcompare.backend.dto.DeviceSearchDTO;
import com.techcompare.backend.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "http://localhost:5173")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/search")
    public List<DeviceSearchDTO> searchDevices(
            @RequestParam String category,
            @RequestParam String q
    ) {
        return deviceService.searchDevices(category, q);
    }

    @GetMapping("/{id}")
    public DeviceDetailDTO getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id);
    }
}