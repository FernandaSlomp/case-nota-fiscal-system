package br.com.fernandaslomp.casenotafiscalsystem.repository;

import br.com.fernandaslomp.casenotafiscalsystem.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
