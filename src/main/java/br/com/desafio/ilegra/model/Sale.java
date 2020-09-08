package br.com.desafio.ilegra.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sale {

    @Id
    private Long id;

    private String itens;

    private String sellerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
