package it.demo.app.demo.model.dto;

import lombok.Data;

@Data
public class ArticoloDto {

    private static final long serialVersionUID = 1L;

    private String nomeArticolo;
    private String descrizione;
    private String prezzo;
}
