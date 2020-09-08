package br.com.desafio.ilegra.dao;

import br.com.desafio.ilegra.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SalesmanDao extends JpaRepository<Salesman, String> {
}
