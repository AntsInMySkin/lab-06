package com.example.code;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CityListTest {

    private CityList cityList;
    private City city1;
    private City city2;

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }



    @Before
    public void setup() {
        cityList = new CityList();
        city1 = new City("Edmonton", "Alberta");
        city2 = new City("Calgary", "Alberta");
    }

    @Test
    public void testAddAndHasCity() {
        assertFalse(cityList.hasCity(city1));
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));
    }

    @Test
    public void testAddDuplicateCityThrowsException() {
        cityList.add(city1);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city1));
    }

    @Test
    public void testDeleteCitySuccessfully() {
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));

        cityList.deleteCity(city1);
        assertFalse(cityList.hasCity(city1));
    }

    @Test
    public void testDeleteCityThrowsExceptionIfNotFound() {
        assertThrows(IllegalArgumentException.class, () -> cityList.deleteCity(city1));
    }

    @Test
    public void testCountCities() {
        assertEquals(0, cityList.countCities());

        cityList.add(city1);
        assertEquals(1, cityList.countCities());

        cityList.add(city2);
        assertEquals(2, cityList.countCities());

        cityList.deleteCity(city1);
        assertEquals(1, cityList.countCities());
    }

    @Test
    public void testGetCitiesReturnsSortedList() {
        cityList.add(city2); // Calgary
        cityList.add(city1); // Edmonton

        assertEquals("Calgary", cityList.getCities().get(0).getName());
        assertEquals("Edmonton", cityList.getCities().get(1).getName());
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


}