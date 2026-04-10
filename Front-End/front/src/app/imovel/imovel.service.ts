import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environments } from '../../environment/environment';

interface Imovel {
  id: number;
  descricao: string;
  endereco: string;
  dataCompra: string;
  comodos: { nome: string }[];
}
@Injectable({
  providedIn: 'root',
})
export class ImovelService {
  private apiUrl = environments.apiUrl;

  constructor(private http: HttpClient) {}

  getImoveis(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/Imovel`);
  }

  createImovel(imovel: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/Imovel`, imovel);
  }

  listImoveis(imovel: any): Observable<any[]> {
    return this.http.put<any[]>(`${this.apiUrl}/Imovel`, imovel);
  }

  deleteImovel(id: any): Observable<any> {
    return this.http.delete(`${this.apiUrl}/Imovel/${id}`);
  }
}
