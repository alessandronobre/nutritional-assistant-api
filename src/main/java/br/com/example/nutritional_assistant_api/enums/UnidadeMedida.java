package br.com.example.nutritional_assistant_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnidadeMedida {

    ML("mililitro"),
    G("gramas");

    private final String discricao;
}
