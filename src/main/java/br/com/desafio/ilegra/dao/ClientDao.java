package br.com.desafio.ilegra.dao;

import br.com.desafio.ilegra.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client,String> {

    Client findByName(String name);

    Client findByCnpj(String cnpj);
}
