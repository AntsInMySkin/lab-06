package com.example.code;

/**
 * City class that defines the city and province variables, along with the getter and setter methods
 * for each variable.
 */
public class City {
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCityName() {
        return this.city;
    }

    public void setCityName(String city) {
        this.city = city;
    }

    public String getProvinceName() {
        return this.province;
    }

    public void setProvinceName(String province) {
        this.province = province;
    }

    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}


