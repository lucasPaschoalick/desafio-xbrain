package br.com.xbrain.desafio.controller;

import br.com.xbrain.desafio.controller.dto.CriarVendaRequestDTO;
import br.com.xbrain.desafio.controller.dto.CriarVendaResponseDTO;
import br.com.xbrain.desafio.controller.dto.VendedorDTO;
import br.com.xbrain.desafio.model.Venda;
import br.com.xbrain.desafio.services.VendaService;
import br.com.xbrain.desafio.services.VendedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VendaController {
    private final VendaService vendaService;
    private final VendedorService vendedorService;

    @PostMapping("/venda")
    public ResponseEntity <CriarVendaResponseDTO> criarVenda(@RequestBody @Valid CriarVendaRequestDTO vendaRequestBody) {
        Venda venda = vendaService.saveVenda(vendaRequestBody);

        CriarVendaResponseDTO response = new CriarVendaResponseDTO(venda);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/vendedores")
    public List<VendedorDTO> listarVendedores(
        @RequestParam("dataInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
        @RequestParam("dataFim") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim) {

        return vendedorService.listarVendedores(dataInicio, dataFim);
    }

}
