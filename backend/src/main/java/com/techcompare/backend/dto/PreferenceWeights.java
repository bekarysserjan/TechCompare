package com.techcompare.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreferenceWeights {

    @Min(0) @Max(100)
    private Integer gaming;

    // Smartphone profile weight
    @Min(0) @Max(100)
    private Integer photography;

    // Smartphone profile weight
    @Min(0) @Max(100)
    private Integer dailyUse;

    // Laptop profile weight
    @Min(0) @Max(100)
    private Integer creator;

    // Laptop profile weight
    @Min(0) @Max(100)
    private Integer dailyProductivity;

    public Integer getGaming() { return gaming; }
    public void setGaming(Integer gaming) { this.gaming = gaming; }

    public Integer getPhotography() { return photography; }
    public void setPhotography(Integer photography) { this.photography = photography; }

    public Integer getDailyUse() { return dailyUse; }
    public void setDailyUse(Integer dailyUse) { this.dailyUse = dailyUse; }

    public Integer getCreator() { return creator; }
    public void setCreator(Integer creator) { this.creator = creator; }

    public Integer getDailyProductivity() { return dailyProductivity; }
    public void setDailyProductivity(Integer dailyProductivity) { this.dailyProductivity = dailyProductivity; }
}
