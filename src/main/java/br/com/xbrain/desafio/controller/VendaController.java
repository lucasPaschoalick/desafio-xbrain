package br.com.xbrain.desafio.controller;

import br.com.xbrain.desafio.controller.dto.CriarVendaRequestDTO;
import br.com.xbrain.desafio.controller.dto.CriarVendaResponseDTO;
import br.com.xbrain.desafio.model.Venda;
import br.com.xbrain.desafio.services.VendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VendaController {
    private final VendaService vendaService;
    @PostMapping("/venda")
    public CriarVendaResponseDTO criarVenda(@RequestBody @Valid CriarVendaRequestDTO vendaRequestBody) {
        Venda venda = vendaService.saveVenda(vendaRequestBody);

        CriarVendaResponseDTO response = new CriarVendaResponseDTO(venda);

        return response;
    }
}
