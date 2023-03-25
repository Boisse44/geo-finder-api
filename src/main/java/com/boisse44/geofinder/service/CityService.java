package com.boisse44.geofinder.service;

import java.util.List;

import com.boisse44.geofinder.model.City;

public interface CityService {

    List<City> getCitiesByName(String name);
    List<City> getCitiesByNameAndPosition(String name, String longitude, String latitude);
    
}
