package br.com.fernandaslomp.casenotafiscalsystem.controller;

import br.com.fernandaslomp.casenotafiscalsystem.api.NotaFiscalAPI;
import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.service.NotaFiscalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaFiscalController implements NotaFiscalAPI {

    private static final Logger logger = LoggerFactory.getLogger(NotaFiscalController.class);

    @Autowired
    private NotaFiscalService notaFiscalService;

    @Override
    public ResponseEntity createNotaFiscal(NotaFiscalRequestDTO notaFiscalRequest) {

        logger.info("createNotaFiscal process started - NotaId: " + notaFiscalRequest.getIdNotaFiscal());

        notaFiscalService.processNotaFiscal(notaFiscalRequest);

        logger.info("createNotaFiscal process finished - NotaId: " + notaFiscalRequest.getIdNotaFiscal());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
