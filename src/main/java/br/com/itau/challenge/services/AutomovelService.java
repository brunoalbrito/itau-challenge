package br.com.itau.challenge.services;

import br.com.itau.challenge.domain.Automovel;
import br.com.itau.challenge.repositories.AutomovelRepository;
import br.com.itau.challenge.repositories.entity.AutomovelEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutomovelService {

    private final AutomovelRepository automovelRepository;

    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public Automovel criaAutomovel(Automovel automovel) {
        AutomovelEntity automovelEntity = automovelRepository.save(AutomovelEntity.from(automovel));

        return automovelRepository.save(automovelEntity).toDomain();
    }

    public List<Automovel> listaAutomoveis() {
        return automovelRepository.findAll()
                .stream()
                .map(AutomovelEntity::toDomain)
                .toList();
    }
}
