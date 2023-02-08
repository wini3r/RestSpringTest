package com.wini3r.restspringtest.model;

import java.math.BigDecimal;
import java.util.Objects;

public class TaxSystem {

    private Long id;
    private String name;
    private BigDecimal taxValue;

    public TaxSystem() {
    }

    public TaxSystem(Long id) {
        this.id = id;
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

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.taxValue);
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
        final TaxSystem other = (TaxSystem) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.taxValue, other.taxValue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaxSystem{" + "id=" + id + ", name=" + name + ", taxValue=" + taxValue + '}';
    }

}
