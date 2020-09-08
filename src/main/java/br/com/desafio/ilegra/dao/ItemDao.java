package br.com.desafio.ilegra.dao;

import br.com.desafio.ilegra.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}
