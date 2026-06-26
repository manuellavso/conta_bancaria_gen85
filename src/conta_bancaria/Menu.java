package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {//FUNCIONA COMO FRONTEND

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController ContaController = new ContaController();
	
	public static void main(String[] args) {
		
		int opcao;
		char continua = 'S';
		testarContas(); //TESTE

		while(continua == 'S') {
			System.out.println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_CYAN_BACKGROUND);
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
			System.out.println("│				     	 ");
			System.out.println("│	➤ Ｂ𝐀𝐍𝐂𝐎 - Ｈ𝐄𝐗𝐀 2026   		 ");
			System.out.println("│			    	 	 ");
			System.out.println("┝━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┨ ");
			System.out.println("│1 💸 Criar conta			 ");
			System.out.println("│2 💸 Listar todas as contas		 ");
			System.out.println("│3 💸 Buscar conta por número	    	 ");
			System.out.println("│4 💸 Atualizar dados da conta	    	 ");
			System.out.println("│5 💸 Deletar conta	 		 ");
			System.out.println("│6 💸 Sacar valor			 ");
			System.out.println("│7 💸 Depositar valor			 ");
			System.out.println("│8 💸 Transferir valores entre contas     ");
			System.out.println("│9 💸 Consulta por nome do titular      ");
			System.out.println("│0 💸 Sair				 ");	
			System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
			System.out.println(""+Cores.TEXT_RESET);
			System.out.print(" ➤ Digite a opção desejada: ");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 9.");
				leia.nextLine();
			}
			
			if(opcao == 0) {
				encerrar();
				}
				
			switch(opcao) {
			case 1:
				System.out.println("➤ Criar conta");
				cadastrarConta();
				break;
				
			case 2:
				System.out.println("➤ Listar todas as contas");
				listarContas();
				break;
				
			case 3:
				System.out.println("➤ Consultar dados da conta por número");
				procurarContaPorNumero();
				break;
			case 4:
				System.out.println("➤ Atualizar dados da conta");
				atualizarConta();
				break;
			case 5:
				System.out.println("➤ Deletar conta");
				deletarConta();
				break;
			case 6:
				System.out.println("➤ Sacar valor");
				sacar();
				break;
			case 7:
				System.out.println("➤ Depositar valor");
				depositar();
				break;
			case 8:
				System.out.println("➤ Transferir valores entre contas");
				transferir();
				break;
			case 9:
				System.out.println("➤ Consulta por nome do titular");
				listarPorTitular();
				break;
			default:
				System.out.println(Cores.TEXT_RED+ "Opção inválida! " +Cores.TEXT_RESET);
				break;
			}
						
			do { System.out.println("\n➤ Pressione (S) para continuar ou (0) para sair: "); 
			continua = leia.next().toUpperCase().charAt(0); }
			while(!(continua == 'S') && !(continua == '0')); 
			if ((continua == '0')) { 
				encerrar(); 
				}
		}		leia.close();
	}
	
	
	
	//MÉTODO SOBRE
	public static void sobre() {
		System.out.println("Manuella V. Oliveira");
		System.out.println("➤ Informações de contato:");
		System.out.println("manuellavi0@gmail.com");
		System.out.println("https://github.com/manuellavso");
	}
	//MÉTODO ENCERRAR
	public static void encerrar() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("│	➤ Ｂ𝐀𝐍𝐂𝐎 - Ｈ𝐄𝐗𝐀 2026   		     ");
		System.out.println("│Obrigado por nos escolher diariamente	     ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("Projeto desenvolvido por:	   ");
		sobre();
		System.exit(0);
	}
	
	/*MÉTODO KEYPRESS
	public static void keyPress() {
		System.out.println(Cores.TEXT_RED_BRIGHT+"Pressione Enter para continuar"+Cores.TEXT_RESET);
		leia.nextLine();
	}*/
	
	//CONTAS PARA TESTE
	public static void testarContas() {
		ContaController.cadastrar(new ContaCorrente(ContaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		ContaController.cadastrar(new ContaPoupanca(ContaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
	
	
	//MÉTODO DE LISTAR CONTAS
	public static void listarContas() {
		ContaController.listarTodas();
	}
	
	
	//MÉTODO DE CADASTRO
	public static void cadastrarConta() {
		
		System.out.print("Digite o número da agência: ");
		int agencia = leia.nextInt();
		
		System.out.print("Digite o nome do titular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.print("Digite o tipo da conta (1- CC | 2- CP): ");
		int tipo = leia.nextInt();
		
		System.out.print("Digite o saldo da conta: R$");
		float saldo = leia.nextFloat();
		
		
		switch(tipo) {
			case 1 ->{ //CC
				System.out.print("Digite o limite da conta: R$");
				float limite = leia.nextFloat();
				
				ContaController.cadastrar(new ContaCorrente(ContaController.gerarNumero(), agencia, tipo, titular, saldo, limite));	
			}
			case 2 -> {//CP
				System.out.print("Digite o dia do aniversário da conta: ");
				int aniversario = leia.nextInt();
				
				ContaController.cadastrar(new ContaPoupanca(ContaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
			}default -> System.out.println(Cores.TEXT_RED_BRIGHT+ "Tipo de conta inválida!" +Cores.TEXT_RESET);
		}
	}
	
	
	//MÉTODO PROCURAR CONTA
	public static void procurarContaPorNumero() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		ContaController.procurarPorNumero(numero);
	}
	
	
	//MÉTODO ATUALIZAR
	public static void atualizarConta() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		Optional<Conta> conta = ContaController.buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			//Obtém os dados atuais da conta
			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();
			
			//Atualiza a agência ou mantém o valor atual
			System.out.printf("Agência atual: %d"
					+ "%nDigite o número da nova agência (Pressione ENTER para manter o valor atual) ", agencia);
			String entrada = leia.nextLine();

			
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			
			//Atualiza o titular ou mantém o valor atual
			System.out.printf("Titular atual: %s"
					+ "%nDigite o nome do novo titular (Pressione ENTER para manter o valor atual) ", titular);
			entrada = leia.nextLine();
			
			titular = entrada.isEmpty() ? titular : entrada;
			
			//Atualiza o saldo ou mantém o valor atual
			System.out.printf("Saldo atual: R$%.2f"
					+ "%nDigite o valor do novo saldo (Pressione ENTER para manter o valor atual) ", saldo);
			entrada = leia.nextLine();
			
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", ".")) ;
			
			
			//Atualiza o tipo de conta ou mantém o tipo atual
			switch(tipo) {
			case 1 -> {//CONTA CORRENTE
				ContaCorrente contaCorrente = (ContaCorrente) conta.get(); //CASTING: CONVERTE O OBJETO DE CONTA(OPTIONAL) PARA CONTA CORRENTE
				float limite = contaCorrente.getLimite();
				
				System.out.printf("Limite atual: R$%.2f"
						+ "%nDigite o valor do novo limite (Pressione ENTER para manter o valor atual) ", limite);
				entrada = leia.nextLine();
				
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", ".")) ;
				
				ContaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				
			}case 2 -> {//CONTA POUPANÇA
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
				int aniversario = contaPoupanca.getaniversario();
				
				System.out.printf("Dia do aniversário atual: %d"
						+ "%nDigite o novo dia de aniversário da conta (Pressione ENTER para manter o valor atual) ", aniversario);
				entrada = leia.nextLine();
				
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada) ;
				
				ContaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.TEXT_RED_BRIGHT+"Tipo de conta é inválido!"+Cores.TEXT_RESET);
		}
		}else {
			System.out.printf("A conta número %d não foi encontrada!", numero);
		}
	}
	
	
	
	//MÉTODO DELETAR
	public static void deletarConta() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		Optional<Conta> conta = ContaController.buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			//Confirmação de exclusão
			System.out.printf("Tem certeza que você deseja excluir a conta número %d? (S/N)", numero);
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S"))
				ContaController.deletar(numero);
			else
				System.out.println("Operação cancelada!");
				System.out.println();
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
			System.out.println();
		}
	}
	
	
	//MÉTODOS BANCÁRIOS:
	//1. MÉTODO SACAR
	public static void sacar() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		
		System.out.print("Digite o valor do saque: R$");
		float valorSaque = leia.nextFloat();
		
		ContaController.sacar(numero, valorSaque);
		
	}
	
	//2.MÉTODO DEPOSITAR
	public static void depositar() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		
		System.out.print("Digite o valor do depósito: R$");
		float valorDeposito = leia.nextFloat();
		
		ContaController.depositar(numero, valorDeposito);
	}
	
	//3. MÉTODO TRANSFERIR
	public static void transferir() {
		System.out.print("Digite o número da conta de origem: ");
		int numeroOrigem = leia.nextInt();
		
		System.out.print("Digite o número da conta de destino: ");
		int numeroDestino = leia.nextInt();
		
		System.out.print("Digite o valor da transferência: R$");
		float valorTransferencia = leia.nextFloat();
		
		ContaController.transferir(numeroOrigem, numeroDestino, valorTransferencia);
	}
	
	//MÉTODO LISTAR POR TITULAR
	public static void listarPorTitular() {
		System.out.print("Digite o nome do titular da conta: ");
		String titular = leia.nextLine();
		
		ContaController.listarPorTitular(titular);
	}
	
}
