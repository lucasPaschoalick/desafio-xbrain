package br.com.xbrain.desafio.repository;

import br.com.xbrain.desafio.controller.dto.VendedorDTO;
import br.com.xbrain.desafio.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<Venda, UUID> {

    @Query(value = " SELECT nome_Vendedor AS nomeVendedor, " +
            " COUNT(*) AS numeroVendas, (CAST(COUNT(*) AS FLOAT) / (DATEDIFF('DAY', :dataInicio, :dataFim) + 1)) AS mediaDiaria " +
            "FROM VENDA " +
            "WHERE data_Venda BETWEEN :dataInicio AND :dataFim GROUP BY nomeVendedor ORDER BY numeroVendas DESC ", nativeQuery = true)
    List<VendedorDTO> obterDadosVendedores(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

}
