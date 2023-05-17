package br.com.xbrain.desafio.services;

import br.com.xbrain.desafio.controller.dto.CriarVendaRequestDTO;
import br.com.xbrain.desafio.model.Venda;
import br.com.xbrain.desafio.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public Venda saveVenda(CriarVendaRequestDTO vendaRequestBody) {
        Venda venda = getVenda();

        requestToModel(vendaRequestBody, venda);

        return vendaRepository.save(venda);
    }

    private static void requestToModel(CriarVendaRequestDTO vendaRequestBody, Venda venda) {
        venda.setIdVendedor(vendaRequestBody.getIdVendedor());
        venda.setNomeVendedor(vendaRequestBody.getNomeVendedor());
        venda.setValor(vendaRequestBody.getValor());
        venda.setDataVenda(vendaRequestBody.getDataVenda());
    }

    private static Venda getVenda() {
        Venda venda = new Venda();
        return venda;
    }

}
