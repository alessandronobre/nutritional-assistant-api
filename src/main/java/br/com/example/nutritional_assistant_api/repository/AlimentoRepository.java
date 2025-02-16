package br.com.example.nutritional_assistant_api.repository;

import br.com.example.nutritional_assistant_api.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

    @Query(value = "SELECT * FROM ALIMENTO WHERE NOME LIKE CONCAT('%', :nome, '%') ORDER BY NOME DESC", nativeQuery = true)
    List<Alimento> bucarPorNome(@Param("nome") String nome);
}
