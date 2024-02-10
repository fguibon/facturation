package com.ekwateur.client.facturation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class MeterDto {
    @NotNull
    @JsonProperty("client")
    @Valid
    private ClientDto clientDto;

    @JsonProperty("consumptions")
    private List<ConsumptionDto> consumptionDtoList;

    public MeterDto(ClientDto clientDto, List<ConsumptionDto> consumptionDtoList) {
        this.clientDto = clientDto;
        this.consumptionDtoList = consumptionDtoList;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public List<ConsumptionDto> getConsumptionDtoList() {
        return consumptionDtoList;
    }

    public void setConsumptionDtoList(List<ConsumptionDto> consumptionDtoList) {
        this.consumptionDtoList = consumptionDtoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MeterDto meterDto = (MeterDto) o;

        return new EqualsBuilder().append(clientDto, meterDto.clientDto).append(consumptionDtoList, meterDto.consumptionDtoList).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(clientDto).append(consumptionDtoList).toHashCode();
    }
}
