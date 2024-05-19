package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import br.com.fernandaslomp.casenotafiscalsystem.service.Kafka.BillingProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BillingService {
    private static final Logger logger = LoggerFactory.getLogger(BillingService.class);
    @Autowired
    private BillingProducer billingProducer;

    private RestClient restClient;

    public void billing(PaymentMethod paymentMethod){

        logger.info("Send to billing process started");

        billingProducer.sendPaymentMethod(paymentMethod);
    }
}
