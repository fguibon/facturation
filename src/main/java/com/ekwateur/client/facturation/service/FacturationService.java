package com.ekwateur.client.facturation.service;

import com.ekwateur.client.facturation.calculator.ParticulierCalculator;
import com.ekwateur.client.facturation.calculator.ProfessionelCalculator;
import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.model.Meter;
import com.ekwateur.client.facturation.model.client.Professionnel;
import org.springframework.stereotype.Service;

@Service
public class FacturationService {

    private final ProfessionelCalculator professionelCalculator;

    private final ParticulierCalculator particulierCalculator;

    public FacturationService(ProfessionelCalculator professionelCalculator, ParticulierCalculator particulierCalculator) {
        this.professionelCalculator = professionelCalculator;
        this.particulierCalculator = particulierCalculator;
    }

    public Facturation calculateFacturation(Meter meter) {
        //TODO factory pour les calculators injectée dans le constructeur
        if(meter.getClient() instanceof Professionnel) {
            return professionelCalculator.createFacturation(meter);
        } else {
            return particulierCalculator.createFacturation(meter);
        }
    }
}
