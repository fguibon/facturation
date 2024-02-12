package com.ekwateur.client.facturation.model;

import com.ekwateur.client.facturation.model.client.Client;
import com.ekwateur.client.facturation.model.energy.Consumption;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class Meter {
    private Client client;
    private List<Consumption> consumptionList;

    public Meter(Client client, List<Consumption> consumptionList) {
        this.client = client;
        this.consumptionList = consumptionList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Consumption> getConsumptionList() {
        return consumptionList;
    }

    public void setConsumptionList(List<Consumption> consumptionList) {
        this.consumptionList = consumptionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Meter meter = (Meter) o;

        return new EqualsBuilder().append(client, meter.client).append(consumptionList, meter.consumptionList).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(client).append(consumptionList).toHashCode();
    }
}
