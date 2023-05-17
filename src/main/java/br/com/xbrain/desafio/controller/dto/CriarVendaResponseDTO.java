package br.com.xbrain.desafio.controller.dto;

import br.com.xbrain.desafio.model.Venda;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CriarVendaResponseDTO {

    public CriarVendaResponseDTO(Venda venda){
        this.id = venda.getId();
        this.idVendedor = venda.getIdVendedor();
        this.nomeVendedor = venda.getNomeVendedor();
        this.valor = venda.getValor();
        this.dataVenda = venda.getDataVenda();
    }

    @JsonProperty("id")
    public UUID id;

    @JsonProperty("id_vendedor")
    public String idVendedor;

    @JsonProperty("nome_vendedor")
    public String nomeVendedor;

    @JsonProperty("valor")
    public double valor;

    @JsonProperty("data_venda")
    public LocalDate dataVenda;
}
