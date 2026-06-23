package conta_bancaria.model;

public class Conta {

	/* Atributos (características) da Classe */
	private int numero; //numero é parâmetro
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	/* MÉTODO Construtor:
	Responsável por gerar as instâncias(Objetos) da Classe*/
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	//public Conta () {}

	
	/*Métodos Get (visualizar os dados) e Set (modificar os dados) */
	public int getNumero() {
		return numero; //Retorna o valor do número, mas para mostrar precisa sysout
	}

	public void setNumero(int numero) {
		this.numero = numero; //Altera o valor do número
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	//MÉTODOS AUXILIARES:
	//1. Método SACAR
	public boolean sacar(float valor) {
		if (this.saldo < valor)
		return false;
		
		this.saldo -= valor;
		return true;
	}
	//2. Método DEPOSITAR
	public void depositar(float valor) {
		this.saldo += valor;
	}
	
	//
	//Método para visualizar todos os dados de uma vez:
	public void visualizar() {
		
		String tipo = "";

		switch(this.tipo){
		case 1:
				tipo = "Conta Corrente";
		break;
		case 2:
				tipo = "Conta Poupança";
		break;
		}
		
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("│ ➤ D A D O S   D A   C O N T A	     ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");		
		System.out.printf("Número da conta: %d", this.numero);
		System.out.printf("%nNúmero da agênca: %d", this.agencia);
		System.out.printf("%nTipo de conta: %s", tipo);
		System.out.printf("%nNome do titular: %s", this.titular);
		System.out.printf("%nSaldo da conta: R$%.2f", this.saldo);
	}
	
	
}
