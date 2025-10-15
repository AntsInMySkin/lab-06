package com.example.code;

/**
 * City class that defines the city and province variables, along with the getter and setter methods
 * for each variable.
 */
public class City implements Comparable<City> {
    private String name;
    private String province;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    /**
     * This method compares cities based on city name field
     * @return -1 if the caller is greater than the city name field of called object
     */
    public int compareTo(City city) {
        return this.name.compareTo(city.getName());
    }
}


