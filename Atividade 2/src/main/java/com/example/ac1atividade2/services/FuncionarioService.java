package com.example.ac1atividade2.services;

import java.util.List;

import com.example.ac1atividade2.entities.Funcionario;

import com.example.ac1atividade2.repositorys.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getFuncionarios() {
        return repository.findAll();
    }

    public List<Funcionario> addFuncionario(Funcionario funcionario) {

        if (funcionario.getNome() == null ||
            funcionario.getCargo() == null ||
            funcionario.getSalario() == null ||
            funcionario.getSetor() == null) {
                
                return getFuncionarios();
            
        }

        repository.saveAndFlush(funcionario);
        return getFuncionarios();
    }

}