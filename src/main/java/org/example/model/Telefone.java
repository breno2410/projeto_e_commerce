package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Telefone extends BaseModel {
    private String ddd;
    private String numero;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Contato contato;
}
