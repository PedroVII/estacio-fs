/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("=======================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=======================================");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 0) break;

                if (opcao >= 1 && opcao <= 5) {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    String tipo = scanner.nextLine().toUpperCase();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o id da pessoa:");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.println("Insira os dados...");
                            System.out.print("Nome: "); 
                            String nome = scanner.nextLine();
                            if (tipo.equals("F")) {
                                System.out.print("CPF: "); String cpf = scanner.nextLine();
                                System.out.print("Idade: "); int idade = Integer.parseInt(scanner.nextLine());
                                repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                            } else {
                                System.out.print("CNPJ: "); String cnpj = scanner.nextLine();
                                repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                            }
                            break;

                        case 2:
                            System.out.println("Digite o id da pessoa:");
                            int idAlt = Integer.parseInt(scanner.nextLine());
                            if (tipo.equals("F")) {
                                PessoaFisica pf = repoFisica.obter(idAlt);
                                if (pf != null) {
                                    System.out.println("Dados atuais:");
                                    pf.exibir();
                                    System.out.println("Insira os novos dados...");
                                    System.out.print("Nome: "); pf.setNome(scanner.nextLine());
                                    System.out.print("CPF: "); pf.setCpf(scanner.nextLine());
                                    System.out.print("Idade: "); pf.setIdade(Integer.parseInt(scanner.nextLine()));
                                }
                            } else {
                                PessoaJuridica pj = repoJuridica.obter(idAlt);
                                if (pj != null) {
                                    System.out.println("Dados atuais:");
                                    pj.exibir();
                                    System.out.println("Insira os novos dados...");
                                    System.out.print("Nome: "); pj.setNome(scanner.nextLine());
                                    System.out.print("CNPJ: "); pj.setCnpj(scanner.nextLine());
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Digite o id da pessoa:");
                            int idExc = Integer.parseInt(scanner.nextLine());
                            if (tipo.equals("F")) repoFisica.excluir(idExc);
                            else repoJuridica.excluir(idExc);
                            break;

                        case 4:
                            System.out.println("Digite o id da pessoa:");
                            int idObt = Integer.parseInt(scanner.nextLine());
                            if (tipo.equals("F")) {
                                PessoaFisica pf = repoFisica.obter(idObt);
                                if (pf != null) pf.exibir();
                            } else {
                                PessoaJuridica pj = repoJuridica.obter(idObt);
                                if (pj != null) pj.exibir();
                            }
                            break;

                        case 5:
                            if (tipo.equals("F")) {
                                for (PessoaFisica pf : repoFisica.obterTodos()) {
                                    pf.exibir();
                                    System.out.println("---");
                                }
                            } else {
                                for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                                    pj.exibir();
                                    System.out.println("---");
                                }
                            }
                            break;
                    }
                } else if (opcao == 6 || opcao == 7) {
                    System.out.println("Digite o prefixo do arquivo:");
                    String prefixo = scanner.nextLine();
                    try {
                        if (opcao == 6) {
                            repoFisica.persistir(prefixo + ".fisica.bin");
                            repoJuridica.persistir(prefixo + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } else {
                            repoFisica.recuperar(prefixo + ".fisica.bin");
                            repoJuridica.recuperar(prefixo + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro na operacao: " + e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida.");
            }
        }
        System.out.println("Finalizando programa...");
    }
}
