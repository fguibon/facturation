package com.ekwateur.client.facturation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClientDto (
        @NotNull @Pattern(regexp = "^EKW(\\d){8}$") String reference,
        @NotNull ClientTypeDto type,
        @NotNull Double sales
) {}
