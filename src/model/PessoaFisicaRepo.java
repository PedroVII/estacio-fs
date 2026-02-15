/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> lista;
    
    public PessoaFisicaRepo() {
        this.lista = new ArrayList<>();
    }
    
    public void inserir(PessoaFisica pessoa) {
        lista.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == pessoa.getId()) {
                lista.set(i, pessoa);
                break;
            }
        }
    }
    
    public void excluir(int id) {
        lista.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : lista) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaFisica> obterTodos() {
        return lista;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
}
