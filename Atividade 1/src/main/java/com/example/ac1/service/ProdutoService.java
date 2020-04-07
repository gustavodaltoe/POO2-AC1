package com.example.ac1.service;

import java.util.ArrayList;

import com.example.ac1.model.Produto;
import com.example.ac1.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository pr;

    public Produto getProduto(int id) throws Exception {
        Produto p = pr.getProdutoById(id);
        if (p == null)
            throw new Exception("Produto não encontrado.");
        return p;
    }

    public ArrayList<Produto> getProdutosEmEstoque() {
        ArrayList<Produto> produtos = pr.getProdutos();
        produtos.removeIf(p -> p.getEstoque() <= 0);
        return produtos;
    }

    public ArrayList<Produto> getProdutosByValorAcima(double valor) {
        ArrayList<Produto> produtos = pr.getProdutos();
        produtos.removeIf(p -> p.getValor() <= valor);
        return produtos;
    }

    public ArrayList<Produto> getProdutosByValorAbaixo(double valor) {
        ArrayList<Produto> produtos = pr.getProdutos();
        produtos.removeIf(p -> p.getValor() >= valor);
        return produtos;
    }
}