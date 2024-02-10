package com.ekwateur.client.facturation.calculator;

import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.energy.Consumption;
import com.ekwateur.client.facturation.model.energy.EnergyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticulierCalculator implements FacturationCalculator {

    @Value("${particulier.electricity.price}")
    private double electricityPrice;

    @Value("${particulier.gaz.price}")
    private double gazPrice;
    @Override
    public Facturation createFacturation(Meter meter) {
        String reference = meter.getClient().getReference();
        List<Consumption> consumptionList = meter.getConsumptionList();
        return new Facturation(reference, calculateTotal(consumptionList));
    }

    private double calculateTotal(List<Consumption> consumptionList) {
        return consumptionList.stream()
                .map(this::calculatePrice)
                .reduce(0.0, Double::sum, Double::sum);
    }

    private double calculatePrice(Consumption consumption) {
        if(EnergyType.ELECTRICITY.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * electricityPrice;
        } else if (EnergyType.GAZ.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * gazPrice;
        } else {
            throw new IllegalStateException("Type d'énergie non reconnu "+ consumption.getEnergyType());
        }
    }
}
