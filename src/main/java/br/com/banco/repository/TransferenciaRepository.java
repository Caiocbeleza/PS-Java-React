package br.com.banco.repository;

import br.com.banco.DTO.TransferenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Transferencia;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.nomeOperador LIKE %?1%")
    public List<TransferenciaDTO> search(String nomeOperador);

    @Query("SELECT t FROM Transferencia t WHERE t.dt >= :inicio AND t.dt <= :fim")
    public List<TransferenciaDTO> procurarPorData(LocalDate inicio, LocalDate fim);

}
