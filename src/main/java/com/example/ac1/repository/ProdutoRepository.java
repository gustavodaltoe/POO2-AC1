package com.example.ac1.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ac1.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository
public class ProdutoRepository {

    public HashMap<Integer, Produto> hm = new HashMap<Integer, Produto>();

    public ProdutoRepository()
    {
        hm.put(1, new Produto(1, "Teste 1", 250.99, 100));
        hm.put(2, new Produto(2, "Teste 2", 99.99, 100));
        hm.put(3, new Produto(3, "Teste 3", 0.99, 0));
        hm.put(4, new Produto(4, "Teste 4", 300, 100));
        hm.put(5, new Produto(5, "Teste 5", 10, 5));
        hm.put(6, new Produto(6, "Teste 6", 250.99, 100));
        hm.put(7, new Produto(7, "Teste 7", 250.99, 100));
        hm.put(8, new Produto(8, "Teste 8", 250.99, 100));
        hm.put(9, new Produto(9, "Teste 9", 250.99, 100));
        hm.put(10, new Produto(10, "Teste 10", 250.99, 100));
    }

    public Produto getProdutoById(int id) 
    {
        return hm.get(id);
    }

    public ArrayList<Produto> getProdutos() {
        ArrayList<Produto> prods = new ArrayList<Produto>();

        int size = hm.size();
        for (int i = 1; i <= size; i++) {
            prods.add(hm.get(i));
        }

        return prods;
    }
}