package com.ekwateur.client.facturation.model.client;

import jakarta.validation.constraints.Pattern;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Client {
    @Pattern(regexp = "^EKW(\\d){8}$")
    private String reference;

    public Client(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return new EqualsBuilder().append(reference, client.reference).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(reference).toHashCode();
    }

    @Override
    public String toString() {
        return "Client{" +
                "reference='" + reference + '\'' +
                '}';
    }
}

