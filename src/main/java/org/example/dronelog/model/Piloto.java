package org.example.dronelog.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPiloto;

    //TODO: colocar atributos: nome, registroAnac, email, ativo(boolean)
    private String nome;

    private String registroAnac;

    private String email;

    private Boolean ativo;

    // TODO: revisar a ligação com os registros que dependem deste piloto.
    @OneToMany(mappedBy = "piloto")
    private List<MissaoVoo> missoes = new ArrayList<>();

    public Piloto() {
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroAnac() {
        return registroAnac;
    }

    public void setRegistroAnac(String registroAnac) {
        this.registroAnac = registroAnac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<MissaoVoo> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<MissaoVoo> missoes) {
        this.missoes = missoes;
    }
}
