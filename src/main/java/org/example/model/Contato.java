package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contato extends BaseModel {
    private LocalDateTime dateInicio;
    private LocalDateTime dataFim;
    private Pessoa pessoa;
    private List<Email> emailList;

}
