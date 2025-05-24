package com.uepb.reservas.menus;

import com.uepb.*;
import com.uepb.reservas.models.Quarto;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
    Scanner i = new Scanner(System.in);

    public String processarEscolha(int escolha) {
        if (escolha < 1 || escolha > 2) {
            return "Opção inexistente. Tente novamente.";
        }

        switch (escolha) {
            case 1:
                return "Você escolheu fazer login.";
            case 2:
                return "Você escolheu cadastrar.";
            default:
                return "Erro inesperado.";
        }
    }

    public int menuInicial(){
        System.out.println("--- MENU INICIAL ---");
        System.out.println("[1] - Fazer login");
        System.out.println("[2] - Cadastrar");
        System.out.println("Escolha: ");
        int escolha = i.nextInt();
        while(escolha > 2 || escolha < 1){
            System.out.println("Opção inexistente. Tente novamente.");
            System.out.println("Escolha: ");
            escolha = i.nextInt();
        }
        return escolha;
    }

    public int menuHospede(){
        System.out.println("--- MENU USUARIO ---");
        System.out.println("[1] - Reservar");
        System.out.println("[2] - Ver reservas");
        System.out.println("[3] - Avaliar");
        System.out.println("Escolha: ");
        int escolha = i.nextInt();
        while(escolha > 3 || escolha < 1){
            System.out.println("Opção inexistente. Tente novamente.");
            System.out.println("Escolha: ");
            escolha = i.nextInt();
        }
        return escolha;
    }

    public int menuEscolhaQuartos(int quantHosp){
        if(quantHosp > 0){
            System.out.println("--- MENU QUARTOS ---");
            System.out.println("[1] - Solteiro");
            System.out.println("[2] - Casal");
            System.out.println("[3] - Luxo");
            System.out.println("Escolha: ");
            int escolha = i.nextInt();
            while(escolha > 3 || escolha < 1){
                System.out.println("Opção inexistente. Tente novamente.");
                System.out.println("Escolha: ");
                escolha = i.nextInt();
            }
            return escolha;
        }
        return 0;
    }

    public int menuQuarto(Quarto quarto){
        System.out.println("--- MENU QUARTO ---");
        System.out.println("[1] - Consumo");
        System.out.println("[2] - Serviços");
        System.out.println("[3] - Informações do quarto");
        System.out.println("Escolha: ");
        int escolha = i.nextInt();
        while(escolha > 3 || escolha < 1){
            System.out.println("Opção inexistente. Tente novamente.");
            System.out.println("Escolha: ");
            escolha = i.nextInt();
            }
        return escolha;
    }

    public int menuFormaDePagamento(){
        System.out.println("--- FORMA DE PAGAMENTO ---");
        System.out.println("[1] - Dinheiro");
        System.out.println("[2] - Cartão de crédito");
        System.out.println("[3] - Cartão de débito");
        System.out.println("[4] - PIX");
        System.out.println("Escolha: ");
        int escolha = i.nextInt();
        while(escolha > 4 || escolha < 1){
            System.out.println("Opção inexistente. Tente novamente.");
            System.out.println("Escolha: ");
            escolha = i.nextInt();
            }
        return escolha;
    }
    
}
