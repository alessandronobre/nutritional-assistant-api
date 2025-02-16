package br.com.example.nutritional_assistant_api.controller;

import br.com.example.nutritional_assistant_api.dto.AlimentoDto;
import br.com.example.nutritional_assistant_api.model.Alimento;
import br.com.example.nutritional_assistant_api.service.AlimentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    private final AlimentoService alimentoService;

    @GetMapping
    public ResponseEntity listar() {
        try {
            List<Alimento> alimentos = alimentoService.listar();
            return ResponseEntity.ok(alimentos);
        } catch (Exception e) {
            log.error("Erro ao listar alimentos", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity bucarPorNome(@PathVariable String nome) {
        try {
            List<Alimento> alimentos = alimentoService.bucarPorNome(nome);
            return ResponseEntity.ok(alimentos);
        } catch (Exception e) {
            log.error("Erro ao buscar alimento com nome - {} ", nome, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody AlimentoDto alimentoDto) {
        try {
            Alimento alimento = alimentoService.cadastrar(alimentoDto);
            return ResponseEntity.status(201).body(alimento.getId());
        } catch (Exception e) {
            log.error("Erro ao cadastrar alimento", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity editar(@RequestBody AlimentoDto alimentoDto) {
        try {
            Alimento alimento = alimentoService.editar(alimentoDto);
            return ResponseEntity.ok(alimento);
        } catch (Exception e) {
            log.error("Erro ao editar alimento", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        try {
            alimentoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Erro ao deletar alimento", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
