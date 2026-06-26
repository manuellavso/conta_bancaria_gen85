package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	//CRUD - Create, Read, Update and Delete
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void procurarPorNumero(int numero); //Encontrar uma conta
	public void atualizar(Conta conta); //Atualiza dados da conta
	public void deletar(int numero); //Deletar conta
	public void listarPorTitular(String titular);
	
	//Métodos Bancários:
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
	
	
}
