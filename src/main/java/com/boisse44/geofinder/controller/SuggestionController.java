package com.boisse44.geofinder.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.model.dto.CityDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Tag(name = "Suggestions")
public interface SuggestionController {

    /**
   * 
   * Returns city name suggestions based on user input.
   * 
   * 
   * @return a list of shared conversations
   * @throws AuthenticationException if the user has not authenticated or if the session has 
   * expired
   */
  @GetMapping(value = "/suggestions", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(description = "Return the list of suggested cities.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200"),
      @ApiResponse(responseCode = "404", description = "City not found.")
    })
          
  List<CityDTO> suggestions(@RequestParam String cityName, @RequestParam(required = false) String longitude, @RequestParam(required = false) String latitude);
    
}
