package br.com.xbrain.desafio.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "idVendedor")
    private String idVendedor;

    @Column(name = "nomeVendedor")
    private String nomeVendedor;

    @Column(name = "valor")
    private double valor;

    @Column(name = "dataVenda")
    private LocalDate dataVenda;
}
