package br.com.desafio.ilegra.dao;

import br.com.desafio.ilegra.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDao extends JpaRepository<Sale, Long> {
}
