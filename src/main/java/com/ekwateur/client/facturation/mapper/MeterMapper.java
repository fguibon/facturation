package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.request.MeterDto;
import com.ekwateur.client.facturation.model.Meter;

import java.util.stream.Collectors;

public class MeterMapper {

    public static Meter mapToModel(MeterDto meterDto) {
        return new Meter(
                ClientMapper.mapToClient(meterDto.getClientDto()),
                meterDto.getConsumptionDtoList()
                        .stream()
                        .map(ConsumptionMapper::mapToModel).collect(Collectors.toList())
        );
    }
}
