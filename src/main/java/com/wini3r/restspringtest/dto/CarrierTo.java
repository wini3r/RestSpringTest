package com.wini3r.restspringtest.dto;

import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.model.Country;
import com.wini3r.restspringtest.model.TaxSystem;
import java.util.Objects;

public class CarrierTo {

    private Long id;
    private String name;
    private String inn;
    private String regAddress;
    private Long country;
    private Long taxSystem;

    public Carrier getAsCarrier() {
        return new Carrier(id, name, inn, regAddress, new Country(country), new TaxSystem(taxSystem));
    }

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

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getTaxSystem() {
        return taxSystem;
    }

    public void setTaxSystem(Long taxSystem) {
        this.taxSystem = taxSystem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.inn);
        hash = 89 * hash + Objects.hashCode(this.regAddress);
        hash = 89 * hash + Objects.hashCode(this.country);
        hash = 89 * hash + Objects.hashCode(this.taxSystem);
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
        final CarrierTo other = (CarrierTo) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.inn, other.inn)) {
            return false;
        }
        if (!Objects.equals(this.regAddress, other.regAddress)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
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
        return "CarrierTo{" + "id=" + id + ", name=" + name + ", inn=" + inn + ", regAddress=" + regAddress + ", country=" + country + ", taxSystem=" + taxSystem + '}';
    }

}
