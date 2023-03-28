package com.boisse44.geofinder.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {
    private String name;
    private String longitude;
    private String latitude;
    private String score;
    
}
