package com.ekwateur.client.facturation.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Facturation {

    private String reference;
    private Double total;

    public Facturation(String reference, Double total) {
        this.reference = reference;
        this.total = total;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Facturation that = (Facturation) o;

        return new EqualsBuilder().append(reference, that.reference).append(total, that.total).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(reference).append(total).toHashCode();
    }

    @Override
    public String toString() {
        return "Facturation{" +
                "reference='" + reference + '\'' +
                ", total=" + total +
                '}';
    }
}
