package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.dto.ClientDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.exception.InvalidNotaFiscalException;
import br.com.fernandaslomp.casenotafiscalsystem.repository.NotaFiscalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

@Service
public class NotaFiscalService {

    private RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(NotaFiscalService.class);

    public NotaFiscalService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8080/api/mock/client/")
                .build();
    }

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;



    @Transactional
    public void processNotaFiscal(NotaFiscalRequestDTO notaFiscal) {

        //validar nota gov
        validate(notaFiscal);

        //obter User
        ClientDTO clientDTO = clientService.findClientData(notaFiscal.getCpfCnpj());

        //salva notaFiscal
        NotaFiscal nf = createNotaFiscal(notaFiscal, clientDTO);

        // envia para pagamentos
        paymentService.processPayments(notaFiscal.getPayments(), nf);
    }

    private void validate(NotaFiscalRequestDTO notaFiscal) {

        logger.info("validate nota fiscal process started - NotaId: " + notaFiscal.getIdNotaFiscal());

        var response = restClient.get().uri(notaFiscal.getIdNotaFiscal()).retrieve().toEntity(String.class);

        if (response.getStatusCode().isError() )
            throw new InvalidNotaFiscalException("InvalidNotaFiscalException");

    }

    private NotaFiscal createNotaFiscal(NotaFiscalRequestDTO notaFiscal, ClientDTO u) {
        return notaFiscalRepository.save(NotaFiscal.builder()
                .numberNota(notaFiscal.getIdNotaFiscal()).amount(notaFiscal.getTotalAmount())
                .clientId(u.getId()).build());

    }
}
