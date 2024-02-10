package com.ekwateur.client.facturation.service;

import com.ekwateur.client.facturation.calculator.ParticulierCalculator;
import com.ekwateur.client.facturation.calculator.ProfessionelCalculator;
import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.client.Particulier;
import com.ekwateur.client.facturation.model.client.Professionnel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FacturationServiceTest {
    private final String reference = "EKW12345678";
    private final double total = 100.0;

    private final double sales = 100_000.0;

    @InjectMocks
    private FacturationService facturationService;

    @Mock
    private ParticulierCalculator particulierCalculator;

    @Mock
    private ProfessionelCalculator professionelCalculator;

    @Test
    void calculateFacturation_when_particulier() {
        Meter meter = new Meter(new Particulier(reference), List.of());
        Facturation facturation = new Facturation(reference, total);
        when(particulierCalculator.createFacturation(meter)).thenReturn(facturation);

        assertEquals(facturation, facturationService.calculateFacturation(meter));
    }

    @Test
    void calculateFacturation_when_professionel() {
        Meter meter = new Meter(new Professionnel(reference, sales), List.of());
        Facturation facturation = new Facturation(reference, total);
        when(professionelCalculator.createFacturation(meter)).thenReturn(facturation);

        assertEquals(facturation, facturationService.calculateFacturation(meter));
    }
}