package org.example.dronelog.service;

import org.example.dronelog.dto.MissaoVooRequestDTO;
import org.example.dronelog.dto.MissaoVooResponseDTO;
import org.example.dronelog.exception.RecursoNaoEncontradoException;
import org.example.dronelog.model.MissaoVoo;
import org.example.dronelog.model.StatusMissao;
import org.example.dronelog.repository.MissaoVooRepository;
import org.example.dronelog.service.PilotoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MissaoVooService {

    //TODO: completar ou alterar.
    private final MissaoVooRepository missaoVooRepository;
    private final PilotoService pilotoService;
    private final DroneService droneService;


    public MissaoVooService(MissaoVooRepository missaoVooRepository, PilotoService pilotoService, DroneService droneService) {
        this.missaoVooRepository = missaoVooRepository;
        this.pilotoService = pilotoService;
        this.droneService = droneService;
    }

    public List<MissaoVooResponseDTO> listar(StatusMissao status, String localOperacao, LocalDate dataPrevista) {
        // TODO: construir a listagem e os filtros necessários.
        if (status != null){
            return buscarStatus(status);
        } else if (localOperacao != null) {
            return buscarLocalOperacao(localOperacao);
        } else if (dataPrevista != null) {
            return buscarDataPrevista(dataPrevista);
        }else {
            return missaoVooRepository.findAll().stream().map(this::toResponse).toList();
        }
    }

    public List<MissaoVooResponseDTO> buscarStatus(StatusMissao status){
        return missaoVooRepository.findByStatus(status).stream().map(this::toResponse).toList();
    }

    public List<MissaoVooResponseDTO> buscarLocalOperacao(String localOperacao){
        return missaoVooRepository.findByLocalOperacao(localOperacao).stream().map(this::toResponse).toList();
    }

    public List<MissaoVooResponseDTO> buscarDataPrevista(LocalDate dataPrevista){
        return missaoVooRepository.findByDataPrevista(dataPrevista).stream().map(this::toResponse).toList();
    }

    public MissaoVooResponseDTO buscarPorId(Long id) {
        MissaoVoo missao = buscarMissao(id);
        return toResponse(missao);
    }

    public MissaoVooResponseDTO cadastrar(MissaoVooRequestDTO dto) {
        // TODO: montar a entidade, preencher dados simples e resolver vínculos. - FEITO, eu acho

        MissaoVoo missaoVoo = new MissaoVoo();
        missaoVoo.setTitulo(dto.titulo());
        missaoVoo.setLocalOperacao(dto.localOperacao());
        missaoVoo.setDataPrevista(dto.dataPrevista());
        missaoVoo.setAreaMapeadaKm2(dto.areaMapeadaKm2());
        missaoVoo.setStatus(dto.status());
        missaoVoo.setPiloto(pilotoService.buscarPiloto(dto.idPiloto()));
        missaoVoo.setDrone(droneService.buscarDrone(dto.idDrone()));

        MissaoVoo salvo = missaoVooRepository.save(missaoVoo);
        return toResponse(salvo);
    }

    public MissaoVooResponseDTO atualizar(Long id, MissaoVooRequestDTO dto) {
        // TODO: recuperar o registro existente e aplicar alterações permitidas.
        MissaoVoo missaoVoo = buscarMissao(id);
        missaoVoo.setIdMissao(id);
        missaoVoo.setTitulo(dto.titulo());
        missaoVoo.setLocalOperacao(dto.localOperacao());
        missaoVoo.setDataPrevista(dto.dataPrevista());
        missaoVoo.setAreaMapeadaKm2(dto.areaMapeadaKm2());
        missaoVoo.setStatus(dto.status());
        missaoVoo.setPiloto(pilotoService.buscarPiloto(dto.idPiloto()));
        missaoVoo.setDrone(droneService.buscarDrone(dto.idDrone()));

        MissaoVoo atualizado = missaoVooRepository.save(missaoVoo);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        MissaoVoo missaoVoo = buscarMissao(id);
        missaoVooRepository.delete(missaoVoo);
    }

    private MissaoVoo buscarMissao(Long id) {
        return missaoVooRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Missão de voo não encontrada."));
    }

    private MissaoVooResponseDTO toResponse(MissaoVoo missao) {
        // TODO: transformar a entidade em resposta sem expor objetos inteiros.
        return new MissaoVooResponseDTO(
                missao.getIdMissao(),
                missao.getTitulo(),
                missao.getLocalOperacao(),
                missao.getDataPrevista(),
                missao.getAreaMapeadaKm2(),
                missao.getStatus(),
                missao.getPiloto().getIdPiloto(),
                missao.getPiloto().getNome(),
                missao.getDrone().getIdDrone(),
                missao.getDrone().getIdentificador()
        );
    }
}
