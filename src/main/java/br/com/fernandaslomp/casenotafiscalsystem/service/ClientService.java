package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.entity.Client;
import br.com.fernandaslomp.casenotafiscalsystem.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public Client findClientData(String cpf) {

        //obter User
        Client client = Client.builder()
                .id(1L)
                .CPF("123").build();

        return client;
    }
}
