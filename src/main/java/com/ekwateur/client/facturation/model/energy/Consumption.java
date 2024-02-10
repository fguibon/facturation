package com.ekwateur.client.facturation.model.energy;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Consumption {
    private EnergyType energyType;
    private Double amount;

    public Consumption(EnergyType energyType, Double amount) {
        this.energyType = energyType;
        this.amount = amount;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
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

        Consumption that = (Consumption) o;

        return new EqualsBuilder().append(energyType, that.energyType).append(amount, that.amount).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(energyType).append(amount).toHashCode();
    }
}
