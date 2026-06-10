package org.example.dronelog.service;

import org.example.dronelog.dto.PilotoRequestDTO;
import org.example.dronelog.dto.PilotoResponseDTO;
import org.example.dronelog.exception.RecursoNaoEncontradoException;
import org.example.dronelog.model.Piloto;
import org.example.dronelog.repository.PilotoRepository;
import org.hibernate.type.descriptor.sql.internal.NativeOrdinalEnumDdlTypeImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    //TODO: colocar construtor para chamar métodos. - FEITO
    private final PilotoRepository pilotoRepository;

    public PilotoService(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    public List<PilotoResponseDTO> listar(String nome) {
        // TODO: usar o parâmetro recebido quando fizer sentido.
        List<Piloto> pilotos;

        if (nome != null)
        {
            pilotos = pilotoRepository.findByNomeEqualsIgnoreCase(nome);

        }
        else
        {
            pilotos = pilotoRepository.findAll();
        }

        return pilotos.stream().map(this::toResponse).toList();
    }

    public PilotoResponseDTO buscarPorId(Long id) {
        Piloto piloto = buscarPiloto(id);
        return toResponse(piloto);
    }

    public PilotoResponseDTO cadastrar(PilotoRequestDTO dto) {
        Piloto piloto = new Piloto();
        piloto.setNome(dto.nome());
        piloto.setRegistroAnac(dto.registroAnac());
        piloto.setEmail(dto.email());
        piloto.setAtivo(dto.ativo());

        // TODO: transportar os dados recebidos para a entidade.

        return toResponse(pilotoRepository.save(piloto));
    }

    public PilotoResponseDTO atualizar(Long id, PilotoRequestDTO dto) {
        Piloto piloto = buscarPiloto(id);
        piloto.setNome(dto.nome());
        piloto.setRegistroAnac(dto.registroAnac());
        piloto.setEmail(dto.email());
        piloto.setAtivo(dto.ativo());
        // TODO: atualizar os campos corretos sem criar outro registro.
        Piloto atualizado = pilotoRepository.save(piloto);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        Piloto piloto = buscarPiloto(id);

        // TODO: decidir como tratar pilotos com missões vinculadas.
        pilotoRepository.delete(piloto);
    }

    public Piloto buscarPiloto(Long id) {
        return pilotoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("ID nao encontrado"));
    }

    private PilotoResponseDTO toResponse(Piloto piloto) {
        // TODO: montar o DTO de saída com os dados necessários. - FEITO
        return new PilotoResponseDTO(
                piloto.getIdPiloto(),
                piloto.getNome(),
                piloto.getRegistroAnac(),
                piloto.getEmail(),
                piloto.getAtivo()
        );
    }
}
