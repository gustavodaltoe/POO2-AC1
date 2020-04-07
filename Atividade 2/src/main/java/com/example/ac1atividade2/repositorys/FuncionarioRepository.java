package com.example.ac1atividade2.repositorys;

import com.example.ac1atividade2.entities.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {

}