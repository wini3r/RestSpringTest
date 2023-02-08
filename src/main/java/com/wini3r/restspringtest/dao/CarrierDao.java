package com.wini3r.restspringtest.dao;

import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.mapper.CarrierMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierDao {

    private final CarrierMapper carrierMapper;

    @Autowired
    public CarrierDao(CarrierMapper carrierMapper) {
        this.carrierMapper = carrierMapper;
    }

    public List<Carrier> selectAll() {
        return carrierMapper.selectCarriers();
    }

    public Carrier select(Long id) {
        return carrierMapper.selectCarrier(id);
    }

    public void insert(Carrier carrier) {
        carrierMapper.insertCarrier(carrier);
    }

    public void update(Carrier carrier) {
        carrierMapper.updateCarrier(carrier);
    }

    public void delete(Long id) {
        carrierMapper.deleteCarrier(id);
    }

}
