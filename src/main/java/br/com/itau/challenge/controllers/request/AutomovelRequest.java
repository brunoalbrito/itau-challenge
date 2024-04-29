package br.com.itau.challenge.controllers.request;

import br.com.itau.challenge.domain.Automovel;

import java.math.BigDecimal;

public record AutomovelRequest(
        String marca,
        String modelo,
        BigDecimal valor
) {
    public Automovel toDomain() {
        return new Automovel(marca, modelo, valor);
    }
}
