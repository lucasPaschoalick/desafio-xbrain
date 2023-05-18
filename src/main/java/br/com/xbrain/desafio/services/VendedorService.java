package br.com.xbrain.desafio.services;

import br.com.xbrain.desafio.controller.dto.VendedorDTO;
import br.com.xbrain.desafio.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    public List<VendedorDTO> listarVendedores(LocalDate dataInicio, LocalDate dataFim){
        return vendedorRepository.obterDadosVendedores(dataInicio, dataFim);
    }
}
