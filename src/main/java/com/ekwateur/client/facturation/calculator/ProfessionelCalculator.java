package com.ekwateur.client.facturation.calculator;

import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.client.Professionnel;
import com.ekwateur.client.facturation.model.energy.Consumption;
import com.ekwateur.client.facturation.model.energy.EnergyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessionelCalculator implements FacturationCalculator{

    @Value("${professionel.sales.limit}")
    private long salesLimit;

    @Value("${professionel.above.electricity.price}")
    private double aboveLimitElectricityPrice;

    @Value("${professionel.above.gaz.price}")
    private double aboveLimitGazPrice;

    @Value("${professionel.below.electricity.price}")
    private double belowLimitElectricityPrice;

    @Value("${professionel.below.gaz.price}")
    private double belowLimitGazPrice;

    @Override
    public Facturation createFacturation(Meter meter) {
        String reference = meter.getClient().getReference();
        List<Consumption> consumptionList = meter.getConsumptionList();
        Double sales = ((Professionnel)meter.getClient()).getSales();
        return new Facturation(reference, calculateTotal(consumptionList, sales));
    }

    private double calculateTotal(List<Consumption> consumptionList, Double sales) {
        return consumptionList.stream()
                .map(c -> calculatePrice(c, sales))
                .reduce(0.0, Double::sum, Double::sum);
    }

    private double calculatePrice(Consumption consumption, Double sales) {
        if(sales < salesLimit) { //TODO L'énoncé ne précise pas le cas CA == limite
            return calculatePriceBelowLimit(consumption);
        } else {
            return calculatePriceAboveLimit(consumption);
        }
    }

    private double calculatePriceBelowLimit(Consumption consumption) {
        if(EnergyType.ELECTRICITY.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * belowLimitElectricityPrice;
        } else if (EnergyType.GAZ.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * belowLimitGazPrice;
        } else {
            throw new IllegalStateException("Type d'énergie non reconnu "+ consumption.getEnergyType());
        }
    }

    private double calculatePriceAboveLimit(Consumption consumption) {
        if(EnergyType.ELECTRICITY.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * aboveLimitElectricityPrice;
        } else if (EnergyType.GAZ.equals(consumption.getEnergyType())) {
            return consumption.getAmount() * aboveLimitGazPrice;
        } else {
            throw new IllegalStateException("Type d'énergie non reconnu "+ consumption.getEnergyType());
        }
    }
}
