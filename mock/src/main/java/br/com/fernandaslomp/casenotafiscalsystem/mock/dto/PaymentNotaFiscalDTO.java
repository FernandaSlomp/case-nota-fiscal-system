package br.com.fernandaslomp.casenotafiscalsystem.mock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Builder
public class PaymentNotaFiscalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long paymentMethodId;
    private Double amount;
}
