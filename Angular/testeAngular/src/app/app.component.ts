import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'testeAngular';
}

// O código abaixo tem alguns erros e não funciona como deveria. Você pode identificar quais são e corrigi-los em um arquivo TS?

let botaoAtualizar = document.getElementById('atualizar-saldo');
let botaoLimpar = document.getElementById('limpar-saldo');
let soma = document.getElementById('soma') as HTMLInputElement;
let campoSaldo = document.getElementById('campo-saldo');

let saldototal = 0

limparSaldo()

function somarAoSaldo(soma: number) {
  if(campoSaldo){
    saldototal += soma;
    campoSaldo.innerHTML = saldototal.toString();
    limparCampoSoma();
  }
}

function limparCampoSoma() {
  soma.value = "";
}

function limparSaldo() {
  if(campoSaldo){
    saldototal = 0;
    campoSaldo.innerHTML = saldototal.toString();
  }
}

if(botaoAtualizar!= null){
  botaoAtualizar.addEventListener('click', () => {
    console.log("aas")
      somarAoSaldo(Number(soma.value));
  });
}
if(botaoLimpar!= null){
  botaoLimpar.addEventListener('click', () => {
      limparSaldo();
  });
}

