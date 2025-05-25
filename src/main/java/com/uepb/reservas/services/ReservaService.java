package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.dtos.responses.ReservaResponseDto;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoReposiroty;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Transactional
    public ReservaResponseDto createReserva(ReservaRequestDto reservaRequestDto){
        Optional<Quarto> quarto = quartoReposiroty.findById(reservaRequestDto.id_quarto());

        Optional<Hospede> hospede = hospedeRepository.findById(reservaRequestDto.id_hospede());

        if(quarto.isEmpty() || hospede.isEmpty()){
            throw new IllegalArgumentException("Informações invalidas");
        }

        if(quarto.get().getStatus() != QuartoStatus.DISPONIVEL || reservaRequestDto.dataCheckin().isAfter(reservaRequestDto.dataCheckout())){
            throw new IllegalArgumentException("Quarto inválido");
        }

        quarto.get().setStatus(QuartoStatus.OCUPADO);

        quartoReposiroty.save(quarto.get());

        Reserva reserva = reservaRepository.save(new Reserva(reservaRequestDto));
        return new ReservaResponseDto(reserva);
    }

    @Transactional
    public ReservaResponseDto findReservaById(Long id){
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id Invalido"));

        return new ReservaResponseDto(reserva);
    }

    @Transactional
    public ReservaResponseDto updateReserva(Long id, ReservaRequestDto reservaRequestDto){
        if(!reservaRepository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        Reserva reserva = reservaRepository.save(new Reserva(id, reservaRequestDto));
        return new ReservaResponseDto(reserva);
    }

    @Transactional
    public void deleteReservaById(Long id){
        reservaRepository.deleteById(id);
    }

    public List<ReservaResponseDto> findReservas(){
        List<Reserva> reservas = reservaRepository.findAll();

        return reservas.stream().map(item -> new ReservaResponseDto(item)).toList();
    }

    @Transactional
    public ReservaResponseDto addServico(Long reservaId, Long servicoId){
        var reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        var servico = servicoRepository.findById(servicoId).orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));

        reserva.getServicos().add(servico);

        return new ReservaResponseDto(reservaRepository.save(reserva));
    }

    @Transactional
    public ReservaResponseDto addConsumo(Long reservaId, Long consumoId){
        var reserva = reservaRepository.findById(reservaId).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        var consumo = consumoRepository.findById(consumoId).orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));

        reserva.getConsumos().add(consumo);

        return new ReservaResponseDto(reservaRepository.save(reserva));
    }
}