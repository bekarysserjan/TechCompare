package com.techcompare.backend.service;

import com.techcompare.backend.dto.DeviceDetailDTO;
import com.techcompare.backend.model.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceDetailMapper {

    public DeviceDetailDTO toDTO(Device device) {
        DeviceDetailDTO dto = new DeviceDetailDTO(
                device.getId(), device.getBrand(), device.getModelName(), device.getCategory(),
                device.getReleaseYear(), device.getPriceUsd(), device.getImageUrl(),
                device.getRamGb(), device.getRamType(), device.getStorageGb(), device.getStorageType(),
                device.getCpuName(), device.getCpuGeneration(), device.getCpuProcessNm(),
                device.getCpuMaxClockGhz(), device.getCpuCores(), device.getCpuPerformanceCores(),
                device.getCpuEfficiencyCores(), device.getGpuName(), device.getGpuArchitecture(),
                device.getGpuClock(), device.getGpuExecutionUnits(), device.getCoolingType(),
                device.getCoolingSurfaceAreaMm2(), device.getDisplayResolution(), device.getDisplayPpi(),
                device.getDisplayRefreshRate(), device.getDisplayMinRefreshRate(), device.getTouchSamplingRate(),
                device.getDisplayLtpo(), device.getBatteryMah(), device.getChargingW(),
                device.getWirelessChargingW(), device.getWeightG(), device.getMainSensorSize(),
                device.getMainAperture(), device.getPixelSizeUm(), device.getPixelBinning(),
                device.getStabilization(), device.getOpticalZoom(), device.getVideoCapabilities()
        );
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
