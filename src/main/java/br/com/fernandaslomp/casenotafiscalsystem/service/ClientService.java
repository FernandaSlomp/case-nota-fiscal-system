package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.ClientDTO;
import br.com.fernandaslomp.casenotafiscalsystem.exception.ClientNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClientService {

    private RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(NotaFiscalService.class);

    public ClientService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8080/api/mock/client/")
                .build();
    }

    public ClientDTO findClientData(String cpfCnpj) {

        logger.info("findClientData process started - cpfCnpj: " + cpfCnpj);

        var response = restClient.get().uri(cpfCnpj).retrieve().toEntity(ClientDTO.class);

        if (response.getStatusCode().isError() || !response.hasBody())
            throw new ClientNotFoundException("ClientNotFoundException!");

        return response.getBody();
    }
}
