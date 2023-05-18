package it.demo.app.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto implements Serializable {

    private static final long serialVersionUID = -816779095453705306L;

    private String nome;
    private String cognome;
    private String email;
}
