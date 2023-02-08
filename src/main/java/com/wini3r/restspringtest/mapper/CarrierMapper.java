package com.wini3r.restspringtest.mapper;

import com.wini3r.restspringtest.model.Carrier;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
        @Result(property = "regCountry", column = "REG_COUNTRY"),
        @Result(property = "taxSystem", column = "TAX_SYSTEM")
    })
    @Select("SELECT * FROM carrier WHERE id = #{id}")
    public Carrier selectCarrier(Long id);

    @Results(id = "carrierResults", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "name", column = "NAME"),
        @Result(property = "inn", column = "INN"),
        @Result(property = "regAddress", column = "REG_ADDRESS"),
        @Result(property = "regCountry", column = "REG_COUNTRY"),
        @Result(property = "taxSystem", column = "TAX_SYSTEM")
    })
    @Select("SELECT * FROM carrier")
    public List<Carrier> selectCarriers();

    @Insert("INSERT INTO `carrier`(`NAME`, `INN`, `REG_ADDRESS`, `REG_COUNTRY`, `TAX_SYSTEM`) "
            + "VALUES (#{name}, #{inn}, #{regAddress}, #{regCountry}, #{taxSystem})")
    public long insertCarrier(Carrier carrier);

    @Update("UPDATE `carrier` SET `NAME`=#{name}"
            + ",`INN`=#{inn}"
            + ",`REG_ADDRESS`=#{regAddress}"
            + ",`REG_COUNTRY`=#{regCountry}"
            + ",`TAX_SYSTEM`=#{taxSystem}"
            + " WHERE id = #{id}")
    public long updateCarrier(Carrier carrier);

    @Delete("DELETE FROM `carrier` WHERE id = #{id}")
    public long deleteCarrier(Long id);

}
