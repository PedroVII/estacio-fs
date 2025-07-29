import { Injectable } from '@angular/core';
import { Livro } from './livro';

@Injectable({
  providedIn: 'root'
})
export class ControleLivrosService {

  private livros: Array<Livro> = [
    {
      codigo: 1,
      codEditora: 1,
      titulo: 'Angular para Iniciantes',
      resumo: 'Introdução ao Angular.',
      autores: ['João Silva', 'Maria Souza']
    },
    {
      codigo: 2,
      codEditora: 2,
      titulo: 'TypeScript Avançado',
      resumo: 'Conceitos avançados de TypeScript.',
      autores: ['Carlos Pereira']
    },
    {
      codigo: 3,
      codEditora: 3,
      titulo: 'Desenvolvimento Web Moderno',
      resumo: 'Práticas modernas de desenvolvimento web.',
      autores: ['Ana Lima', 'Pedro Santos']
    }
  ];

  constructor() { }

  obterLivros(): Array<Livro> {
    return this.livros;
  }

  incluir(livro: Livro): void {
    const novoCodigo = this.livros.length > 0
      ? Math.max(...this.livros.map(l => l.codigo)) + 1
      : 1;
    livro.codigo = novoCodigo;
    this.livros.push(livro);
  }

  excluir(codigo: number): void {
    const index = this.livros.findIndex(l => l.codigo === codigo);
    if (index > -1) {
      this.livros.splice(index, 1);
    }
  }
}