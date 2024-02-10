package com.ekwateur.client.facturation.dto.request;

import com.ekwateur.client.facturation.validation.ValidReference;
import jakarta.validation.constraints.NotBlank;

public class ClientDto {
    @ValidReference
    private String reference;

    @NotBlank
    private ClientTypeDto type;

    private Long sales;

    public ClientDto(String reference, ClientTypeDto type, Long sales) {
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

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }
}
