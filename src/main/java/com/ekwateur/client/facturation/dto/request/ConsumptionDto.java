package com.ekwateur.client.facturation.dto.request;

import jakarta.validation.constraints.NotNull;

public record ConsumptionDto(@NotNull EnergyTypeDto energyType, Double amount) {}
