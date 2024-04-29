package br.com.itau.challenge.repositories;

import br.com.itau.challenge.repositories.entity.AutomovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutomovelRepository extends JpaRepository<AutomovelEntity, UUID> {
}
