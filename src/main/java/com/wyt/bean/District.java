package com.wyt.bean;

public class District {
    private AirQualityIndex airQualityIndex;

    public AirQualityIndex getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(AirQualityIndex airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}