package br.com.fernandaslomp.casenotafiscalsystem.mock.controller;

import br.com.fernandaslomp.casenotafiscalsystem.mock.dto.BasicResponseDTO;
import br.com.fernandaslomp.casenotafiscalsystem.mock.dto.ClientDTO;
import br.com.fernandaslomp.casenotafiscalsystem.mock.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.mock.dto.PaymentMethodDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    @GetMapping("/gov/{notaFiscalId}")
    public ResponseEntity<String> validateInvoice(@PathVariable String notaFiscalId) {
        return new ResponseEntity<>("true", HttpStatus.OK);
    }

    @GetMapping("/client/{cpfCnpj}")
    public ClientDTO getClient(@PathVariable String cpfCnpj) {
        return new ClientDTO(1L, "Joao", cpfCnpj, "joao@teste.com", "2198463738", "Rj", LocalDateTime.now());
    }

    @PostMapping("/boleto")
    public ResponseEntity<String> boleto(@RequestBody NotaFiscalRequestDTO boleto) {
        System.out.println("entrou");
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}
