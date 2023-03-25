package com.boisse44.geofinder.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boisse44.geofinder.controller.SuggestionController;
import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.service.CityService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SuggestionControllerImpl implements SuggestionController {

    private final CityService cityService;

    @Override
    public List<City> suggestions(@RequestParam String cityName, @RequestParam(required = false) String longitude, @RequestParam(required = false) String latitude) {
        return longitude != null && latitude != null 
            ? cityService.getCitiesByNameAndPosition(cityName, longitude, latitude)
            : cityService.getCitiesByName(cityName);
    }
    
}
