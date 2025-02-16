package br.com.example.nutritional_assistant_api.dto;

import br.com.example.nutritional_assistant_api.model.InformacaoNutricional;
import lombok.Data;

@Data
public class AlimentoDto {

    private Long id;
    private String nome;
    private String marca;
    private InformacaoNutricional informacaoNutricional;
}
