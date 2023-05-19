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
public class ErrorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
}
