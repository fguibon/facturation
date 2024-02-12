package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.response.FacturationDto;
import com.ekwateur.client.facturation.model.Facturation;

public class FacturationMapper {

    public static FacturationDto mapToDto(Facturation facturation) {
        return new FacturationDto(facturation.getReference(), facturation.getTotal());
    }
}
