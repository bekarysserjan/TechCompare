package com.techcompare.backend.service;

import com.techcompare.backend.model.Device;
import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    // ============================================================
    // GAMING
    // ============================================================

    /*
     * Gaming importance:
     *
     * GPU       40%
     * CPU       25%
     * Cooling   15%
     * RAM       10%
     * Display   10%
     */

    public double calculateGamingScore(Device device) {

        double gpu = calculateGpuScore(device);
        double cpu = calculateCpuScore(device);
        double cooling = calculateCoolingScore(device);
        double ram = calculateRamScore(device);
        double display = calculateGamingDisplayScore(device);

        double score =
                gpu * 0.40
                        + cpu * 0.25
                        + cooling * 0.15
                        + ram * 0.10
                        + display * 0.10;

        return roundScore(score);
    }


    // ============================================================
    // PHOTOGRAPHY
    // ============================================================

    /*
     * Photography importance:
     *
     * Sensor          25%
     * Optical zoom    20%
     * Video           20%
     * Stabilization   15%
     * Aperture        10%
     * Pixel size      10%
     */

    public double calculatePhotographyScore(Device device) {

        double sensor = calculateSensorScore(device);
        double zoom = calculateZoomScore(device);
        double video = calculateVideoScore(device);
        double stabilization = calculateStabilizationScore(device);
        double aperture = calculateApertureScore(device);
        double pixelSize = calculatePixelSizeScore(device);

        double score =
                sensor * 0.25
                        + zoom * 0.20
                        + video * 0.20
                        + stabilization * 0.15
                        + aperture * 0.10
                        + pixelSize * 0.10;

        return roundScore(score);
    }


    // ============================================================
    // DAILY USE
    // ============================================================

    /*
     * Daily Use importance:
     *
     * Battery     25%
     * Display     20%
     * Storage     15%
     * Weight      15%
     * Charging    15%
     * PPI         10%
     */

    public double calculateDailyUseScore(Device device) {

        double battery = calculateBatteryScore(device);
        double display = calculateDailyDisplayScore(device);
        double storage = calculateStorageScore(device);
        double weight = calculateWeightScore(device);
        double charging = calculateChargingScore(device);
        double ppi = calculatePpiScore(device);

        double score =
                battery * 0.25
                        + display * 0.20
                        + storage * 0.15
                        + weight * 0.15
                        + charging * 0.15
                        + ppi * 0.10;

        return roundScore(score);
    }


    // ============================================================
    // GAMING FEATURES
    // ============================================================

    private double calculateGpuScore(Device device) {

        double score = 0;
        int factors = 0;

        if (device.getGpuExecutionUnits() != null) {

            /*
             * Modern flagship range:
             * ~6 units = decent
             * ~10 units = very good
             * ~14+ units = excellent
             */

            score += scoreByRange(
                    device.getGpuExecutionUnits(),
                    6,
                    10,
                    14
            );

            factors++;
        }

        if (device.getGpuClock() != null) {

            /*
             * Clock is only a secondary GPU indicator.
             * We deliberately don't let it dominate the score.
             */

            score += scoreByRange(
                    device.getGpuClock(),
                    800,
                    1100,
                    1500
            );

            factors++;
        }

        if (factors == 0) {
            return 0;
        }

        return score / factors;
    }


    private double calculateCpuScore(Device device) {

        double score = 0;
        int factors = 0;

        if (device.getCpuCores() != null) {

            score += scoreByRange(
                    device.getCpuCores(),
                    6,
                    8,
                    10
            );

            factors++;
        }

        if (device.getCpuMaxClockGhz() != null) {

            score += scoreByRange(
                    device.getCpuMaxClockGhz(),
                    3.2,
                    4.0,
                    4.5
            );

            factors++;
        }

        if (factors == 0) {
            return 0;
        }

        return score / factors;
    }


    private double calculateCoolingScore(Device device) {

        if (device.getCoolingSurfaceAreaMm2() == null) {
            return 0;
        }

        return scoreByRange(
                device.getCoolingSurfaceAreaMm2(),
                1500,
                2500,
                3500
        );
    }


    private double calculateRamScore(Device device) {

        if (device.getRamGb() == null) {
            return 0;
        }

        return scoreByRange(
                device.getRamGb(),
                8,
                12,
                16
        );
    }


    private double calculateGamingDisplayScore(Device device) {

        if (device.getDisplayRefreshRate() == null) {
            return 0;
        }

        return scoreByRange(
                device.getDisplayRefreshRate(),
                90,
                120,
                144
        );
    }


    // ============================================================
    // PHOTOGRAPHY FEATURES
    // ============================================================

    private double calculateSensorScore(Device device) {

        if (device.getMainSensorSize() == null) {
            return 0;
        }

        /*
         * Sensor sizes are stored as strings such as:
         * 1/1.3"
         * 1/1.28"
         *
         * Parsing every possible camera sensor format reliably
         * would require a more sophisticated camera database.
         *
         * For the current prototype, recognized flagship-sized
         * sensors receive a high score.
         */

        String sensor =
                device.getMainSensorSize().toLowerCase();

        if (sensor.contains("1/1.0")
                || sensor.contains("1/1.1")
                || sensor.contains("1/1.2")) {

            return 100;
        }

        if (sensor.contains("1/1.28")
                || sensor.contains("1/1.3")) {

            return 90;
        }

        if (sensor.contains("1/1.4")
                || sensor.contains("1/1.5")) {

            return 80;
        }

        if (sensor.contains("1/1.6")
                || sensor.contains("1/1.7")) {

            return 70;
        }

        return 60;
    }


    private double calculateZoomScore(Device device) {

        if (device.getOpticalZoom() == null) {
            return 0;
        }

        String[] parts =
                device.getOpticalZoom().split(",");

        double highestZoom = 0;

        for (String part : parts) {

            String cleaned = part
                    .trim()
                    .replace("x", "");

            try {

                double zoom =
                        Double.parseDouble(cleaned);

                if (zoom > highestZoom) {
                    highestZoom = zoom;
                }

            } catch (NumberFormatException ignored) {
                // Ignore values that cannot be parsed.
            }
        }

        /*
         * 2x  → decent
         * 5x  → very good
         * 10x → excellent
         */

        return scoreByRange(
                highestZoom,
                2,
                5,
                10
        );
    }


    private double calculateVideoScore(Device device) {

        if (device.getVideoCapabilities() == null) {
            return 0;
        }

        String video =
                device.getVideoCapabilities()
                        .toLowerCase();

        double score = 50;

        if (video.contains("4k")) {
            score += 15;
        }

        if (video.contains("60fps")) {
            score += 10;
        }

        if (video.contains("120fps")) {
            score += 10;
        }

        if (video.contains("8k")) {
            score += 10;
        }

        if (video.contains("10-bit")) {
            score += 5;
        }

        return Math.min(score, 100);
    }


    private double calculateStabilizationScore(Device device) {

        if (device.getStabilization() == null) {
            return 0;
        }

        String stabilization =
                device.getStabilization()
                        .toLowerCase();

        if (stabilization.contains("sensor-shift")) {
            return 100;
        }

        if (stabilization.contains("ois")) {
            return 90;
        }

        if (stabilization.contains("eis")) {
            return 75;
        }

        return 60;
    }


    private double calculateApertureScore(Device device) {

        if (device.getMainAperture() == null) {
            return 0;
        }

        /*
         * Lower f-number = larger aperture.
         *
         * f/1.4 → excellent
         * f/1.7 → very good
         * f/2.0 → good
         * f/2.4 → acceptable
         */

        return scoreInverseByRange(
                device.getMainAperture(),
                2.4,
                1.7,
                1.4
        );
    }


    private double calculatePixelSizeScore(Device device) {

        if (device.getPixelSizeUm() == null) {
            return 0;
        }

        return scoreByRange(
                device.getPixelSizeUm(),
                0.8,
                1.2,
                1.5
        );
    }


    // ============================================================
    // DAILY USE FEATURES
    // ============================================================

    private double calculateBatteryScore(Device device) {

        if (device.getBatteryMah() == null) {
            return 0;
        }

        /*
         * Practical flagship range.
         *
         * ~3500 → acceptable
         * ~4000 → good
         * ~4500 → very good
         * ~5000 → excellent
         * 5500+ → exceptional
         */

        return scoreByRange(
                device.getBatteryMah(),
                3500,
                4500,
                5500
        );
    }


    private double calculateChargingScore(Device device) {

        if (device.getChargingW() == null) {
            return 0;
        }

        /*
         * Charging:
         *
         * 20 W  → acceptable
         * 50 W  → good
         * 80 W+ → excellent
         */

        return scoreByRange(
                device.getChargingW(),
                20,
                50,
                100
        );
    }


    private double calculateDailyDisplayScore(Device device) {

        double refreshScore = 0;
        double ltpoBonus = 0;

        if (device.getDisplayRefreshRate() != null) {

            refreshScore = scoreByRange(
                    device.getDisplayRefreshRate(),
                    90,
                    120,
                    144
            );
        }

        if (Boolean.TRUE.equals(device.getDisplayLtpo())) {
            ltpoBonus = 5;
        }

        return Math.min(
                refreshScore + ltpoBonus,
                100
        );
    }


    private double calculateStorageScore(Device device) {

        if (device.getStorageGb() == null) {
            return 0;
        }

        /*
         * 128 GB → acceptable
         * 256 GB → good
         * 512 GB → very good
         * 1 TB   → excellent
         */

        return scoreByRange(
                device.getStorageGb(),
                128,
                512,
                1024
        );
    }


    private double calculateWeightScore(Device device) {

        if (device.getWeightG() == null) {
            return 0;
        }

        /*
         * Lighter is generally preferable for everyday use.
         *
         * ~170 g → excellent
         * ~200 g → good
         * ~220 g → acceptable
         * 240+ g → low
         */

        return scoreInverseByRange(
                device.getWeightG(),
                240,
                200,
                170
        );
    }


    private double calculatePpiScore(Device device) {

        if (device.getDisplayPpi() == null) {
            return 0;
        }

        /*
         * Above ~450 PPI there is diminishing practical benefit.
         */

        return scoreByRange(
                device.getDisplayPpi(),
                350,
                450,
                550
        );
    }


    // ============================================================
    // SCORING HELPERS
    // ============================================================

    /*
     * Produces:
     *
     * value <= low       → 60
     * low → high         → 60 → 90
     * high → excellent   → 90 → 100
     * value >= excellent → 100
     *
     * This deliberately avoids making a normal flagship
     * specification look like a "0/100" result.
     */

    private double scoreByRange(
            double value,
            double low,
            double high,
            double excellent) {

        if (value <= low) {
            return 60;
        }

        if (value >= excellent) {
            return 100;
        }

        if (value <= high) {

            return 60
                    + ((value - low)
                    / (high - low)) * 30;
        }

        return 90
                + ((value - high)
                / (excellent - high)) * 10;
    }


    /*
     * Same concept, but lower values are better.
     *
     * worst → 60
     * good  → 90
     * best  → 100
     */

    private double scoreInverseByRange(
            double value,
            double worst,
            double good,
            double best) {

        if (value >= worst) {
            return 60;
        }

        if (value <= best) {
            return 100;
        }

        if (value >= good) {

            return 60
                    + ((worst - value)
                    / (worst - good)) * 30;
        }

        return 90
                + ((good - value)
                / (good - best)) * 10;
    }


    private double roundScore(double score) {

        return Math.round(
                Math.max(0, Math.min(100, score))
                        * 10.0
        ) / 10.0;
    }
}