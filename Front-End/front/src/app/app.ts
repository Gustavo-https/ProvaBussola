import { Component } from '@angular/core';
import { ImovelComponent } from './imovel/imovel';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [ImovelComponent, RouterModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {}
