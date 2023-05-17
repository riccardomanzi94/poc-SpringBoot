package it.demo.app.demo.model.entitites;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "UTENTE")
public class Utente implements Serializable {

    private static final long serialVersionUID = 2064186447521586842L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private String email;

}
