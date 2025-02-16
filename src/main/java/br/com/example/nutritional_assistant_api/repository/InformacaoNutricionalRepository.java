package br.com.example.nutritional_assistant_api.repository;

import br.com.example.nutritional_assistant_api.model.Alimento;
import br.com.example.nutritional_assistant_api.model.InformacaoNutricional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacaoNutricionalRepository extends JpaRepository<InformacaoNutricional, Long> {

}
