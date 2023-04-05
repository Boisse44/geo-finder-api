package com.boisse44.geofinder.model.converter;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Component;

import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.model.Country;
import com.boisse44.geofinder.model.dto.CityDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CityToCityDTOConverter {

    public CityDTO convert(City city, String keyword) {
        return CityDTO
            .builder()
            .name(formatName(city))
            .longitude(city.getLongitude())
            .latitude(city.getLatitude())
            .score(Double.parseDouble(getScore(city, keyword)))
            .build();
    }

    private String formatName(City city) {
        return String.format("%s, %s, %s", city.getName(), city.getCountry(), formatAdmin(city));
    }

    private String formatAdmin(City city) {
        return city.getCountry().equals(Country.US.toString())
        ? city.getAdmin1()
        : getCanadaProvince(city.getAdmin1());
    }

    private String getScore(City city, String keyword) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        return Double.toString(normalizedLevenshteinDistance(levenshteinDistance.apply(keyword, city.getName()), keyword, city.getName()));
    }

    private double normalizedLevenshteinDistance(double levenshtein, String s1, String s2) {
        return 1-(levenshtein / Math.max(s1.length(), s2.length()));
    }

    private String getCanadaProvince(String admin1) {
        switch(admin1){
            case "01":
                return "AB";
            case "02":
                return "BC";
            case "03":
                return "MB";
            case "04":
                return "NB";
            case "05":
                return "NL";
            case "07":
                return "NS";
            case "08":
                return "ON";
            case "09":
                return "PE";
            case "10":
                return "QC";
            case "11":
                return "SK";
            case "12":
                return "YT";
            case "13":
                return "NT";
            case "14":
                return "NU";
            default:
                return "";
        }
    } 
}
