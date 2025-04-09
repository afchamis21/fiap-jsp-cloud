package com.fiap.on.esoa.domain;

import java.math.BigDecimal;

public class Wine {
    private String maker;
    private String name;
    private String image;
    private String alt;
    private String country;
    private String grape;
    private BigDecimal price;
    private Integer rating;
    private Integer year;

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

    public Wine() {
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGrape() {
        return grape;
    }

    public void setGrape(String grape) {
        this.grape = grape;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "maker='" + maker + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", alt='" + alt + '\'' +
                ", country='" + country + '\'' +
                ", grape='" + grape + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
