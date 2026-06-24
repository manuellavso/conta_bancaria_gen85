package conta_bancaria.model;

public class ContaCorrente extends Conta{//Modelo de dados
	
	private float limite; //Específico de conta corrente

	//Puxou os dados da superclasse Conta
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); //método "super" chama o construtor da classe Conta (superclasse)
		this.limite = limite; //Teve que adicionar o limite, que é específico da subclasse ContaCorrente
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.limite < valor)
		return false;
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	//Anotação em cima do método: significa que o método já existe na superclasse, mas eu estou reescrevendo ele na subclasse
	@Override
	public void visualizar() {
		super.visualizar(); //o super é um método que chama o método visualizar da superclasse
		System.out.printf("\nLimite da conta: R$%.2f ", this.limite);
		System.out.println();
	}
	
	
	
}
