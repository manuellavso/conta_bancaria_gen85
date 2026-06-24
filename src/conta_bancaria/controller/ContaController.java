package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0; //variável usada para automatizar o número da conta - ou seja, gerar sozinho.
	
	//Passando por todas as contas
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
	}
	
	//O menu (frontend) vai precisar mandar um objeto da classe conta (para o backend)
	//É um padronizador
	//cadastrar espera um objeto da classe conta
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf("\nOba, a conta número %d foi criada com sucesso!", conta.getNumero());
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	//Método auxiliar (para automatizar, cria uma auto-numeração para cada conta)
	public int gerarNumero() {
		return++ numero; //pré incremento para dar o número na hora
	}

}
