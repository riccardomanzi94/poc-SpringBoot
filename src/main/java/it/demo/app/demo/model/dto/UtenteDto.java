package it.demo.app.demo.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Il nome non può essere vuoto")
    @NotNull(message = "Il nome è obbligatorio")
    private String nome;
    @NotBlank(message = "Il cognome non può essere vuoto")
    @NotNull(message = "Il cognome è obbligatorio")
    private String cognome;
    @Email(message = "Formato email non valido")
    private String email;
}
