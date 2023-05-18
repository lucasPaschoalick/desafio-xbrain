package br.com.xbrain.desafio.services;

import br.com.xbrain.desafio.controller.dto.CriarVendaRequestDTO;
import br.com.xbrain.desafio.model.Venda;
import br.com.xbrain.desafio.repository.VendaRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class VendaServiceUTest {
    private static VendaService vendaService;
    private static VendaRepository vendaRepository;

    @BeforeAll
    public static void setUp(){
        vendaRepository = Mockito.mock(VendaRepository.class);

        vendaService = new VendaService(vendaRepository);
    }

    @Test
    void saveVenda() {
        LocalDate date = LocalDate.now();

        Venda expect = new Venda(UUID.randomUUID(), "1", "Lucas", 15.30, date);

        Mockito.when(vendaRepository.save(any())).thenReturn(expect);

        CriarVendaRequestDTO vendaRequestDTO = new CriarVendaRequestDTO("1", "Lucas", 15.30, date);

        Venda result = vendaService.saveVenda(vendaRequestDTO);

        Assertions.assertEquals(result.getIdVendedor(), expect.getIdVendedor());
        Assertions.assertEquals(result.getNomeVendedor(), expect.getNomeVendedor());
        Assertions.assertEquals(result.getValor(), expect.getValor());
        Assertions.assertEquals(result.getDataVenda(), expect.getDataVenda());
    }

    @Test
    void saveVendaError() {

        Mockito.when(vendaRepository.save(any())).thenThrow(RuntimeException.class);

        CriarVendaRequestDTO vendaRequestDTO = new CriarVendaRequestDTO("1", "Lucas", 15.30, LocalDate.now());

        Assertions.assertThrows(RuntimeException.class, ()->vendaService.saveVenda(vendaRequestDTO));
    }

}