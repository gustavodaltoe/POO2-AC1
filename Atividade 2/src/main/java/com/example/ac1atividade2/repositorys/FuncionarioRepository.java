package com.example.ac1atividade2.repositorys;

import com.example.ac1atividade2.models.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {

}