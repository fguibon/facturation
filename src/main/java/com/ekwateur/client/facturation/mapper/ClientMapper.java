package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.request.ClientDto;
import com.ekwateur.client.facturation.model.client.*;

public class ClientMapper {

    public static Client mapToClient(ClientDto clientDto) {
        Client client;
        switch(ClientType.valueOf(clientDto.type().name())) {

            case PARTICULIER -> client = new Particulier(clientDto.reference(), Civilite.MME, "prenom", "nom");
            case PRO -> client = new Professionnel(clientDto.reference(), "siret", "raison", clientDto.sales());
            default ->
                    throw new IllegalStateException("Unexpected value: " + ClientType.valueOf(clientDto.type().name()));
        }
        return client;
    }
}
