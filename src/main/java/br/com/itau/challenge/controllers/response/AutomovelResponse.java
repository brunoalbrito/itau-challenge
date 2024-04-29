package br.com.itau.challenge.controllers.response;

import br.com.itau.challenge.domain.Automovel;

import java.util.Date;
import java.util.UUID;

public record AutomovelResponse(
        UUID id,
        String marca,
        String modelo,
        Date createdAt
) {
    public static AutomovelResponse fromDomain(Automovel automovel) {
        return new AutomovelResponse(automovel.id(), automovel.marca(), automovel.modelo(), automovel.createdAt());
    }
}
