import { Injectable } from '@angular/core';
import { Editora } from './editora';

@Injectable({
  providedIn: 'root'
})
export class ControleEditoraService {

  private editoras: Array<Editora> = [
    { codEditora: 1, nome: 'Editora Alfa' },
    { codEditora: 2, nome: 'Editora Beta' },
    { codEditora: 3, nome: 'Editora Gama' }
  ];

  constructor() { }

  getEditoras(): Array<Editora> {
    return this.editoras;
  }

  getNomeEditora(codEditora: number): string | undefined {
    const editora = this.editoras.filter(e => e.codEditora === codEditora)[0];
    return editora ? editora.nome : undefined;
  }
}

