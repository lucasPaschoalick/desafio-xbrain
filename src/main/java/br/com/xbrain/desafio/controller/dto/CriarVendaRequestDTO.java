package br.com.xbrain.desafio.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CriarVendaRequestDTO {

    @NotNull
    @JsonProperty("id_vendedor")
    @NotBlank(message = "id_vendedor must not be blank!!")
    public String idVendedor;

    @NotNull
    @JsonProperty("nome_vendedor")
    @NotBlank(message = "nome_vendedor must not be blank!!")
    public String nomeVendedor;

    @NotNull(message = "valor must not be null!!")
    @JsonProperty("valor")
    @Positive(message = "valor must be greater than 0")
    public double valor;

    @NotNull
    @JsonProperty("data_venda")
    public LocalDate dataVenda;

}
