package com.ekwateur.client.facturation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MeterDto (
    @NotNull @JsonProperty("client") @Valid ClientDto clientDto,
    @JsonProperty("consumptions") @NotNull List<ConsumptionDto> consumptionDtoList
) {}