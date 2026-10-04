package com.techcompare.backend.service;

import com.techcompare.backend.dto.DeviceComparisonDTO;
import com.techcompare.backend.model.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceComparisonMapper {

    public DeviceComparisonDTO toDTO(Device device) {

        DeviceComparisonDTO dto = new DeviceComparisonDTO();

        dto.setId(device.getId());
        dto.setBrand(device.getBrand());
        dto.setModelName(device.getModelName());
        dto.setCategory(device.getCategory());
        dto.setReleaseYear(device.getReleaseYear());
        dto.setPriceUsd(device.getPriceUsd());
        dto.setImageUrl(device.getImageUrl());

        dto.setRamGb(device.getRamGb());
        dto.setRamType(device.getRamType());
        dto.setStorageGb(device.getStorageGb());
        dto.setStorageType(device.getStorageType());

        dto.setCpuName(device.getCpuName());
        dto.setCpuGeneration(device.getCpuGeneration());
        dto.setCpuProcessNm(device.getCpuProcessNm());
        dto.setCpuMaxClockGhz(device.getCpuMaxClockGhz());
        dto.setCpuCores(device.getCpuCores());
        dto.setCpuPerformanceCores(device.getCpuPerformanceCores());
        dto.setCpuEfficiencyCores(device.getCpuEfficiencyCores());

        dto.setGpuName(device.getGpuName());
        dto.setGpuArchitecture(device.getGpuArchitecture());
        dto.setGpuClock(device.getGpuClock());
        dto.setGpuExecutionUnits(device.getGpuExecutionUnits());

        dto.setCoolingType(device.getCoolingType());
        dto.setCoolingSurfaceAreaMm2(device.getCoolingSurfaceAreaMm2());

        dto.setDisplayResolution(device.getDisplayResolution());
        dto.setDisplayPpi(device.getDisplayPpi());
        dto.setDisplayRefreshRate(device.getDisplayRefreshRate());
        dto.setDisplayMinRefreshRate(device.getDisplayMinRefreshRate());
        dto.setTouchSamplingRate(device.getTouchSamplingRate());
        dto.setDisplayLtpo(device.getDisplayLtpo());

        dto.setBatteryMah(device.getBatteryMah());
        dto.setChargingW(device.getChargingW());
        dto.setWirelessChargingW(device.getWirelessChargingW());

        dto.setWeightG(device.getWeightG());

        dto.setMainSensorSize(device.getMainSensorSize());
        dto.setMainAperture(device.getMainAperture());
        dto.setPixelSizeUm(device.getPixelSizeUm());
        dto.setPixelBinning(device.getPixelBinning());
        dto.setStabilization(device.getStabilization());
        dto.setOpticalZoom(device.getOpticalZoom());
        dto.setVideoCapabilities(device.getVideoCapabilities());


        // Laptop-specific specifications
        dto.setGpuTgpW(device.getGpuTgpW());
        dto.setVramGb(device.getVramGb());
        dto.setVramType(device.getVramType());
        dto.setGpuProfessionalCertification(device.getGpuProfessionalCertification());
        dto.setFanCount(device.getFanCount());
        dto.setMaxSustainedTdpW(device.getMaxSustainedTdpW());
        dto.setRamSpeedMhz(device.getRamSpeedMhz());
        dto.setRamDataRateMtS(device.getRamDataRateMtS());
        dto.setRamChannelMode(device.getRamChannelMode());
        dto.setMaxRamGb(device.getMaxRamGb());
        dto.setDimmSlots(device.getDimmSlots());
        dto.setMemoryBandwidthGbs(device.getMemoryBandwidthGbs());
        dto.setDisplayResponseTimeMs(device.getDisplayResponseTimeMs());
        dto.setDisplayDciP3Percent(device.getDisplayDciP3Percent());
        dto.setDisplayAdobeRgbPercent(device.getDisplayAdobeRgbPercent());
        dto.setPanelTechnology(device.getPanelTechnology());
        dto.setPeakBrightnessNits(device.getPeakBrightnessNits());
        dto.setDisplayColorDepthBits(device.getDisplayColorDepthBits());
        dto.setStoragePcieGen(device.getStoragePcieGen());
        dto.setSsdSlots(device.getSsdSlots());
        dto.setBatteryWh(device.getBatteryWh());
        dto.setManufacturerBatteryLifeHours(device.getManufacturerBatteryLifeHours());
        dto.setUsbPdChargingW(device.getUsbPdChargingW());
        dto.setThicknessMm(device.getThicknessMm());
        dto.setChassisMaterial(device.getChassisMaterial());
        dto.setKeyboardTravelMm(device.getKeyboardTravelMm());
        dto.setFingerprintReader(device.getFingerprintReader());
        dto.setIrCamera(device.getIrCamera());
        dto.setThunderboltVersion(device.getThunderboltVersion());
        dto.setHdmiVersion(device.getHdmiVersion());
        dto.setUsbACount(device.getUsbACount());
        dto.setUsbCCount(device.getUsbCCount());
        dto.setSdCardReader(device.getSdCardReader());
        dto.setEthernetPort(device.getEthernetPort());
        dto.setWifiStandard(device.getWifiStandard());
        dto.setRamBusWidthBits(device.getRamBusWidthBits());
        dto.setSdrBrightnessNits(device.getSdrBrightnessNits());
        dto.setHdrPeakBrightnessNits(device.getHdrPeakBrightnessNits());
        dto.setDisplayColorDeltaE(device.getDisplayColorDeltaE());
        dto.setIndependentWifiBatteryHours(device.getIndependentWifiBatteryHours());
        dto.setCpuSustainedPowerW(device.getCpuSustainedPowerW());
        dto.setKeyboardBacklit(device.getKeyboardBacklit());
        dto.setNumericKeypad(device.getNumericKeypad());
        dto.setBatteryTestNotes(device.getBatteryTestNotes());

        return dto;
    }
}