package br.com.desafio.ilegra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Batch {

    @Id
    @GeneratedValue
    private long id;

    private int clients;

    private int salesMen;

    private long salesId;

    private String badSeller;
}
