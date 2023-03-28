package com.boisse44.geofinder.model;

import com.univocity.parsers.annotations.Parsed;

import lombok.Data;

@Data
public class City {
    @Parsed(field = "id")
    private String id;

    @Parsed(field = "name")
    private String name;

    @Parsed(field = "lat")
    private String latitude;

    @Parsed(field = "long")
    private String longitude;

    @Parsed(field="country")
    private String country;

    @Parsed(field="admin1")
    private String admin1;
}
