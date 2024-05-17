package br.com.fernandaslomp.casenotafiscalsystem.api;

import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api")
public interface NotaFiscalAPI {

    @PostMapping("/notas-fiscais")
    public ResponseEntity<NotaFiscal> processNotaFiscal(@RequestBody NotaFiscalRequestDTO notaFiscal);

}
