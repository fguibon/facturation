package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.response.FacturationDto;
import com.ekwateur.client.facturation.model.Facturation;
import org.springframework.stereotype.Component;

@Component
public class FacturationMapper {

    public FacturationDto mapToDto(Facturation facturation) {
        return new FacturationDto(facturation.getReference(), facturation.getTotal());
    }
}
