package br.com.fernandaslomp.casenotafiscalsystem.mock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class PaymentMethodDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Double amount;
    private String stats;
    private LocalDateTime issuanceDate;
    private Long paymentTypeId;

}
