package br.com.example.nutritional_assistant_api.model;

import br.com.example.nutritional_assistant_api.enums.UnidadeMedida;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class InformacaoNutricional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadeMedida unidadeMedida;

    @Column(nullable = false)
    private Integer calorias;

    @Column(nullable = false)
    private Double carboidrato;

    @Column(nullable = false)
    private Double proteina;

    @Column(nullable = false)
    private Double gorduraTotal;

    @Column(nullable = false)
    private Double gorduraSaturada;

    @Column(nullable = false)
    private Double gorduraTrans;

    @Column(nullable = false)
    private Double fibras;

    @Column(nullable = false)
    private Double sodio;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="alimento_id", nullable = false)
    private Alimento alimento;
}
