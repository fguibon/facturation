package com.ekwateur.client.facturation.model.client;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Professionnel extends Client {

    private String siret;
    private String companyName;
    private Double sales;

    public Professionnel(String reference, String siret, String companyName, Double sales) {
        super(reference);
        this.siret = siret;
        this.companyName = companyName;
        this.sales = sales;
    }

    public Professionnel(String reference, Double sales) {
        super(reference);
        this.sales = sales;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Professionnel that = (Professionnel) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(siret, that.siret).append(companyName, that.companyName).append(sales, that.sales).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(siret).append(companyName).append(sales).toHashCode();
    }
}
