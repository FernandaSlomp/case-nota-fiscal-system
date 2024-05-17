package br.com.fernandaslomp.casenotafiscalsystem.service;

import br.com.fernandaslomp.casenotafiscalsystem.dto.NotaFiscalRequestDTO;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BillingService {

    private RestClient restClient;

    public void billing(PaymentMethod paymentMethod){

    }
}
