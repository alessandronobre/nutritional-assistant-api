package br.com.example.nutritional_assistant_api.service;

import br.com.example.nutritional_assistant_api.dto.AlimentoDto;
import br.com.example.nutritional_assistant_api.model.Alimento;
import br.com.example.nutritional_assistant_api.model.InformacaoNutricional;
import br.com.example.nutritional_assistant_api.repository.AlimentoRepository;
import br.com.example.nutritional_assistant_api.repository.InformacaoNutricionalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final InformacaoNutricionalRepository informacaoNutricionalRepository;

    public List<Alimento> bucarPorNome(String nome) {
        return alimentoRepository.bucarPorNome(nome);
    }

    public List<Alimento> listar() {
        return alimentoRepository.findAll();
    }

    @Transactional
    public Alimento cadastrar(AlimentoDto alimentoDto) {
        Alimento alimento = new Alimento();
        alimento.setNome(alimentoDto.getNome());
        alimento.setMarca(alimentoDto.getMarca());
        alimentoRepository.save(alimento);

        InformacaoNutricional informacaoNutricional = new InformacaoNutricional();
        informacaoNutricional.setQuantidade(alimentoDto.getInformacaoNutricional().getQuantidade());
        informacaoNutricional.setUnidadeMedida(alimentoDto.getInformacaoNutricional().getUnidadeMedida());
        informacaoNutricional.setCalorias(alimentoDto.getInformacaoNutricional().getCalorias());
        informacaoNutricional.setCarboidrato(alimentoDto.getInformacaoNutricional().getCarboidrato());
        informacaoNutricional.setProteina(alimentoDto.getInformacaoNutricional().getProteina());
        informacaoNutricional.setGorduraTotal(alimentoDto.getInformacaoNutricional().getGorduraTotal());
        informacaoNutricional.setGorduraSaturada(alimentoDto.getInformacaoNutricional().getGorduraSaturada());
        informacaoNutricional.setGorduraTrans(alimentoDto.getInformacaoNutricional().getGorduraTrans());
        informacaoNutricional.setFibras(alimentoDto.getInformacaoNutricional().getFibras());
        informacaoNutricional.setSodio(alimentoDto.getInformacaoNutricional().getSodio());
        informacaoNutricional.setAlimento(alimento);
        informacaoNutricionalRepository.save(informacaoNutricional);

        alimento.setInformacaoNutricional(informacaoNutricional);
        return alimentoRepository.save(alimento);
    }

    public Alimento editar(AlimentoDto alimentoDto) {
        Optional<Alimento> alimento = alimentoRepository.findById(alimentoDto.getId());
        alimento.get().setNome(alimentoDto.getNome());
        alimento.get().setMarca(alimentoDto.getMarca());
        alimento.get().setInformacaoNutricional(alimentoDto.getInformacaoNutricional());
        return alimentoRepository.save(alimento.get());

    }

    public void deletar(Long id) {
        alimentoRepository.deleteById(id);
    }
}