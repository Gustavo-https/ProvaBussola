import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { App } from './app';
import { ImovelComponent } from './imovel/imovel';

@NgModule({
  imports: [BrowserModule, HttpClientModule, FormsModule, ImovelComponent, App],
  providers: [],
})
export class AppModule {}
