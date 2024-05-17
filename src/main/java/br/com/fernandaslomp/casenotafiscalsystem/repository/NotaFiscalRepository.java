package br.com.fernandaslomp.casenotafiscalsystem.repository;

import br.com.fernandaslomp.casenotafiscalsystem.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
}
