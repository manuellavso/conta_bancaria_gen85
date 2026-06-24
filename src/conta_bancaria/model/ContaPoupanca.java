package conta_bancaria.model;

public class ContaPoupanca extends Conta{//Modelo de dados

	private int aniversario;//Específico de conta poupança
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getaniversario() {
		return aniversario;
	}

	public void setaniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nDia do rendimento da conta (seu aniversário): %d ", this.aniversario);
		System.out.println();
	}
		

}
