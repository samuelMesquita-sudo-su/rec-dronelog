package org.example.dronelog.repository;

import org.example.dronelog.model.MissaoVoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MissaoVooRepository extends JpaRepository<MissaoVoo, Long> {

    // TODO: definir as consultas necessárias para acompanhamento das missões.
    Optional<MissaoVoo> findByPilotoIdPiloto(Long idPiloto);
    List<MissaoVoo> findByPilotoNomeEqualsIgnoreCase(String nomePiloto);
    Optional<MissaoVoo> findByDroneIdDrone(Long idDrone);
}
