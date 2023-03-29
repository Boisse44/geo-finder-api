package com.boisse44.geofinder.repository.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boisse44.geofinder.model.City;
import com.boisse44.geofinder.repository.CityRepository;
import com.google.common.collect.Multimap;
import com.google.common.collect.ArrayListMultimap;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import jakarta.annotation.PostConstruct;

@Service
public class CityRepositoryImpl implements CityRepository{

    private final Multimap<String, City> dataMap = ArrayListMultimap.create();

    @PostConstruct
    private void populateDataMap() {
        BeanListProcessor<City> rowProcessor = parseDataFromFile();
        for (City data : rowProcessor.getBeans()) {
            dataMap.put(data.getName(), data);
        }
    }

    private BeanListProcessor<City> parseDataFromFile() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("cities_canada-usa.tsv");
        TsvParserSettings settings = new TsvParserSettings();

        BeanListProcessor<City> rowProcessor = new BeanListProcessor<>(City.class);
        settings.setHeaderExtractionEnabled(true);
        settings.setProcessor(rowProcessor);
        settings.selectFields("id", "name", "lat", "long", "country", "admin1", "population");
        TsvParser parser = new TsvParser(settings);
        parser.parseAllRecords(is);
        return rowProcessor;
    }

    public List<City> getDataByName(String name) {
        List<City> result = new ArrayList<>();

        for (String city: dataMap.keySet()) {
            if (city.contains(name)) {
                dataMap.get(city).forEach(item -> result.add(item));
            }
        }
        return result;
    }

    public List<City> getAllData() {
        return new ArrayList<>(dataMap.values());
    }
    
}
