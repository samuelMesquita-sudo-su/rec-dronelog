package org.example.dronelog.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrone;

    private String identificador;

    private String modelo;

    private Integer autonomiaMinutos;

    private Boolean disponivel;

    // TODO: ajustar o lado adequado para histórico de missões
    @OneToMany(mappedBy = "drone")
    private List<MissaoVoo> missoes = new ArrayList<>();

    public Drone() {
    }

    public Long getIdDrone() {
        return idDrone;
    }

    public void setIdDrone(Long idDrone) {
        this.idDrone = idDrone;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAutonomiaMinutos() {
        return autonomiaMinutos;
    }

    public void setAutonomiaMinutos(Integer autonomiaMinutos) {
        this.autonomiaMinutos = autonomiaMinutos;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<MissaoVoo> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<MissaoVoo> missoes) {
        this.missoes = missoes;
    }
}
