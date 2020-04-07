package com.example.ac1.controller;

import java.util.ArrayList;

import com.example.ac1.model.Produto;
import com.example.ac1.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 */
@Controller
public class ProductController {

    @Autowired
    private ProdutoService ps;

    @GetMapping("/produto/{id}")
    public ModelAndView getProduto(
        @PathVariable("id") int id
        ) {
        ModelAndView mv = new ModelAndView("produtoByIdView");
        
        try {
            Produto prod = ps.getProduto(id);
            mv.addObject("produto", prod);
        } catch (Exception e) {
            mv.addObject("erro", e);
        }


        return mv;
    }

    @GetMapping("/produtosEmEstoque")
    public ModelAndView getProdutosEmEstoque()
    {
        ModelAndView mv = new ModelAndView("produtosEmEstoqueView");
        ArrayList<Produto> produtos = ps.getProdutosEmEstoque();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/produtosValorAcima/{valor}")
    public ModelAndView getProdutosValorMaior(
        @PathVariable("valor") double valor
    ){
        ModelAndView mv = new ModelAndView("produtosValorMaiorView");
        ArrayList<Produto> produtos = ps.getProdutosByValorAcima(valor);
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/produtosValorAbaixo/{valor}")
    public ModelAndView getProdutosValorMenor(
        @PathVariable("valor") double valor
    ){
        ModelAndView mv = new ModelAndView("produtosValorAbaixoView");
        ArrayList<Produto> produtos = ps.getProdutosByValorAbaixo(valor);
        mv.addObject("produtos", produtos);
        return mv;
    }
}