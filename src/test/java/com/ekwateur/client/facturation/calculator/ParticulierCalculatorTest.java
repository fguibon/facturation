package com.ekwateur.client.facturation.calculator;

import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.client.Particulier;
import com.ekwateur.client.facturation.model.energy.Consumption;
import com.ekwateur.client.facturation.model.energy.EnergyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class ParticulierCalculatorTest {
    private final String reference = "EKW12345678";
    private final double gazPrice = 0.15;

    private final double electricityPrice = 0.20;

    private final double amount = 100.0;

    @InjectMocks
    private ParticulierCalculator particulierCalculator;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(particulierCalculator, "gazPrice", gazPrice);
        ReflectionTestUtils.setField(particulierCalculator, "electricityPrice", electricityPrice);
    }

    @Test
    void createFacturation_when_type_gaz() {
        Meter meter = new Meter(new Particulier(reference), List.of(new Consumption(EnergyType.GAZ, amount)));
        Facturation facturation = new Facturation(reference, amount * gazPrice);

        assertEquals(facturation, particulierCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_type_electricity() {
        Meter meter = new Meter(new Particulier(reference), List.of(new Consumption(EnergyType.ELECTRICITY, amount)));
        Facturation facturation = new Facturation(reference, amount * electricityPrice);

        assertEquals(facturation, particulierCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_type_electricity_and_gaz() {
        Meter meter = new Meter(
                new Particulier(reference),
                List.of(new Consumption(EnergyType.ELECTRICITY, amount),
                        new Consumption(EnergyType.GAZ, amount)));
        Facturation facturation = new Facturation(reference, amount * electricityPrice + amount * gazPrice);

        assertEquals(facturation, particulierCalculator.createFacturation(meter));
    }

    @Test
    void createFacturation_when_amount_zero() {
        Meter meter = new Meter(new Particulier(reference), List.of(new Consumption(EnergyType.ELECTRICITY, 0.0)));
        Facturation facturation = new Facturation(reference, 0.0);

        assertEquals(facturation, particulierCalculator.createFacturation(meter));
    }
}