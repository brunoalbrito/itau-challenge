package br.com.itau.challenge.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record Automovel(
        UUID id,
        String marca,
        String modelo,
        BigDecimal valor,
        Date createdAt
) {
    public Automovel(String marca, String modelo, BigDecimal valor) {
        this(null, marca, modelo, valor, null);
    }
}
