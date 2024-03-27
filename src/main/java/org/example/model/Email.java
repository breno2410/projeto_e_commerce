package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email extends BaseModel {
    private String enderecoEmail;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Contato contato;


}
