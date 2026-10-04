package com.techcompare.backend.service;

import com.techcompare.backend.model.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** Lightweight, fixed-scale laptop scoring for the semester project. */
@Service
public class LaptopScoringService {

    public double calculateGamingScore(Device d) {
        return weightedAverage(
                criterion(35, avg(scoreGpuClass(d.getGpuName()), range(d.getGpuTgpW(), 60, 100, 175), range(d.getVramGb(), 4, 8, 16))),
                criterion(20, avg(range(d.getCpuMaxClockGhz(), 2.0, 3.5, 5.0), range(d.getCpuCores(), 4, 8, 24))),
                criterion(15, avg(range(d.getMaxSustainedTdpW(), 35, 80, 175), range(d.getCoolingSurfaceAreaMm2(), 1000, 2500, 4500), range(d.getFanCount(), 1, 2, 3))),
                criterion(12, avg(range(d.getDisplayRefreshRate(), 60, 120, 240), inverse(d.getDisplayResponseTimeMs(), 20, 5, 1))),
                criterion(10, avg(range(d.getRamGb(), 8, 16, 64), range(ramRate(d), 3200, 5600, 8000))),
                criterion(8, avg(range(d.getStorageGb(), 256, 1024, 4096), range(d.getSsdSlots(), 1, 2, 3), range(d.getStoragePcieGen(), 3, 4, 5)))
        );
    }

    public double calculateCreatorScore(Device d) {
        return weightedAverage(
                criterion(25, avg(scoreGpuClass(d.getGpuName()), range(d.getVramGb(), 4, 8, 16), certificationScore(d.getGpuProfessionalCertification()))),
                criterion(20, avg(range(d.getCpuCores(), 4, 8, 24), range(d.getCpuMaxClockGhz(), 2.0, 3.5, 5.0))),
                criterion(20, avg(range(d.getDisplayDciP3Percent(), 60, 90, 100), range(d.getDisplayAdobeRgbPercent(), 60, 90, 100), inverse(d.getDisplayColorDeltaE(), 6, 3, 1), range(d.getDisplayColorDepthBits(), 6, 8, 10))),
                criterion(15, avg(range(d.getRamGb(), 8, 32, 128), range(d.getMaxRamGb(), 16, 64, 192), range(d.getMemoryBandwidthGbs(), 25, 100, 400), range(d.getDimmSlots(), 0, 2, 4))),
                criterion(10, avg(range(d.getCpuSustainedPowerW(), 10, 45, 120), range(d.getMaxSustainedTdpW(), 20, 80, 175), range(d.getCoolingSurfaceAreaMm2(), 1000, 2500, 4500))),
                criterion(10, avg(connectivity(d)))
        );
    }

    public double calculateDailyProductivityScore(Device d) {
        return weightedAverage(
                criterion(25, range(d.getIndependentWifiBatteryHours(), 4, 10, 18)),
                criterion(20, avg(inverse(d.getWeightG(), 3000, 2000, 1100), inverse(d.getThicknessMm(), 30, 20, 12))),
                criterion(15, avg(range(d.getKeyboardTravelMm(), 0.8, 1.5, 2.0), boolScore(d.getKeyboardBacklit()), boolScore(d.getNumericKeypad()))),
                criterion(15, avg(range(d.getSdrBrightnessNits(), 250, 400, 600), range(d.getPeakBrightnessNits(), 300, 600, 1000), range(d.getDisplayPpi(), 140, 200, 280), range(d.getDisplayDciP3Percent(), 60, 90, 100))),
                criterion(15, avg(range(d.getCpuCores(), 4, 8, 16), range(d.getCpuMaxClockGhz(), 2.0, 3.5, 5.0), range(d.getRamGb(), 8, 16, 64))),
                criterion(10, avg(connectivity(d)))
        );
    }

    private double[] connectivity(Device d) {
        return new double[] {
                range(d.getUsbACount(), 0, 2, 4), range(d.getUsbCCount(), 1, 2, 4),
                boolScore(d.getSdCardReader()), boolScore(d.getEthernetPort()),
                range(parseVersion(d.getThunderboltVersion()), 0, 3, 5), range(parseVersion(d.getWifiStandard()), 4, 6, 7),
                range(parseVersion(d.getHdmiVersion()), 1, 2, 2.1)
        };
    }

    private Integer ramRate(Device d) {
        return d.getRamDataRateMtS() != null ? d.getRamDataRateMtS() : d.getRamSpeedMhz();
    }

    private double scoreGpuClass(String value) {
        if (value == null || value.isBlank()) return Double.NaN;
        String v = value.toLowerCase();
        if (v.contains("highend") || v.contains("high_end") || v.contains("workstation")) return 100;
        if (v.contains("midrange") || v.contains("mid_range")) return 75;
        if (v.contains("entry") || v.contains("lowend") || v.contains("low_end")) return 50;
        if (v.contains("integrated_performance") || v.contains("integrated performance")) return 65;
        if (v.contains("integrated")) return 45;
        return Double.NaN;
    }

    private double certificationScore(String value) {
        if (value == null || value.isBlank()) return Double.NaN;
        String normalized = value.trim().toLowerCase();
        if (normalized.equals("true") || normalized.equals("yes") || normalized.equals("certified")) return 100;
        if (normalized.equals("false") || normalized.equals("no") || normalized.equals("none")) return 60;
        return 75;
    }

    private double boolScore(Boolean value) {
        return value == null ? Double.NaN : (value ? 100 : 60);
    }

    private double parseVersion(String value) {
        if (value == null || value.isBlank()) return Double.NaN;
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(\\d+(?:\\.\\d+)?)").matcher(value);
        if (!matcher.find()) return Double.NaN;
        try { return Double.parseDouble(matcher.group(1)); } catch (NumberFormatException ex) { return Double.NaN; }
    }

    private double range(Number value, double low, double good, double excellent) {
        if (value == null) return Double.NaN;
        double v = value.doubleValue();
        if (!Double.isFinite(v)) return Double.NaN;
        if (v <= low) return 45;
        if (v <= good) return 45 + 40 * (v - low) / (good - low);
        if (v <= excellent) return 85 + 15 * (v - good) / (excellent - good);
        return 100;
    }

    private double inverse(Number value, double worst, double good, double excellent) {
        if (value == null) return Double.NaN;
        double v = value.doubleValue();
        if (!Double.isFinite(v)) return Double.NaN;
        if (v >= worst) return 45;
        if (v >= good) return 45 + 40 * (worst - v) / (worst - good);
        if (v >= excellent) return 85 + 15 * (good - v) / (good - excellent);
        return 100;
    }

    private double avg(double... scores) {
        double total = 0; int count = 0;
        for (double score : scores) if (Double.isFinite(score)) { total += score; count++; }
        return count == 0 ? Double.NaN : total / count;
    }

    private Criterion criterion(double weight, double score) { return new Criterion(weight, score); }

    private double weightedAverage(Criterion... criteria) {
        double weighted = 0; double usedWeight = 0;
        for (Criterion c : criteria) {
            if (Double.isFinite(c.score)) { weighted += c.score * c.weight; usedWeight += c.weight; }
        }
        return usedWeight == 0 ? 0 : round(weighted / usedWeight);
    }

    private double round(double score) { return Math.round(Math.max(0, Math.min(100, score)) * 10.0) / 10.0; }

    private static final class Criterion {
        private final double weight; private final double score;
        private Criterion(double weight, double score) { this.weight = weight; this.score = score; }
    }
}
