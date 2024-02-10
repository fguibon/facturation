package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.request.MeterDto;
import com.ekwateur.client.facturation.model.Meter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MeterMapper {
    private final ClientMapper clientMapper;

    public MeterMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    public Meter mapToModel(MeterDto meterDto) {
        return new Meter(
                clientMapper.mapToClient(meterDto.getClientDto()),
                meterDto.getConsumptionDtoList()
                        .stream()
                        .map(ConsumptionMapper::mapToModel).collect(Collectors.toList())
        );
    }
}
