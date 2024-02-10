package com.ekwateur.client.facturation;

import com.ekwateur.client.facturation.dto.request.MeterDto;
import com.ekwateur.client.facturation.dto.response.FacturationDto;
import com.ekwateur.client.facturation.mapper.FacturationMapper;
import com.ekwateur.client.facturation.mapper.MeterMapper;
import com.ekwateur.client.facturation.service.FacturationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturationController {

    private final FacturationService facturationService;

    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }

    @PostMapping
    public ResponseEntity<FacturationDto> postFacturation(@Valid @RequestBody MeterDto meterDto) {
        FacturationDto facturationDto = FacturationMapper.mapToDto(facturationService.calculateFacturation(MeterMapper.mapToModel(meterDto)));
        return ResponseEntity.ok(facturationDto);
    }
}
