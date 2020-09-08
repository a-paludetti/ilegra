package br.com.desafio.ilegra.dao;

import br.com.desafio.ilegra.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchDao extends JpaRepository<Batch, Long> {
}
