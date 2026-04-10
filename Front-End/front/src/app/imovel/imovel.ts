import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ImovelService } from './imovel.service';

@Component({
  selector: 'app-imovel',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './imovel.html',
  styleUrls: ['./imovel.css'],
})
export class ImovelComponent implements OnInit {
  imoveis: any[] = [];
  newImovel: any = {
    descricao: '',
    endereco: '',
    dataCompra: '',
    comodos: [{ nome: '' }],
  };

  constructor(private apiService: ImovelService) {}

  ngOnInit(): void {
    this.loadImoveis();
  }

  loadImoveis() {
    this.apiService.getImoveis().subscribe({
      next: (data) => {
        this.imoveis = data;
      },
      error: (erro) => {
        console.error('Erro ao buscar imóveis:', erro);
      },
    });
  }

  createImovel() {
    console.log('Enviando dados para o backend:', this.newImovel);
    this.apiService.createImovel(this.newImovel).subscribe({
      next: () => {
        this.loadImoveis();
        this.newImovel = { descricao: '', endereco: '', dataCompra: '', comodos: [{ nome: '' }] };
      },
      error: (erro) => {
        console.error('Erro ao cadastrar imóvel:', erro);
      },
    });
  }

  addComodo() {
    this.newImovel.comodos.push({ nome: '' });
  }

  removeComodo(index: number) {
    this.newImovel.comodos.splice(index, 1);
  }
  deleteImovel(id: number) {
    if (confirm('Tem certeza que deseja excluir este imóvel?')) {
      this.apiService.deleteImovel(id).subscribe({
        next: () => {
          this.imoveis = this.imoveis.filter((i) => i.id !== id);
        },
        error: (erro) => console.error('Erro ao deletar imóvel:', erro),
      });
    }
  }
}
