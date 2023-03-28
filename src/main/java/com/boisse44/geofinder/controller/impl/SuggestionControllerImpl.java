package com.boisse44.geofinder.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boisse44.geofinder.controller.SuggestionController;
import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.model.converter.CityToCityDTOConverter;
import com.boisse44.geofinder.model.dto.CityDTO;
import com.boisse44.geofinder.service.CityService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SuggestionControllerImpl implements SuggestionController {

    private final CityService cityService;
    private final CityToCityDTOConverter cityDTOConverter;

    @Override
    public List<CityDTO> suggestions(@RequestParam String cityName, @RequestParam(required = false) String longitude, @RequestParam(required = false) String latitude) {
        List<City> cities = longitude != null && latitude != null 
            ? cityService.getCitiesByNameAndPosition(cityName, longitude, latitude)
            : cityService.getCitiesByName(cityName);
        return cities.stream().map(city -> cityDTOConverter.convert(city, cityName)).toList();
    }
    
}
