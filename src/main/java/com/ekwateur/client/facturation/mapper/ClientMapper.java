package com.ekwateur.client.facturation.mapper;

import com.ekwateur.client.facturation.dto.request.ClientDto;
import com.ekwateur.client.facturation.model.client.*;

public class ClientMapper {

    public static Client mapToClient(ClientDto clientDto) {
        Client client;
        switch(ClientType.valueOf(clientDto.getType().name())) {

            case PARTICULIER -> client = new Particulier(clientDto.getReference(), Civilite.MME, "prenom", "nom");
            case PRO -> client = new Professionnel(clientDto.getReference(), "siret", "raison", clientDto.getSales());
            default ->
                    throw new IllegalStateException("Unexpected value: " + ClientType.valueOf(clientDto.getType().name()));
        }
        return client;
    }
}
