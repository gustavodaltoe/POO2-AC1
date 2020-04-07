package com.example.ac1atividade2.controllers;

import java.util.List;

import com.example.ac1atividade2.models.Funcionario;

import com.example.ac1atividade2.services.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios() {

        ModelAndView mv = new ModelAndView("funcionarios");
        List<Funcionario> funcionarios = service.getFuncionarios();

        mv.addObject("funcionarios", funcionarios);

        return mv;

    }

    @PostMapping("/funcionarios")
    public ModelAndView postFuncionarios(@RequestBody Funcionario funcionario) {
        
        ModelAndView mv = new ModelAndView("funcionarios");
        List<Funcionario> funcionarios = service.addFuncionario(funcionario);
        
        mv.addObject("funcionarios", funcionarios);

        return mv;

    }
    

}