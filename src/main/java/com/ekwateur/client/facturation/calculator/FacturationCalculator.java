package com.ekwateur.client.facturation.calculator;

import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import org.springframework.stereotype.Component;

@Component
public interface FacturationCalculator {
    Facturation createFacturation(Meter meter);
}
