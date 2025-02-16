package br.com.example.nutritional_assistant_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @OneToOne(mappedBy = "alimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private InformacaoNutricional informacaoNutricional;
}
