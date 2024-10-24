package com.example.lab8;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Tests the hasCity method by adding a new city to the list
     * and check if the list contains the new city.
     * Lastly, confirm that the list size grows by one.
     */
    @Test
    public void testHasCity() {
        list = MockCityList();
        int listSize = list.getCount();
        City newCity = new City("Winnipeg","Manitoba");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Tests the deleteCity method by adding a city,
     * checking the count after adding, then deleting
     * the city and checking the count again. Last check
     * uses hasCity to ensure the city that was
     * deleted from the list.
     */
    @Test
    public void testDelete() {
        list = MockCityList();
        City cityToDelete = new City("Calgary","Alberta");
        list.addCity(cityToDelete);
        int listSize = list.getCount();
        assertEquals(1, listSize);
        list.deleteCity(cityToDelete);
        assertEquals(0, listSize - 1);
        assertFalse(list.hasCity(cityToDelete));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.getCount());

        City newCity = new City("Calgary", "Alberta");
        list.addCity(newCity);
        assertEquals(1, list.getCount());

        assertFalse(list.getCount() > 1);
        assertTrue(list.getCount() <= 2);

        City newCityTwo = new City("Banff", "Alberta");
        list.addCity(newCityTwo);
        assertEquals(2, list.getCount());

        list.deleteCity(newCityTwo);
        assertEquals(1, list.getCount());
        list.deleteCity(newCity);
        assertEquals(0, list.getCount());

    }


}
