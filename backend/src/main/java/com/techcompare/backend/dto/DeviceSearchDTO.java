package com.techcompare.backend.dto;

public class DeviceSearchDTO {

    private Long id;
    private String brand;
    private String modelName;
    private String category;
    private Integer releaseYear;
    private Double priceUsd;
    private String imageUrl;
    private Integer ramGb;
    private Integer storageGb;

    public DeviceSearchDTO() {
    }

    public DeviceSearchDTO(
            Long id,
            String brand,
            String modelName,
            String category,
            Integer releaseYear,
            Double priceUsd,
            String imageUrl,
            Integer ramGb,
            Integer storageGb) {

        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
        this.category = category;
        this.releaseYear = releaseYear;
        this.priceUsd = priceUsd;
        this.imageUrl = imageUrl;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public String getCategory() {
        return category;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getRamGb() {
        return ramGb;
    }

    public Integer getStorageGb() {
        return storageGb;
    }
}