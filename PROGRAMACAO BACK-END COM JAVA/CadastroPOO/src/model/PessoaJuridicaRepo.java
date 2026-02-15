/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> lista;
    
    public PessoaJuridicaRepo() {
        this.lista = new ArrayList<>();
    }
    
    public void inserir(PessoaJuridica pessoa) {
        lista.add(pessoa);
    }
    
    public void alterar(PessoaJuridica pessoa) {
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
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : lista) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
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
            lista = (ArrayList<PessoaJuridica>) ois.readObject();
        }
    }
}
