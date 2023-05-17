package it.demo.app.demo.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UtenteDto implements Serializable {


    private static final long serialVersionUID = -816779095453705306L;

    private String nome;
    private String cognome;
    private String email;
}
