package br.com.itau.challenge.repositories.entity;

import br.com.itau.challenge.domain.Automovel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "automoveis")
public class AutomovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String marca;
    private String modelo;
    private BigDecimal valor;
    private Date createdAt;

    public AutomovelEntity() {
    }

    public AutomovelEntity(String marca, String modelo, BigDecimal valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.createdAt = new Date();
    }

    public static AutomovelEntity from(Automovel automovel) {
        return new AutomovelEntity(automovel.marca(), automovel.modelo(), automovel.valor());
    }

    public Automovel toDomain() {
        return new Automovel(this.id, this.marca, this.modelo, this.valor, this.createdAt);
    }
}
