package com.wini3r.restspringtest.dao;

import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.mapper.CarrierMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrierDao extends MybatisMapperExecuter<CarrierMapper> {

    @Autowired
    public CarrierDao(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    @Override
    protected Class<CarrierMapper> getMapperClass() {
        return CarrierMapper.class;
    }

    public List<Carrier> selectAll() {
        return getResults(CarrierMapper::selectCarriers);
    }

    public Carrier select(Long id) {
        return getResult((mapper) -> {
            return mapper.selectCarrier(id);
        });
    }

    public void insert(Carrier carrier) {
        runAndCommit((mapper) -> {
            mapper.insertCarrier(carrier);
        });
    }

    public void update(Carrier carrier) {
        runAndCommit((mapper) -> {
            mapper.updateCarrier(carrier);
        });
    }

    public void delete(Long id) {
        runAndCommit((mapper) -> {
            mapper.deleteCarrier(id);
        });
    }

}
