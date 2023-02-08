package com.wini3r.restspringtest.dao;

import com.wini3r.restspringtest.mapper.TaxSystemMapper;
import com.wini3r.restspringtest.model.TaxSystem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxSystemDao {

    private final TaxSystemMapper taxSystemMapper;

    @Autowired
    public TaxSystemDao(TaxSystemMapper taxSystemMapper) {
        this.taxSystemMapper = taxSystemMapper;
    }

    public List<TaxSystem> selectAll() {
        return taxSystemMapper.selectTaxSystems();
    }

    public TaxSystem select(Long id) {
        return taxSystemMapper.selectTaxSystem(id);
    }

    public void insert(TaxSystem carrier) {
        taxSystemMapper.insertTaxSystem(carrier);
    }

    public void update(TaxSystem carrier) {
        taxSystemMapper.updateTaxSystem(carrier);
    }

    public void delete(Long id) {
        taxSystemMapper.deleteTaxSystem(id);
    }

}
