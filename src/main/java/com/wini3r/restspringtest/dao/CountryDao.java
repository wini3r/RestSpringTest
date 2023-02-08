package com.wini3r.restspringtest.dao;

import com.wini3r.restspringtest.mapper.CountryMapper;
import com.wini3r.restspringtest.model.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryDao {

    private final CountryMapper countryMapper;

    @Autowired
    public CountryDao(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    public List<Country> selectAll() {
        return countryMapper.selectCountries();
    }

    public Country select(Long id) {
        return countryMapper.selectCountry(id);
    }

    public void insert(Country carrier) {
        countryMapper.insertCountry(carrier);
    }

    public void update(Country carrier) {
        countryMapper.updateCountry(carrier);
    }

    public void delete(Long id) {
        countryMapper.deleteCountry(id);
    }
}
