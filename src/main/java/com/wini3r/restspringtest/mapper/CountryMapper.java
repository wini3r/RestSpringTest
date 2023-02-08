package com.wini3r.restspringtest.mapper;

import com.wini3r.restspringtest.model.Country;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CountryMapper {

    @Results(id = "countryResult", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "code", column = "CODE"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "shortName", column = "SHORT_NAME")
    })
    @Select("SELECT * FROM country WHERE id = #{id}")
    public Country selectCountry(Long id);

    @Results(id = "countryResults", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "code", column = "CODE"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "shortName", column = "SHORT_NAME")
    })
    @Select("SELECT * FROM country")
    public List<Country> selectCountries();

    @Insert("INSERT INTO `country`(`CODE`, `NAME`, `SHORT_NAME`) "
            + "VALUES (#{code}, #{name}, #{shortName})")
    public long insertCountry(Country country);

    @Update("UPDATE `country` SET `CODE`=#{code}"
            + ",`NAME`=#{name}"
            + ",`SHORT_NAME`=#{shortName}"
            + " WHERE id = #{id}")
    public long updateCountry(Country country);

    @Delete("DELETE FROM `country` WHERE id = #{id}")
    public long deleteCountry(Long id);

}
