package com.wini3r.restspringtest.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
public class Carrier {
    
//          `ID`          BIGINT        NOT NULL AUTO_INCREMENT
//	  , `NAME`        VARCHAR(90)   NOT NULL
//	  , `INN`         VARCHAR(12)   NOT NULL
//	  , `REG_ADDRESS` VARCHAR(255)  NOT NULL
//	  , `REG_COUNTRY` VARCHAR(90)   NOT NULL
//	  , `TAX_SYSTEM`  TINYINT       NULL
//	  , PRIMARY KEY (`ID`)

    private Long id;

    @NotNull(message = "Имя не должно быть пустым")
    @Size(min = 1, max = 30)
    private String name;
    private String inn;
    private String regAddress;
    private String regCountry;
    private Short taxSystem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getRegCountry() {
        return regCountry;
    }

    public void setRegCountry(String regCountry) {
        this.regCountry = regCountry;
    }

    public Short getTaxSystem() {
        return taxSystem;
    }

    public void setTaxSystem(Short taxSystem) {
        this.taxSystem = taxSystem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.inn);
        hash = 83 * hash + Objects.hashCode(this.regAddress);
        hash = 83 * hash + Objects.hashCode(this.regCountry);
        hash = 83 * hash + Objects.hashCode(this.taxSystem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrier other = (Carrier) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.inn, other.inn)) {
            return false;
        }
        if (!Objects.equals(this.regAddress, other.regAddress)) {
            return false;
        }
        if (!Objects.equals(this.regCountry, other.regCountry)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.taxSystem, other.taxSystem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrier{" + "id=" + id + ", name=" + name + ", inn=" + inn + ", regAddress=" + regAddress + ", regCountry=" + regCountry + ", taxSystem=" + taxSystem + '}';
    }

}
