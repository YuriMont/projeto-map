package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.enums.FormaPagamento;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.enums.QuartoTipo;
import com.uepb.reservas.enums.ReservaStatus;
import com.uepb.reservas.menus.MenuService;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.models.Reserva;
import com.uepb.reservas.repositories.HospedeRepository;
import com.uepb.reservas.repositories.QuartoRepository;
import com.uepb.reservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Service
public class ReservaService {
    private final HospedeRepository hospedeRepository;
    private final QuartoRepository quartoRepository;
    private final ReservaRepository reservaRepository;

    public ReservaService(HospedeRepository hospedeRepository, QuartoRepository quartoRepository, ReservaRepository reservaRepository) {
        this.hospedeRepository = hospedeRepository;
        this.quartoRepository = quartoRepository;
        this.reservaRepository = reservaRepository;
    }

    @Autowired
    private ReservaRepository repository;

    public Reserva createReserva(ReservaRequestDto reservaRequestDto){
        return repository.save(new Reserva(reservaRequestDto));
    }

    public Optional<Reserva> findReservaById(Long id){
        return repository.findById(id);
    }

    public Reserva updateReserva(Long id, ReservaRequestDto reservaRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Reserva(id, reservaRequestDto));
    }

    public void deleteReservaById(Long id){
        repository.deleteById(id);
    }

    public List<Reserva> findReserva(){
        return repository.findAll();
    }

    public Reserva fazerReserva(ReservaRequestDto request) throws Exception {
        Hospede hospede = hospedeRepository.findById(request.id_hospede()).orElseThrow(() -> new Exception("Hóspede não encontrado"));

        Date checkIn = request.dataCheckin();
        Date checkOut = request.dataCheckout();

        List<Quarto> quartosDisponiveis = quartoRepository.findDisponiveisPorTipo(request.id_quarto(), checkIn, checkOut);

        if (quartosDisponiveis.isEmpty()) {
            throw new Exception("Nenhum quarto disponível para essa data.");
        }

        Quarto quartoEscolhido = quartosDisponiveis.get(0);
        quartoEscolhido.setStatus(QuartoStatus.OCUPADO);
        quartoRepository.save(quartoEscolhido);

        Pagamento pagamento = new Pagamento();
        pagamento.setValorPago(quartoEscolhido.getPrecoDiaria());
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(pagamento);

        Reserva reserva = new Reserva(checkIn, checkOut, hospede, quartoEscolhido, ReservaStatus.CONFIRMADA, pagamentos);

        return reservaRepository.save(reserva);
    }

    public boolean validarCheck(Reserva reserva){
        if(reserva.getDataCheckin() != null && reserva.getDataCheckout() != null){
            return true;
        }
        return false;
    }

    public boolean verificarCapacidadeQuarto(Quarto quarto, int quantHosp){
        if(quarto.getCapacidade() < quantHosp){
            System.out.println("Quantidade de hospedes excedida");
            return true;
        }
        return false;
    }

    public void cancelamentoReserva(Reserva reserva){
        Date hoje = new Date(20/05/2025);
        Date checkin = reserva.getDataCheckin();

        long diferenca = checkin.getTime() - hoje.getTime();
        long diferencaDias = TimeUnit.MILLISECONDS.toDays(diferenca);

        Double taxa = 0.0;
        if(diferencaDias >= 2){
            taxa = reserva.getQuarto().getPrecoDiaria() * 0.25;
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setValorPago(taxa);
        reserva.getPagamentos().add(pagamento);
        
        reserva.setStatus(ReservaStatus.CANCELADA);
        reservaRepository.save(reserva);
    }

    public void calcularValorDaReserva(){

    }
}