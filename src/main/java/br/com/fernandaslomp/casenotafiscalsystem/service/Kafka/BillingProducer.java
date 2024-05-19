package br.com.fernandaslomp.casenotafiscalsystem.service.Kafka;

import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import jakarta.transaction.Transaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingProducer {

    private final KafkaTemplate<String, PaymentMethod> kafkaTemplate;

    public BillingProducer(KafkaTemplate<String, PaymentMethod> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentMethod(PaymentMethod payment) {

        kafkaTemplate.send("payment", payment);
    }
}
