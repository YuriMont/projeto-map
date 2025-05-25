package com.uepb.reservas.services;

import com.uepb.reservas.dtos.requests.HospedeRequestDto;
import com.uepb.reservas.models.Hospede;
import com.uepb.reservas.repositories.HospedeRepository;

import jakarta.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class HospedeService {
    Scanner s = new Scanner(System.in);

    @Autowired
    private HospedeRepository repository;

    public Hospede createHospede(HospedeRequestDto hospedeRequestDto){
        return repository.save(new Hospede(hospedeRequestDto));
    }

    public Optional<Hospede> findHospedeById(Long id){
        return repository.findById(id);
    }

    public Hospede updateHospede(Long id, HospedeRequestDto hospedeRequestDto){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("Id não encontrado.");
        }

        return repository.save(new Hospede(id, hospedeRequestDto));
    }

    public void deleteHospedeById(Long id){
        repository.deleteById(id);
    }

    public List<Hospede> findHospedes(){
        return repository.findAll();
    }

    public boolean fazerCadastro(List<Hospede> hospedes) throws ParseException{
        System.out.println("- TELA DE CADASTRO -");

        System.out.println("Nome: ");
        String nome = s.nextLine();

        System.out.println("CPF: ");
        String cpf = s.nextLine();
        
        System.out.println("Email: ");
        String email = s.nextLine();

        System.out.println("Senha: ");
        String senha = s.nextLine();
        
        System.out.println("Telefone: ");
        String telefone = s.nextLine();

        System.out.println("Data de nascimento: (dd/mm/aaaa)");
        String dn = s.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = formatter.parse(dn);

        Hospede hospede = new Hospede(nome, cpf, email, telefone, senha, dataNascimento);
        hospedes.add(hospede);
        return true;
    }

    public boolean fazerLogin(List<Hospede> hospedes){
        System.out.println("Email: ");
        String email = s.nextLine();

        System.out.println("Senha: ");
        String senha = s.nextLine();

        for (Hospede hospede : hospedes) {
            if((hospede.getEmail() == email) && (hospede.getSenha() == senha)){
                return true;
            };
        }

        return false;
    }
}
