package br.com.fernandaslomp.casenotafiscalsystem.controller;

import br.com.fernandaslomp.casenotafiscalsystem.api.NotaFiscalAPI;
import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class NotaFiscalController implements NotaFiscalAPI {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @Override
    public ResponseEntity processNotaFiscal(NotaFiscalRequestDTO notaFiscal) {
        String nf = notaFiscalService.processNotaFiscal(notaFiscal);
        return ResponseEntity.ok(nf);
    }
}
