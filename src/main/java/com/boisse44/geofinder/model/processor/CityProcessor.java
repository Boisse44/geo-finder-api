package com.boisse44.geofinder.model.processor;

import com.boisse44.geofinder.model.City;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.BeanListProcessor;

public class CityProcessor extends BeanListProcessor<City> {

    public CityProcessor() {
        super(City.class);
    }

    @Override
    public void beanProcessed(City city, ParsingContext context) {
    }
    
}
