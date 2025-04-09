package com.fiap.on.esoa.domain;

import java.math.BigDecimal;

public class Wine {
    private final String maker;
    private final String name;
    private final String image;
    private final String alt;
    private final String country;
    private final String grape;
    private final BigDecimal price;
    private final Integer rating;
    private final Integer year;

    public Wine(String maker, String name, String image, String alt, String country, String grape, BigDecimal price, Integer rating, Integer year) {
        this.maker = maker;
        this.name = name;
        this.image = image;
        this.alt = alt;
        this.country = country;
        this.grape = grape;
        this.price = price;
        this.rating = rating;
        this.year = year;
    }

    public String getMaker() {
        return maker;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getAlt() {
        return alt;
    }

    public String getCountry() {
        return country;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getYear() {
        return year;
    }

    public String getGrape() {
        return grape;
    }
}
