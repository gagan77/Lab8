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
     * add a new city to the list
     * check if the list contains the new city
     * and confirm that the list size grows by one
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

    @Test
    public void testDelete() {
        list = MockCityList();
        City cityToDelete = new City("Calgary","Alberta");
        list.add(cityToDelete);
        assertEquals(1, list.getCount());
        list.deleteCity(cityToDelete);
        assertEquals(0, list.getCount());
    }



}
