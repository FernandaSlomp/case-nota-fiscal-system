package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.dto.PaymentNotaFiscalDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.Client;
import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentNotaFiscal;
import br.com.fernandaslomp.casenotafiscalsystem.repository.PaymentMethodRepository;
import br.com.fernandaslomp.casenotafiscalsystem.repository.NotaFiscalRepository;
import br.com.fernandaslomp.casenotafiscalsystem.repository.PaymentNotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.fernandaslomp.casenotafiscalsystem.enums.PaymentTypeEnum.BOLETO;

@Service
public class NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentNotaFiscalRepository paymentNotaFiscalRepository;

    @Autowired
    private BillingService billingService;
    @Autowired
    private ClientService clientService;

    @Transactional
    public String processNotaFiscal(NotaFiscalRequestDTO notaFiscal) {

        //validar nota gov
        validate(notaFiscal);

        //obter User
        Client u = clientService.findClientData(notaFiscal.getCPF());

        //salva notaFiscal
        NotaFiscal nf = createNotaFiscal(notaFiscal, u);

        // envia para pagamentos
        processPayments(notaFiscal.getPayments(), nf);

        return "ok";
    }

    private void processPayments(List<PaymentNotaFiscalDTO> payments, NotaFiscal nf) {

        for (PaymentNotaFiscalDTO payment : payments) {

            PaymentMethod py = createPayment(payment);
            createPaymentNotaFiscal(nf, py);

            if (payment.getPaymentMethodId().equals(BOLETO.getId())) {
                billingService.billing(py);
            }
        }
    }

    private void validate(NotaFiscalRequestDTO notaFiscal) {

    }

    private NotaFiscal createNotaFiscal(NotaFiscalRequestDTO notaFiscal, Client u) {
        return notaFiscalRepository.save(NotaFiscal.builder()
                .numberNota(notaFiscal.getIdNotaFiscal())
                .cliente(u).build());

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
