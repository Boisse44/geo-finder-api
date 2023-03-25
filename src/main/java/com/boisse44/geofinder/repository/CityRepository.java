package com.boisse44.geofinder.repository;

import java.util.List;

import com.boisse44.geofinder.model.City;

public interface CityRepository {

    List<City> getDataByName(String name);

    List<City> getAllData();
    
}
