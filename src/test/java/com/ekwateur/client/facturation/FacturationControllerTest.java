package com.ekwateur.client.facturation;

import com.ekwateur.client.facturation.dto.request.*;
import com.ekwateur.client.facturation.mapper.MeterMapper;
import com.ekwateur.client.facturation.model.Facturation;
import com.ekwateur.client.facturation.service.FacturationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class FacturationControllerTest {

    @Mock
    private FacturationService facturationService;

    @InjectMocks
    private FacturationController facturationController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    private final String reference = "EKW12345678";

    private final Double total = 15_000.0;

    private final String path = "/facturations";

    @BeforeEach
    void setup() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(facturationController).build();
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }
    @Test
    void postFacturation_and_expect_badrequest() throws Exception {

        mockMvc.perform(post(path))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void postFacturation_with_bad_reference_and_expect_badrequest() throws Exception {
        ClientDto clientDto = new ClientDto("mock", ClientTypeDto.PRO,0.0);
        MeterDto meterDto = new MeterDto(clientDto, List.of());

        String json = objectMapper.writeValueAsString(meterDto);

        mockMvc.perform(
                        post(path)
                                .contentType(APPLICATION_JSON).content(json)
                )
                .andExpect(status().is4xxClientError());
    }

    @Test
    void postFacturation_and_expect_ok() throws Exception {
        ClientDto clientDto = new ClientDto(reference, ClientTypeDto.PRO,0.0);
        ConsumptionDto consumptionDto = new ConsumptionDto(EnergyTypeDto.ELECTRICITY, 10_000.0);
        MeterDto meterDto = new MeterDto(clientDto, List.of(consumptionDto));

        String json = objectMapper.writeValueAsString(meterDto);

        Facturation facturation = new Facturation(reference, total);
        when(facturationService.calculateFacturation(MeterMapper.mapToModel(meterDto))).thenReturn(facturation);

        mockMvc.perform(
                    post(path)
                    .contentType(APPLICATION_JSON).content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.reference").value(reference))
                .andExpect(jsonPath("$.total").value(total))
        ;
    }
}