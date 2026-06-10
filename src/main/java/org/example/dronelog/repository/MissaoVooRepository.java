package org.example.dronelog.repository;

import org.example.dronelog.model.MissaoVoo;
import org.example.dronelog.model.StatusMissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MissaoVooRepository extends JpaRepository<MissaoVoo, Long> {

    // TODO: definir as consultas necessárias para acompanhamento das missões.
    List<MissaoVoo> findByStatus(StatusMissao statusMissao);
    List<MissaoVoo> findByLocalOperacao (String localOperacao);
    List<MissaoVoo> findByDataPrevista(LocalDate dataPrevista);


    Optional<MissaoVoo> findByPilotoIdPiloto(Long idPiloto);
    List<MissaoVoo> findByPilotoNomeEqualsIgnoreCase(String nomePiloto);

    Optional<MissaoVoo> findByDroneIdDrone(Long idDrone);
    List<MissaoVoo> findByDroneIdentificador(String droneIdentificador);
}
