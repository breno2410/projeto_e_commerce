package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa extends BaseModel {
    private String nome = "";
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    public List<Contato> Contatos;

}
