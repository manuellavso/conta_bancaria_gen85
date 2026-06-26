package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0; //variável usada para automatizar o número da conta - ou seja, gerar sozinho.
	
	//Passa por todas as contas
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
	}
	
	
	/*É um padronizador
	Cadastrar espera um objeto da classe conta*/
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf("\nOba, a conta número %d foi criada com sucesso!", conta.getNumero());
	}

	
	@Override
	public void procurarPorNumero(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
	}
	

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
		System.out.printf("\nA conta número %d foi atualizada com sucesso!", conta.getNumero());
	}		
		else
			System.out.printf("\nA conta número %d não foi encontrada!", conta.getNumero());		
	}

	
	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()));
			System.out.printf("\nA conta número %d foi excluída com sucesso!", numero);
		}
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);		
	}

	
	@Override
	public void sacar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			if (conta.get().sacar(valor))
				System.out.printf("\nO saque no valor de R$ %.2f, na conta número %d foi efetuado com sucesso!"
						, valor, numero);
			else
				System.out.printf("\nO saque no valor de R$ %.2f, na conta número %d não foi efetuado devido ao saldo insuficiente!"
						, valor, numero);
		} else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		
	}


	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("\nO depósito no valor de R$ %.2f, na conta número %d foi efetuado com sucesso!"
						, valor, numero);
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
	}

	
	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
			
			if (contaOrigem.isPresent() && contaDestino.isPresent()) {
				if (contaOrigem.get().sacar(valor)) {
					contaDestino.get().depositar(valor);
					System.out.printf("\nA tranferência no valor de R$ %.2f, da conta número %d "
							+ "para a conta %d foi efetuado com sucesso!"
							, valor, numeroOrigem, numeroDestino);
				}else
					System.out.printf("\nA tranferência no valor de R$ %.2f, da conta número %d "
							+ "para a conta %d não foi efetuado devido ao saldo insuficiente na conta de origem!"
							, valor, numeroOrigem, numeroDestino);
			} else
				System.out.printf("\nA conta número %d e/ou a conta número %d não foram encontradas!", numeroOrigem, numeroDestino);
	}
	
	
	
	@Override
	public void listarPorTitular(String titular) {

		List<Conta> listaTitulares = listaContas.stream()
				.filter(conta -> conta.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if (listaTitulares.isEmpty())	//SE FOR VAZIO
			System.out.printf("\nNenhum titular com o nome %s foi encontrado.", titular);
		else //SE NÃO, MOSTRA A LISTA
		listaTitulares.forEach(conta -> conta.visualizar());
	}
	
	
	///////
	//MÉTODO AUXILIAR - auto-numeração por conta
	public int gerarNumero() {
		return++ numero; //pré incremento para dar o número na hora
	}
	
	//MÉTODO ENCONTRAR CONTA
	public Optional<Conta> buscarNaCollection(int numero){
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}


	

}
