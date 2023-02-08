/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wini3r.restspringtest;

import com.wini3r.restspringtest.mapper.CarrierMapper;
import com.wini3r.restspringtest.mapper.CountryMapper;
import com.wini3r.restspringtest.mapper.TaxSystemMapper;
import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.model.Country;
import com.wini3r.restspringtest.model.TaxSystem;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author wini3r
 */
public class Main {

    public static void main(String[] args) {
        init();
        SqlSessionFactory factory = getSqlSessionFactory();
        try (SqlSession session = factory.openSession()) {
            CountryMapper countryMapper = session.getMapper(CountryMapper.class);
            countryMapper.selectCountries().forEach(System.out::println);
  
            System.out.println("");
            TaxSystemMapper taxSystemMapper = session.getMapper(TaxSystemMapper.class);
            taxSystemMapper.selectTaxSystems().forEach(System.out::println);
            
            System.out.println("");
            CarrierMapper carrierMapper = session.getMapper(CarrierMapper.class);
            carrierMapper.selectCarriers().forEach(System.out::println);
 
        }
    }

    private static SqlSessionFactory getSqlSessionFactory() {
        String resource = "database/mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);) {
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка чтения конфига mybatis: " + resource, ex);
        }
    }

    private static void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
