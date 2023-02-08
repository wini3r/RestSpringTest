package com.wini3r.restspringtest.mapper;

import com.wini3r.restspringtest.model.TaxSystem;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TaxSystemMapper {

    @Results(id = "taxSystemResult", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "name", column = "NAME"),
        @Result(property = "taxValue", column = "TAX_VALUE")
    })
    @Select("SELECT * FROM TAX_SYSTEM WHERE id = #{id}")
    public TaxSystem selectTaxSystem(Long id);

    @Results(id = "taxSystemResults", value = {
        @Result(property = "id", column = "ID", id = true),
        @Result(property = "name", column = "NAME"),
        @Result(property = "taxValue", column = "TAX_VALUE")
    })
    @Select("SELECT * FROM TAX_SYSTEM")
    public List<TaxSystem> selectTaxSystems();

    @Insert("INSERT INTO `TAX_SYSTEM`(`NAME`, `TAX_VALUE`) "
            + "VALUES (#{name}, #{taxValue})")
    public long insertTaxSystem(TaxSystem taxSystem);

    @Update("UPDATE `TAX_SYSTEM` SET `NAME`=#{name}"
            + ",`TAX_VALUE`=#{taxValue}"
            + " WHERE id = #{id}")
    public long updateTaxSystem(TaxSystem taxSystem);

    @Delete("DELETE FROM `TAX_SYSTEM` WHERE id = #{id}")
    public long deleteTaxSystem(Long id);

}
