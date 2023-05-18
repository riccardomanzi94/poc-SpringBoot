package it.demo.app.demo.model.entitites;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ARTICOLO")
@Data
public class Articolo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeArticolo;
    private String descrizione;
    private String prezzo;

}
