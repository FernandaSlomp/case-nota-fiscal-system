package br.com.fernandaslomp.casenotafiscalsystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class NotaFiscalRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String CPF;
    private String idNotaFiscal;
    private Double totalAmount;
    private String status;
    private LocalDateTime issuanceDate;
    private List<PaymentNotaFiscalDTO> payments;
}
