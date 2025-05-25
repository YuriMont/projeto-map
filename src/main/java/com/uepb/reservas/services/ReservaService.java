package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.ReservaRequestDto;
import com.uepb.reservas.enums.FormaPagamento;
import com.uepb.reservas.enums.QuartoStatus;
import com.uepb.reservas.enums.QuartoTipo;
import com.uepb.reservas.enums.ReservaStatus;
import com.uepb.reservas.menus.Menu;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.models.Hotel;
import com.uepb.reservas.models.Pagamento;
import com.uepb.reservas.models.Quarto;
import com.uepb.reservas.models.Reserva;
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

@Service
public class ReservaService {
    private Scanner i = new Scanner(System.in);
    private Scanner s = new Scanner(System.in);
    private Hotel hotel = new Hotel();

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

    private boolean verificarQuantidadeHospedes(int quarto, int quantHosp){
        if((quarto == 1 && quantHosp > 1) || (quarto == 2 && quantHosp > 2) || (quarto == 3 && quantHosp > 4)){
            System.out.println("Quantidade excedente.");
            return false;
        }
        return true;
    }

    private Quarto verificarDisponibilidade(List<Quarto> quartos, List<Date> inOut, int tipoQuartoEscolhido){

        Date checkin = inOut.get(0);

        if(tipoQuartoEscolhido == 1){
            for (Quarto quarto : quartos) {
                if((quarto.getTipo() == QuartoTipo.SOLTEIRO) && (quarto.getStatus() == QuartoStatus.DISPONIVEL)){
                    List<Reserva> reservas = quarto.getReservas();
                    for (Reserva reserva : reservas) {
                        if((reserva.getDataCheckin() != checkin) && (checkin.before(reserva.getDataCheckout()))){
                            return quarto;
                        }
                    }
                }
            }
        }
        
        if(tipoQuartoEscolhido == 2){
            for (Quarto quarto : quartos) {
                if((quarto.getTipo() == QuartoTipo.CASAL) && (quarto.getStatus() == QuartoStatus.DISPONIVEL)){
                    List<Reserva> reservas = quarto.getReservas();
                    for (Reserva reserva : reservas) {
                        if((reserva.getDataCheckin() != checkin) && (checkin.before(reserva.getDataCheckout()))){
                            return quarto;
                        }
                    }
                }
            }
        }
        
        if(tipoQuartoEscolhido == 3){
            for (Quarto quarto : quartos) {
                if((quarto.getTipo() == QuartoTipo.LUXO) && (quarto.getStatus() == QuartoStatus.DISPONIVEL)){
                    List<Reserva> reservas = quarto.getReservas();
                    for (Reserva reserva : reservas) {
                        if((reserva.getDataCheckin() != checkin) && (checkin.before(reserva.getDataCheckout()))){
                            return quarto;
                        }
                    }
                }
            }
        }
        return null;    
    }
    
    private List<Date> dataCheckAllReserva() throws ParseException{
        List<Date> datasInOut = new ArrayList<>();
        
        System.out.println("Data de check-in: (dd/mm/aaaa)");
        String checkin = s.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCheckin = formatter.parse(checkin);
        
        System.out.println("Data de check-out: (dd/mm/aaaa)");
        String checkout = s.nextLine();
        Date dataCheckout = formatter.parse(checkout);
        
        datasInOut.add(dataCheckin);
        datasInOut.add(dataCheckout);
        return datasInOut;
    }

    private Pagamento conversaoPagamento(int escolha){
        Pagamento forma = new Pagamento();
        switch (escolha) {
            case 1:
                forma.setFormaPagamento(FormaPagamento.DINHEIRO);
                break;
            case 2:
                forma.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
                break;
            case 3:
                forma.setFormaPagamento(FormaPagamento.CARTAO_DEBITO);
                break;
            case 4:
                forma.setFormaPagamento(FormaPagamento.PIX);
                break;    
            }
            
            return forma;
    }
    
    public Reserva fazerReserva(Hospede hospede) throws ParseException{
        Menu menu = new Menu();
        System.out.println("Quantidade de hospedes: ");
        int quantHosp = i.nextInt();
        int tipoQuartoEscolhido = menu.menuEscolhaQuartos(0);
        verificarQuantidadeHospedes(tipoQuartoEscolhido, quantHosp);
        while(!verificarQuantidadeHospedes(tipoQuartoEscolhido, quantHosp)){
            quantHosp = i.nextInt();
            tipoQuartoEscolhido = menu.menuEscolhaQuartos(0);
            verificarQuantidadeHospedes(tipoQuartoEscolhido, quantHosp);
        }

        List<Date> inOut = dataCheckAllReserva();
        Quarto quartoDisponivel = verificarDisponibilidade(hotel.getQuartos(), inOut, tipoQuartoEscolhido);
        
        if(quartoDisponivel == null){
            System.out.println("Nenhum quarto disponível para esta data.");
        }else{
            int forma_pagamento = menu.menuFormaDePagamento();
            Pagamento pagamento = conversaoPagamento(forma_pagamento);
            pagamento.setValorPago(quartoDisponivel.getPrecoDiaria());
            List<Pagamento> pagamentos = new ArrayList<>();
            pagamentos.add(pagamento);
            quartoDisponivel.setStatus(QuartoStatus.OCUPADO);
            Reserva reserva = new Reserva(inOut.get(0), inOut.get(1), hospede, quartoDisponivel, ReservaStatus.CONFIRMADA, pagamentos);
            return reserva;
        }
        
        return null;
    }

    public void verReservas(Hospede hospede){
        List<Reserva> reservas = hospede.getReservas();

        for (Reserva reserva : reservas) {
            System.out.println("- Reserva " + reserva.getId() + "-");
            System.out.println("Quarto: " + reserva.getQuarto().getNumero());
            System.out.println("Data de checkin: " + reserva.getDataCheckin());
            System.out.println("Data de checkout: " + reserva.getDataCheckout());
        }
    }
}