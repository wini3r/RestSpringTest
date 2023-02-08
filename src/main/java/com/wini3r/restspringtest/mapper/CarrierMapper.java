package com.wini3r.restspringtest.mapper;

import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.model.Country;
import com.wini3r.restspringtest.model.TaxSystem;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CarrierMapper {

    @Results(id = "carrierResult", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "name", column = "NAME"),
        @Result(property = "inn", column = "INN"),
        @Result(property = "regAddress", column = "REG_ADDRESS"),
        @Result(property = "country", column = "FK_COUNTRY",
                javaType = Country.class, one = @One(select = "com.wini3r.restspringtest.mapper.CountryMapper.selectCountry")),
        @Result(property = "taxSystem", column = "FK_TAX_SYSTEM",
                javaType = TaxSystem.class, one = @One(select = "com.wini3r.restspringtest.mapper.TaxSystemMapper.selectTaxSystem"))
    })
    @Select("SELECT * FROM carrier WHERE id = #{id}")
    public Carrier selectCarrier(Long id);

    @Results(id = "carrierResults", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "name", column = "NAME"),
        @Result(property = "inn", column = "INN"),
        @Result(property = "regAddress", column = "REG_ADDRESS"),
        @Result(property = "country", column = "FK_COUNTRY",
                javaType = Country.class, one = @One(select = "com.wini3r.restspringtest.mapper.CountryMapper.selectCountry")),
        @Result(property = "taxSystem", column = "FK_TAX_SYSTEM",
                javaType = TaxSystem.class, one = @One(select = "com.wini3r.restspringtest.mapper.TaxSystemMapper.selectTaxSystem"))
    })
    @Select("SELECT * FROM carrier")
    public List<Carrier> selectCarriers();

    @Insert("INSERT INTO `carrier`(`NAME`, `INN`, `REG_ADDRESS`, `FK_COUNTRY`, `FK_TAX_SYSTEM`) "
            + "VALUES (#{name}, #{inn}, #{regAddress}, #{country.id}, #{taxSystem.id})")
    public long insertCarrier(Carrier carrier);

    @Update("UPDATE `carrier` SET `NAME`=#{name}"
            + ",`INN`=#{inn}"
            + ",`REG_ADDRESS`=#{regAddress}"
            + ",`FK_COUNTRY`=#{country.id}"
            + ",`FK_TAX_SYSTEM`=#{taxSystem.id}"
            + " WHERE id = #{id}")
    public long updateCarrier(Carrier carrier);

    @Delete("DELETE FROM `carrier` WHERE id = #{id}")
    public long deleteCarrier(Long id);

}
