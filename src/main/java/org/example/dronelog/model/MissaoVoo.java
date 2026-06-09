package org.example.dronelog.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MissaoVoo {

    //TODO: garantir integridade de PK para os registros da entidade.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMissao;

    private String titulo;

    private String localOperacao;

    private LocalDate dataPrevista;

    private Double areaMapeadaKm2;

    @Enumerated(EnumType.STRING)
    private StatusMissao status;

    // TODO: relacionar corretamente com o responsável pela operação.
    @ManyToOne
    @JoinColumn(name = "missaoVoo")
    private Piloto piloto;

    // TODO: relacionar corretamente com o equipamento/drone utilizado.
    @ManyToOne
    private Drone drone;

    public MissaoVoo() {
    }

    // TODO: completar os métodos de acesso necessários para uso nas camadas da API.

    public Long getIdMissao() {
        return idMissao;
    }

    public void setIdMissao(Long idMissao) {
        this.idMissao = idMissao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalOperacao() {
        return localOperacao;
    }

    public void setLocalOperacao(String localOperacao) {
        this.localOperacao = localOperacao;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Double getAreaMapeadaKm2() {
        return areaMapeadaKm2;
    }

    public void setAreaMapeadaKm2(Double areaMapeadaKm2) {
        this.areaMapeadaKm2 = areaMapeadaKm2;
    }

    public StatusMissao getStatus() {
        return status;
    }

    public void setStatus(StatusMissao status) {
        this.status = status;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
