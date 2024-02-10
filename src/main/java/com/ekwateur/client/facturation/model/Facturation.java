package com.ekwateur.client.facturation.model;

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
}
