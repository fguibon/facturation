package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.request.ConsumptionDto;
import com.ekwateur.client.facturation.model.energy.Consumption;
import com.ekwateur.client.facturation.model.energy.EnergyType;
import org.springframework.stereotype.Component;

@Component
public class ConsumptionMapper {

    public static Consumption mapToModel(ConsumptionDto consumptionDto) {
        return new Consumption(
                EnergyType.valueOf(consumptionDto.getEnergyType().name()),
                        consumptionDto.getAmount()
                );
    }
}
