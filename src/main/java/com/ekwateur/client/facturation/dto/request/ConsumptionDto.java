package com.ekwateur.client.facturation.dto.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ConsumptionDto {
    private EnergyTypeDto energyType;
    private Double amount;

    public ConsumptionDto(EnergyTypeDto energyType, Double amount) {
        this.energyType = energyType;
        this.amount = amount;
    }

    public EnergyTypeDto getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyTypeDto energyType) {
        this.energyType = energyType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ConsumptionDto that = (ConsumptionDto) o;

        return new EqualsBuilder().append(energyType, that.energyType).append(amount, that.amount).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(energyType).append(amount).toHashCode();
    }
}
