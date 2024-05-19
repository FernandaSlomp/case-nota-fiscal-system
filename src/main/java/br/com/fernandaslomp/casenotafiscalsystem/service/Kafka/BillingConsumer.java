package br.com.fernandaslomp.casenotafiscalsystem.service.Kafka;

import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import br.com.fernandaslomp.casenotafiscalsystem.exception.PaymentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BillingConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BillingConsumer.class);
    private RestClient restClient;

    public BillingConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://localhost:8080/api/mock/boleto")
                .build();
    }

    @KafkaListener(topics = "payment", groupId = "alpe")
    public void receivePaymentMethod(PaymentMethod payment) {

        logger.info("ReceivePaymentMethod process started");

        var response = restClient.post().contentType(MediaType.APPLICATION_JSON).body(payment).retrieve().toEntity(String.class);

        if (response.getStatusCode().isError())
            throw new PaymentException("Error while sending payment " + payment.getId());
    }
}
