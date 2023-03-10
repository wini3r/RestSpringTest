package com.wini3r.restspringtest.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Carrier {

    private Long id;

    @NotNull(message = "Название не должно быть пустым")
    @Size(min = 1, max = 90, message = "Название должно содержать от 1 до 90 символов")
    private String name;

    private String inn;
    private String regAddress;
    private Country country;
    private TaxSystem taxSystem;

    public Carrier() {
    }

    public Carrier(Long id, String name, String inn, String regAddress, Country country, TaxSystem taxSystem) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.regAddress = regAddress;
        this.country = country;
        this.taxSystem = taxSystem;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TaxSystem getTaxSystem() {
        return taxSystem;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.inn);
        hash = 13 * hash + Objects.hashCode(this.regAddress);
        hash = 13 * hash + Objects.hashCode(this.country);
        hash = 13 * hash + Objects.hashCode(this.taxSystem);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.taxSystem, other.taxSystem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrier{" + "id=" + id + ", name=" + name + ", inn=" + inn + ", regAddress=" + regAddress + ", country=" + country + ", taxSystem=" + taxSystem + '}';
    }

}
