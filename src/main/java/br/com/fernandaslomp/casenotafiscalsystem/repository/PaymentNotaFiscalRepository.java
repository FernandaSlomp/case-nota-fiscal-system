package br.com.fernandaslomp.casenotafiscalsystem.repository;

import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentNotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentNotaFiscalRepository extends JpaRepository<PaymentNotaFiscal, Long> {
}
