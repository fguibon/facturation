package com.ekwateur.client.facturation.dto.request;

import com.ekwateur.client.facturation.validation.ValidReference;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ClientDto {
    @ValidReference
    private String reference;
    @NotNull
    private ClientTypeDto type;

    private Double sales;

    public ClientDto() {}

    public ClientDto(String reference, ClientTypeDto type, Double sales) {
        this.reference = reference;
        this.type = type;
        this.sales = sales;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ClientTypeDto getType() {
        return type;
    }

    public void setType(ClientTypeDto type) {
        this.type = type;
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

        ClientDto clientDto = (ClientDto) o;

        return new EqualsBuilder().append(reference, clientDto.reference).append(type, clientDto.type).append(sales, clientDto.sales).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(reference).append(type).append(sales).toHashCode();
    }
}
