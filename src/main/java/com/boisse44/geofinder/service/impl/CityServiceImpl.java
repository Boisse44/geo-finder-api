package com.boisse44.geofinder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.repository.CityRepository;
import com.boisse44.geofinder.service.CityService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    
    @Override
    public List<City> getCitiesByName(String name) {
        return cityRepository.getDataByName(name);
    }
    @Override
    public List<City> getCitiesByNameAndPosition(String name, String longitude, String latitude) {
        return new ArrayList<>();
    }
}
