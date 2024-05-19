package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.PaymentNotaFiscalDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentNotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.repository.PaymentMethodRepository;
import br.com.fernandaslomp.casenotafiscalsystem.repository.PaymentNotaFiscalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fernandaslomp.casenotafiscalsystem.enums.PaymentTypeEnum.BOLETO;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(NotaFiscalService.class);

    @Autowired
    private BillingService billingService;

    @Autowired
    private PaymentNotaFiscalRepository paymentNotaFiscalRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    void processPayments(List<PaymentNotaFiscalDTO> payments, NotaFiscal notaFiscal) {

        logger.info("Process payments process started - NotaId: " + notaFiscal.getId());

        for (PaymentNotaFiscalDTO payment : payments) {

            PaymentMethod py = createPayment(payment);
            createPaymentNotaFiscal(notaFiscal, py);

            if (payment.getPaymentMethodId().equals(BOLETO.getId())) {
                billingService.billing(py);
            }
        }
    }

    private PaymentMethod createPayment(PaymentNotaFiscalDTO pagamentoRequest) {
        return paymentMethodRepository.save(PaymentMethod.builder()
                .paymentTypeId(pagamentoRequest.getPaymentMethodId())
                .amount(pagamentoRequest.getAmount())
                .build());

    }

    private PaymentNotaFiscal createPaymentNotaFiscal(NotaFiscal notaFiscal, PaymentMethod paymentMethod) {
        return paymentNotaFiscalRepository.save(PaymentNotaFiscal.builder()
                .payment(paymentMethod)
                .notaFiscal(notaFiscal)
                .build());
    }


}
