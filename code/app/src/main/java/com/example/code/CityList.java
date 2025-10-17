package com.example.code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if the city exists in the list.
     * @param city
     * @return true if city is in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if it exists, else throws an exception.
     * @param city
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City does not exist in the list.");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list.
     * @return Number of cities
     */
    public int countCities() {
        return cities.size();
    }

}