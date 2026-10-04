package com.techcompare.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "price_usd")
    private Double priceUsd;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "ram_gb")
    private Integer ramGb;

    @Column(name = "ram_type")
    private String ramType;

    @Column(name = "storage_gb")
    private Integer storageGb;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "cpu_name")
    private String cpuName;

    @Column(name = "cpu_generation")
    private String cpuGeneration;

    @Column(name = "cpu_process_nm")
    private Integer cpuProcessNm;

    @Column(name = "cpu_max_clock_ghz")
    private Double cpuMaxClockGhz;

    @Column(name = "cpu_cores")
    private Integer cpuCores;

    @Column(name = "cpu_performance_cores")
    private Integer cpuPerformanceCores;

    @Column(name = "cpu_efficiency_cores")
    private Integer cpuEfficiencyCores;

    @Column(name = "gpu_name")
    private String gpuName;

    @Column(name = "gpu_architecture")
    private String gpuArchitecture;

    @Column(name = "gpu_clock")
    private Double gpuClock;

    @Column(name = "gpu_execution_units")
    private Integer gpuExecutionUnits;

    @Column(name = "cooling_type")
    private String coolingType;

    @Column(name = "cooling_surface_area_mm2")
    private Double coolingSurfaceAreaMm2;

    @Column(name = "display_resolution")
    private String displayResolution;

    @Column(name = "display_ppi")
    private Integer displayPpi;

    @Column(name = "display_refresh_rate")
    private Integer displayRefreshRate;

    @Column(name = "display_min_refresh_rate")
    private Integer displayMinRefreshRate;

    @Column(name = "touch_sampling_rate")
    private Integer touchSamplingRate;

    @Column(name = "display_ltpo")
    private Boolean displayLtpo;

    @Column(name = "battery_mah")
    private Integer batteryMah;

    @Column(name = "charging_w")
    private Integer chargingW;

    @Column(name = "wireless_charging_w")
    private Integer wirelessChargingW;

    @Column(name = "weight_g")
    private Double weightG;

    @Column(name = "main_sensor_size")
    private String mainSensorSize;

    @Column(name = "main_aperture")
    private Double mainAperture;

    @Column(name = "pixel_size_um")
    private Double pixelSizeUm;

    @Column(name = "pixel_binning")
    private String pixelBinning;

    @Column(name = "stabilization")
    private String stabilization;

    @Column(name = "optical_zoom")
    private String opticalZoom;

    @Column(name = "video_capabilities")
    private String videoCapabilities;

    @Column(name = "gaming_score")
    private Double gamingScore;

    @Column(name = "photography_score")
    private Double photographyScore;

    @Column(name = "general_score")
    private Double generalScore;


    // Laptop-specific specifications (nullable when not applicable or unknown)
    @Column(name = "gpu_tgp_w")
    private Double gpuTgpW;

    @Column(name = "vram_gb")
    private Integer vramGb;

    @Column(name = "vram_type")
    private String vramType;

    @Column(name = "gpu_professional_certification")
    private String gpuProfessionalCertification;

    @Column(name = "fan_count")
    private Integer fanCount;

    @Column(name = "max_sustained_tdp_w")
    private Double maxSustainedTdpW;

    @Column(name = "ram_speed_mhz")
    private Integer ramSpeedMhz;

    @Column(name = "ram_data_rate_mt_s")
    private Integer ramDataRateMtS;

    @Column(name = "ram_channel_mode")
    private String ramChannelMode;

    @Column(name = "max_ram_gb")
    private Integer maxRamGb;

    @Column(name = "dimm_slots")
    private Integer dimmSlots;

    @Column(name = "memory_bandwidth_gbs")
    private Double memoryBandwidthGbs;

    @Column(name = "display_response_time_ms")
    private Double displayResponseTimeMs;

    @Column(name = "display_dci_p3_percent")
    private Double displayDciP3Percent;

    @Column(name = "display_adobe_rgb_percent")
    private Double displayAdobeRgbPercent;

    @Column(name = "panel_technology")
    private String panelTechnology;

    @Column(name = "peak_brightness_nits")
    private Integer peakBrightnessNits;

    @Column(name = "display_color_depth_bits")
    private Integer displayColorDepthBits;

    @Column(name = "storage_pcie_gen")
    private Integer storagePcieGen;

    @Column(name = "ssd_slots")
    private Integer ssdSlots;

    @Column(name = "battery_wh")
    private Double batteryWh;

    @Column(name = "manufacturer_battery_life_hours")
    private Double manufacturerBatteryLifeHours;

    @Column(name = "usb_pd_charging_w")
    private Integer usbPdChargingW;

    @Column(name = "thickness_mm")
    private Double thicknessMm;

    @Column(name = "chassis_material")
    private String chassisMaterial;

    @Column(name = "keyboard_travel_mm")
    private Double keyboardTravelMm;

    @Column(name = "fingerprint_reader")
    private Boolean fingerprintReader;

    @Column(name = "ir_camera")
    private Boolean irCamera;

    @Column(name = "thunderbolt_version")
    private String thunderboltVersion;

    @Column(name = "hdmi_version")
    private String hdmiVersion;

    @Column(name = "usb_a_count")
    private Integer usbACount;

    @Column(name = "usb_c_count")
    private Integer usbCCount;

    @Column(name = "sd_card_reader")
    private Boolean sdCardReader;

    @Column(name = "ethernet_port")
    private Boolean ethernetPort;

    @Column(name = "wifi_standard")
    private String wifiStandard;

    @Column(name = "ram_bus_width_bits")
    private Integer ramBusWidthBits;

    @Column(name = "sdr_brightness_nits")
    private Integer sdrBrightnessNits;

    @Column(name = "hdr_peak_brightness_nits")
    private Integer hdrPeakBrightnessNits;

    @Column(name = "display_color_delta_e")
    private Double displayColorDeltaE;

    @Column(name = "independent_wifi_battery_hours")
    private Double independentWifiBatteryHours;

    @Column(name = "cpu_sustained_power_w")
    private Double cpuSustainedPowerW;

    @Column(name = "keyboard_backlit")
    private Boolean keyboardBacklit;

    @Column(name = "numeric_keypad")
    private Boolean numericKeypad;

    @Column(name = "battery_test_notes")
    private String batteryTestNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Double getGamingScore() {
        return gamingScore;
    }

    public void setGamingScore(Double gamingScore) {
        this.gamingScore = gamingScore;
    }

    public Double getPhotographyScore() {
        return photographyScore;
    }

    public void setPhotographyScore(Double photographyScore) {
        this.photographyScore = photographyScore;
    }

    public Double getGeneralScore() {
        return generalScore;
    }

    public void setGeneralScore(Double generalScore) {
        this.generalScore = generalScore;
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