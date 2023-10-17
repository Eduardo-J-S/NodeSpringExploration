import { Component } from '@angular/core';
import { Cliente } from '../modelo/Cliente';
import { ClienteService } from '../servico/cliente.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

    // objeto do tipo cliente
    cliente = new Cliente();

    // variável para visibilidade dos botões
    btnCadastro:boolean = true;

    // variavel para visibilidade da tabela
    tabela:boolean = true;

    // json de clientes
    clientes:Cliente[] = [];

    // construtor
    constructor(private servico:ClienteService){}

    // Método de seleção
    selecionar():void{
      this.servico.selecionar()
      .subscribe(retorno => this.clientes = retorno);
    }

    // método de cadastro
    cadastrar():void{
      this.servico.cadastrar(this.cliente)
      .subscribe(retorno => {

        // cadastrar o cliente no vetor
        this.clientes.push(retorno);

        // limpar formulario 
        this.cliente = new Cliente();

        // mensagem
        alert("Cliente cadastrado com sucesso!")
      });
    }

    // método para selecionar um cliente especifico
    selecionarCliente(posicao:number):void{
      //selecionar cliente no vetor
      this.cliente = this.clientes[posicao];

      // visibilidade dos botoes
      this.btnCadastro = false;

      // visibilidade da tabela
      this.tabela = false;
    }
    
    //método para editar um cliente
    editar():void{
      this.servico.editar(this.cliente)
      .subscribe(retorno => {
        //obter posição do vetor onde está o cliente
        let posicao = this.clientes.findIndex(obj => {
          return obj.codigo == retorno.codigo;
        });

        // alterar os dados dos clientes no vetor
        this.clientes[posicao] = retorno;

        // limpar formulário
        this.cliente = new Cliente();

        // visibilidade dos botões
        this.btnCadastro = true;

        //visibilidade da tabela
        this.tabela = true;

        // mensagem
        alert("Cliente alterado com sucesso!")
      });
    }

    // método para deletar um cliente
    remover():void{
      this.servico.remover(this.cliente.codigo)
      .subscribe(retorno => {
        //obter posição do vetor onde está o cliente
        let posicao = this.clientes.findIndex(obj => {
          return obj.codigo == this.cliente.codigo;
        });

        // remover cliente do vetor
        this.clientes.splice(posicao, 1);

        // limpar formulário
        this.cliente = new Cliente();

        // visibilidade dos botões
        this.btnCadastro = true;

        //visibilidade da tabela
        this.tabela = true;

        // mensagem
        alert("Cliente removido com sucesso!")
      });
    }


    //método para cancelar a operação
    cancelar():void{

      // limpar formulario
      this.cliente = new Cliente()
      
      // visibilidade dos botoes
      this.btnCadastro = true;

      // visibilidade da tabela
      this.tabela = true;
    }

    //método de inicialização
    ngOnInit(){
      this.selecionar();
    }
}
