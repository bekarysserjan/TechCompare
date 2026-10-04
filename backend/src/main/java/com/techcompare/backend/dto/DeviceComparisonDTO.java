package com.techcompare.backend.dto;

public class DeviceComparisonDTO {

    private Long id;
    private String brand;
    private String modelName;
    private String category;
    private Integer releaseYear;
    private Double priceUsd;
    private String imageUrl;

    private Integer ramGb;
    private String ramType;
    private Integer storageGb;
    private String storageType;

    private String cpuName;
    private String cpuGeneration;
    private Integer cpuProcessNm;
    private Double cpuMaxClockGhz;
    private Integer cpuCores;
    private Integer cpuPerformanceCores;
    private Integer cpuEfficiencyCores;

    private String gpuName;
    private String gpuArchitecture;
    private Double gpuClock;
    private Integer gpuExecutionUnits;

    private String coolingType;
    private Double coolingSurfaceAreaMm2;

    private String displayResolution;
    private Integer displayPpi;
    private Integer displayRefreshRate;
    private Integer displayMinRefreshRate;
    private Integer touchSamplingRate;
    private Boolean displayLtpo;

    private Integer batteryMah;
    private Integer chargingW;
    private Integer wirelessChargingW;

    private Double weightG;

    private String mainSensorSize;
    private Double mainAperture;
    private Double pixelSizeUm;
    private String pixelBinning;
    private String stabilization;
    private String opticalZoom;
    private String videoCapabilities;


    // Laptop-specific specifications
    private Double gpuTgpW;
    private Integer vramGb;
    private String vramType;
    private String gpuProfessionalCertification;
    private Integer fanCount;
    private Double maxSustainedTdpW;
    private Integer ramSpeedMhz;
    private Integer ramDataRateMtS;
    private String ramChannelMode;
    private Integer maxRamGb;
    private Integer dimmSlots;
    private Double memoryBandwidthGbs;
    private Double displayResponseTimeMs;
    private Double displayDciP3Percent;
    private Double displayAdobeRgbPercent;
    private String panelTechnology;
    private Integer peakBrightnessNits;
    private Integer displayColorDepthBits;
    private Integer storagePcieGen;
    private Integer ssdSlots;
    private Double batteryWh;
    private Double manufacturerBatteryLifeHours;
    private Integer usbPdChargingW;
    private Double thicknessMm;
    private String chassisMaterial;
    private Double keyboardTravelMm;
    private Boolean fingerprintReader;
    private Boolean irCamera;
    private String thunderboltVersion;
    private String hdmiVersion;
    private Integer usbACount;
    private Integer usbCCount;
    private Boolean sdCardReader;
    private Boolean ethernetPort;
    private String wifiStandard;
    private Integer ramBusWidthBits;
    private Integer sdrBrightnessNits;
    private Integer hdrPeakBrightnessNits;
    private Double displayColorDeltaE;
    private Double independentWifiBatteryHours;
    private Double cpuSustainedPowerW;
    private Boolean keyboardBacklit;
    private Boolean numericKeypad;
    private String batteryTestNotes;

    public DeviceComparisonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getRamGb() {
        return ramGb;
    }

    public void setRamGb(Integer ramGb) {
        this.ramGb = ramGb;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public Integer getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(Integer storageGb) {
        this.storageGb = storageGb;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getCpuGeneration() {
        return cpuGeneration;
    }

    public void setCpuGeneration(String cpuGeneration) {
        this.cpuGeneration = cpuGeneration;
    }

    public Integer getCpuProcessNm() {
        return cpuProcessNm;
    }

    public void setCpuProcessNm(Integer cpuProcessNm) {
        this.cpuProcessNm = cpuProcessNm;
    }

    public Double getCpuMaxClockGhz() {
        return cpuMaxClockGhz;
    }

    public void setCpuMaxClockGhz(Double cpuMaxClockGhz) {
        this.cpuMaxClockGhz = cpuMaxClockGhz;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Integer getCpuPerformanceCores() {
        return cpuPerformanceCores;
    }

    public void setCpuPerformanceCores(Integer cpuPerformanceCores) {
        this.cpuPerformanceCores = cpuPerformanceCores;
    }

    public Integer getCpuEfficiencyCores() {
        return cpuEfficiencyCores;
    }

    public void setCpuEfficiencyCores(Integer cpuEfficiencyCores) {
        this.cpuEfficiencyCores = cpuEfficiencyCores;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public String getGpuArchitecture() {
        return gpuArchitecture;
    }

    public void setGpuArchitecture(String gpuArchitecture) {
        this.gpuArchitecture = gpuArchitecture;
    }

    public Double getGpuClock() {
        return gpuClock;
    }

    public void setGpuClock(Double gpuClock) {
        this.gpuClock = gpuClock;
    }

    public Integer getGpuExecutionUnits() {
        return gpuExecutionUnits;
    }

    public void setGpuExecutionUnits(Integer gpuExecutionUnits) {
        this.gpuExecutionUnits = gpuExecutionUnits;
    }

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    public Double getCoolingSurfaceAreaMm2() {
        return coolingSurfaceAreaMm2;
    }

    public void setCoolingSurfaceAreaMm2(Double coolingSurfaceAreaMm2) {
        this.coolingSurfaceAreaMm2 = coolingSurfaceAreaMm2;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public Integer getDisplayPpi() {
        return displayPpi;
    }

    public void setDisplayPpi(Integer displayPpi) {
        this.displayPpi = displayPpi;
    }

    public Integer getDisplayRefreshRate() {
        return displayRefreshRate;
    }

    public void setDisplayRefreshRate(Integer displayRefreshRate) {
        this.displayRefreshRate = displayRefreshRate;
    }

    public Integer getDisplayMinRefreshRate() {
        return displayMinRefreshRate;
    }

    public void setDisplayMinRefreshRate(Integer displayMinRefreshRate) {
        this.displayMinRefreshRate = displayMinRefreshRate;
    }

    public Integer getTouchSamplingRate() {
        return touchSamplingRate;
    }

    public void setTouchSamplingRate(Integer touchSamplingRate) {
        this.touchSamplingRate = touchSamplingRate;
    }

    public Boolean getDisplayLtpo() {
        return displayLtpo;
    }

    public void setDisplayLtpo(Boolean displayLtpo) {
        this.displayLtpo = displayLtpo;
    }

    public Integer getBatteryMah() {
        return batteryMah;
    }

    public void setBatteryMah(Integer batteryMah) {
        this.batteryMah = batteryMah;
    }

    public Integer getChargingW() {
        return chargingW;
    }

    public void setChargingW(Integer chargingW) {
        this.chargingW = chargingW;
    }

    public Integer getWirelessChargingW() {
        return wirelessChargingW;
    }

    public void setWirelessChargingW(Integer wirelessChargingW) {
        this.wirelessChargingW = wirelessChargingW;
    }

    public Double getWeightG() {
        return weightG;
    }

    public void setWeightG(Double weightG) {
        this.weightG = weightG;
    }

    public String getMainSensorSize() {
        return mainSensorSize;
    }

    public void setMainSensorSize(String mainSensorSize) {
        this.mainSensorSize = mainSensorSize;
    }

    public Double getMainAperture() {
        return mainAperture;
    }

    public void setMainAperture(Double mainAperture) {
        this.mainAperture = mainAperture;
    }

    public Double getPixelSizeUm() {
        return pixelSizeUm;
    }

    public void setPixelSizeUm(Double pixelSizeUm) {
        this.pixelSizeUm = pixelSizeUm;
    }

    public String getPixelBinning() {
        return pixelBinning;
    }

    public void setPixelBinning(String pixelBinning) {
        this.pixelBinning = pixelBinning;
    }

    public String getStabilization() {
        return stabilization;
    }

    public void setStabilization(String stabilization) {
        this.stabilization = stabilization;
    }

    public String getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(String opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public String getVideoCapabilities() {
        return videoCapabilities;
    }

    public void setVideoCapabilities(String videoCapabilities) {
        this.videoCapabilities = videoCapabilities;
    }
    public Double getGpuTgpW() {
        return gpuTgpW;
    }

    public void setGpuTgpW(Double gpuTgpW) {
        this.gpuTgpW = gpuTgpW;
    }

    public Integer getVramGb() {
        return vramGb;
    }

    public void setVramGb(Integer vramGb) {
        this.vramGb = vramGb;
    }

    public String getVramType() {
        return vramType;
    }

    public void setVramType(String vramType) {
        this.vramType = vramType;
    }

    public String getGpuProfessionalCertification() {
        return gpuProfessionalCertification;
    }

    public void setGpuProfessionalCertification(String gpuProfessionalCertification) {
        this.gpuProfessionalCertification = gpuProfessionalCertification;
    }

    public Integer getFanCount() {
        return fanCount;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public Double getMaxSustainedTdpW() {
        return maxSustainedTdpW;
    }

    public void setMaxSustainedTdpW(Double maxSustainedTdpW) {
        this.maxSustainedTdpW = maxSustainedTdpW;
    }

    public Integer getRamSpeedMhz() {
        return ramSpeedMhz;
    }

    public void setRamSpeedMhz(Integer ramSpeedMhz) {
        this.ramSpeedMhz = ramSpeedMhz;
    }

    public Integer getRamDataRateMtS() {
        return ramDataRateMtS;
    }

    public void setRamDataRateMtS(Integer ramDataRateMtS) {
        this.ramDataRateMtS = ramDataRateMtS;
    }

    public String getRamChannelMode() {
        return ramChannelMode;
    }

    public void setRamChannelMode(String ramChannelMode) {
        this.ramChannelMode = ramChannelMode;
    }

    public Integer getMaxRamGb() {
        return maxRamGb;
    }

    public void setMaxRamGb(Integer maxRamGb) {
        this.maxRamGb = maxRamGb;
    }

    public Integer getDimmSlots() {
        return dimmSlots;
    }

    public void setDimmSlots(Integer dimmSlots) {
        this.dimmSlots = dimmSlots;
    }

    public Double getMemoryBandwidthGbs() {
        return memoryBandwidthGbs;
    }

    public void setMemoryBandwidthGbs(Double memoryBandwidthGbs) {
        this.memoryBandwidthGbs = memoryBandwidthGbs;
    }

    public Double getDisplayResponseTimeMs() {
        return displayResponseTimeMs;
    }

    public void setDisplayResponseTimeMs(Double displayResponseTimeMs) {
        this.displayResponseTimeMs = displayResponseTimeMs;
    }

    public Double getDisplayDciP3Percent() {
        return displayDciP3Percent;
    }

    public void setDisplayDciP3Percent(Double displayDciP3Percent) {
        this.displayDciP3Percent = displayDciP3Percent;
    }

    public Double getDisplayAdobeRgbPercent() {
        return displayAdobeRgbPercent;
    }

    public void setDisplayAdobeRgbPercent(Double displayAdobeRgbPercent) {
        this.displayAdobeRgbPercent = displayAdobeRgbPercent;
    }

    public String getPanelTechnology() {
        return panelTechnology;
    }

    public void setPanelTechnology(String panelTechnology) {
        this.panelTechnology = panelTechnology;
    }

    public Integer getPeakBrightnessNits() {
        return peakBrightnessNits;
    }

    public void setPeakBrightnessNits(Integer peakBrightnessNits) {
        this.peakBrightnessNits = peakBrightnessNits;
    }

    public Integer getDisplayColorDepthBits() {
        return displayColorDepthBits;
    }

    public void setDisplayColorDepthBits(Integer displayColorDepthBits) {
        this.displayColorDepthBits = displayColorDepthBits;
    }

    public Integer getStoragePcieGen() {
        return storagePcieGen;
    }

    public void setStoragePcieGen(Integer storagePcieGen) {
        this.storagePcieGen = storagePcieGen;
    }

    public Integer getSsdSlots() {
        return ssdSlots;
    }

    public void setSsdSlots(Integer ssdSlots) {
        this.ssdSlots = ssdSlots;
    }

    public Double getBatteryWh() {
        return batteryWh;
    }

    public void setBatteryWh(Double batteryWh) {
        this.batteryWh = batteryWh;
    }

    public Double getManufacturerBatteryLifeHours() {
        return manufacturerBatteryLifeHours;
    }

    public void setManufacturerBatteryLifeHours(Double manufacturerBatteryLifeHours) {
        this.manufacturerBatteryLifeHours = manufacturerBatteryLifeHours;
    }

    public Integer getUsbPdChargingW() {
        return usbPdChargingW;
    }

    public void setUsbPdChargingW(Integer usbPdChargingW) {
        this.usbPdChargingW = usbPdChargingW;
    }

    public Double getThicknessMm() {
        return thicknessMm;
    }

    public void setThicknessMm(Double thicknessMm) {
        this.thicknessMm = thicknessMm;
    }

    public String getChassisMaterial() {
        return chassisMaterial;
    }

    public void setChassisMaterial(String chassisMaterial) {
        this.chassisMaterial = chassisMaterial;
    }

    public Double getKeyboardTravelMm() {
        return keyboardTravelMm;
    }

    public void setKeyboardTravelMm(Double keyboardTravelMm) {
        this.keyboardTravelMm = keyboardTravelMm;
    }

    public Boolean getFingerprintReader() {
        return fingerprintReader;
    }

    public void setFingerprintReader(Boolean fingerprintReader) {
        this.fingerprintReader = fingerprintReader;
    }

    public Boolean getIrCamera() {
        return irCamera;
    }

    public void setIrCamera(Boolean irCamera) {
        this.irCamera = irCamera;
    }

    public String getThunderboltVersion() {
        return thunderboltVersion;
    }

    public void setThunderboltVersion(String thunderboltVersion) {
        this.thunderboltVersion = thunderboltVersion;
    }

    public String getHdmiVersion() {
        return hdmiVersion;
    }

    public void setHdmiVersion(String hdmiVersion) {
        this.hdmiVersion = hdmiVersion;
    }

    public Integer getUsbACount() {
        return usbACount;
    }

    public void setUsbACount(Integer usbACount) {
        this.usbACount = usbACount;
    }

    public Integer getUsbCCount() {
        return usbCCount;
    }

    public void setUsbCCount(Integer usbCCount) {
        this.usbCCount = usbCCount;
    }

    public Boolean getSdCardReader() {
        return sdCardReader;
    }

    public void setSdCardReader(Boolean sdCardReader) {
        this.sdCardReader = sdCardReader;
    }

    public Boolean getEthernetPort() {
        return ethernetPort;
    }

    public void setEthernetPort(Boolean ethernetPort) {
        this.ethernetPort = ethernetPort;
    }

    public String getWifiStandard() {
        return wifiStandard;
    }

    public void setWifiStandard(String wifiStandard) {
        this.wifiStandard = wifiStandard;
    }

    public Integer getRamBusWidthBits() {
        return ramBusWidthBits;
    }

    public void setRamBusWidthBits(Integer ramBusWidthBits) {
        this.ramBusWidthBits = ramBusWidthBits;
    }

    public Integer getSdrBrightnessNits() {
        return sdrBrightnessNits;
    }

    public void setSdrBrightnessNits(Integer sdrBrightnessNits) {
        this.sdrBrightnessNits = sdrBrightnessNits;
    }

    public Integer getHdrPeakBrightnessNits() {
        return hdrPeakBrightnessNits;
    }

    public void setHdrPeakBrightnessNits(Integer hdrPeakBrightnessNits) {
        this.hdrPeakBrightnessNits = hdrPeakBrightnessNits;
    }

    public Double getDisplayColorDeltaE() {
        return displayColorDeltaE;
    }

    public void setDisplayColorDeltaE(Double displayColorDeltaE) {
        this.displayColorDeltaE = displayColorDeltaE;
    }

    public Double getIndependentWifiBatteryHours() {
        return independentWifiBatteryHours;
    }

    public void setIndependentWifiBatteryHours(Double independentWifiBatteryHours) {
        this.independentWifiBatteryHours = independentWifiBatteryHours;
    }

    public Double getCpuSustainedPowerW() {
        return cpuSustainedPowerW;
    }

    public void setCpuSustainedPowerW(Double cpuSustainedPowerW) {
        this.cpuSustainedPowerW = cpuSustainedPowerW;
    }

    public Boolean getKeyboardBacklit() {
        return keyboardBacklit;
    }

    public void setKeyboardBacklit(Boolean keyboardBacklit) {
        this.keyboardBacklit = keyboardBacklit;
    }

    public Boolean getNumericKeypad() {
        return numericKeypad;
    }

    public void setNumericKeypad(Boolean numericKeypad) {
        this.numericKeypad = numericKeypad;
    }

    public String getBatteryTestNotes() {
        return batteryTestNotes;
    }

    public void setBatteryTestNotes(String batteryTestNotes) {
        this.batteryTestNotes = batteryTestNotes;
    }

}