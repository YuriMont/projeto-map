package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.PagamentoRequestDto;
import com.uepb.reservas.dtos.responses.PagamentoResponseDto;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.PagamentoRepository;
import com.uepb.reservas.repositories.QuartoRepository;
import com.uepb.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    public PagamentoResponseDto createPagamento(PagamentoRequestDto pagamentoRequestDto){
        var reserva = reservaRepository.findById(pagamentoRequestDto.id_reserva()).orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));

        reserva.setDataCheckout(LocalDateTime.now());

        reservaRepository.save(reserva);

        var quarto = quartoRepository.findById(reserva.getQuarto().getId()).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));

        quarto.setStatus(QuartoStatus.DISPONIVEL);

        quartoRepository.save(quarto);

        Pagamento pagamento = repository.save(new Pagamento(pagamentoRequestDto, reserva));

        return new PagamentoResponseDto(pagamento);
    }

    public PagamentoResponseDto findPagamentoById(Long id){
        Pagamento pagamento = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id invalido"));

        return new PagamentoResponseDto(pagamento);
    }

    public PagamentoResponseDto updatePagamentoMetodo(Long id, PagamentoRequestDto pagamentoRequestDto){
        var pagamento = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));

        pagamento.setFormaPagamento(pagamentoRequestDto.formaPagamento());
        pagamento.setReserva(new Reserva(pagamentoRequestDto.id_reserva()));

        repository.save(pagamento);
        return new PagamentoResponseDto(pagamento);
    }

    public void deletePagamentoById(Long id){
        repository.deleteById(id);
    }

    public List<PagamentoResponseDto> findPagamentos(){
        List<Pagamento> pagamentos = repository.findAll();

        return pagamentos.stream().map(item -> new PagamentoResponseDto(item)).toList();
    }
}
