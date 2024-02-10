package com.ekwateur.client.facturation.calculator;

import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.client.Professionnel;
import com.ekwateur.client.facturation.model.energy.Consumption;
import com.ekwateur.client.facturation.model.energy.EnergyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class ProfessionelCalculatorTest {

    private String reference = "EKW12345678";

    // Sales
    private long salesLimit = 1000;

    private double salesBelow = salesLimit - 100;
    private double salesAbove = salesLimit + 100;

    // Prices

    private double aboveLimitElectricityPrice = 0.10;

    private final double aboveLimitGazPrice = 0.15;

    private final double belowLimitElectricityPrice = 0.20;
    private double belowLimitGazPrice = 0.25;

    private double amount = 100.0;

    private ProfessionelCalculator professionelCalculator;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(professionelCalculator, "salesLimit", salesLimit);

        ReflectionTestUtils.setField(professionelCalculator, "aboveLimitElectricityPrice", aboveLimitElectricityPrice);
        ReflectionTestUtils.setField(professionelCalculator, "aboveLimitGazPrice", aboveLimitGazPrice);

        ReflectionTestUtils.setField(professionelCalculator, "belowLimitElectricityPrice", belowLimitElectricityPrice);
        ReflectionTestUtils.setField(professionelCalculator, "belowLimitGazPrice", belowLimitGazPrice);
    }

    @Test
    void createFacturation_when_type_gaz_and_sales_below() {

        Meter meter = new Meter(new Professionnel(reference, salesBelow), List.of(new Consumption(EnergyType.GAZ, amount)));
        Facturation facturation = new Facturation(reference, amount * belowLimitGazPrice);

        assertEquals(facturation, professionelCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_type_gaz_and_sales_above() {

        Meter meter = new Meter(new Professionnel(reference, salesAbove), List.of(new Consumption(EnergyType.GAZ, amount)));
        Facturation facturation = new Facturation(reference, amount * aboveLimitGazPrice);

        assertEquals(facturation, professionelCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_type_electricity_and_sales_below() {

        Meter meter = new Meter(new Professionnel(reference, salesBelow), List.of(new Consumption(EnergyType.ELECTRICITY, amount)));
        Facturation facturation = new Facturation(reference, amount * belowLimitElectricityPrice);

        assertEquals(facturation, professionelCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_type_electricity_and_sales_above() {

        Meter meter = new Meter(new Professionnel(reference, salesAbove), List.of(new Consumption(EnergyType.ELECTRICITY, amount)));
        Facturation facturation = new Facturation(reference, amount * aboveLimitElectricityPrice);

        assertEquals(facturation, professionelCalculator.createFacturation(meter));
    }
}