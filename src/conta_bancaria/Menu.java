package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	//Vira global, pois está fora do método main
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController ContaController = new ContaController();
	
	public static void main(String[] args) {
		
		int opcao;
		
		//Criar dados para teste:
		testarContas();
		
		char continua = 'S';

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
			System.out.println("│5 💸 Apagar conta	 		 ");
			System.out.println("│6 💸 Sacar valor			 ");
			System.out.println("│7 💸 Depositar valor			 ");
			System.out.println("│8 💸 Transferir valores entre contas     ");
			System.out.println("│0 💸 Sair				 ");	
			System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
			System.out.println(""+Cores.TEXT_RESET);
			System.out.print(" ➤ Digite a opção desejada: ");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 8.");
				leia.nextLine();
			}
			
			if(opcao == 0) {
				encerrar();
				}
				
			switch(opcao) {
			case 1:
				System.out.println("Criar conta");
				cadastrarConta();
				break;
				
			case 2:
				System.out.println("Listar todas as contas");
				listarContas();
				break;
				
			case 3:
				System.out.println("Buscar conta por número");
				break;
			case 4:
				System.out.println("Atualizar dados da conta");
				break;
			case 5:
				System.out.println("Apagar conta");
				break;
			case 6:
				System.out.println("Sacar valor");
				break;
			case 7:
				System.out.println("Depositar valor");
				break;
			case 8:
				System.out.println("Transferir valores entre contas");
				break;
			default:
				System.out.println(Cores.TEXT_RED+ "Opção inválida! " +Cores.TEXT_RESET);
				break;
			}
						
			do {
			System.out.println("➤ Pressione (S) para continuar ou (0) para sair: ");
			continua = leia.next().toUpperCase().charAt(0);
			}while(!(continua == 'S') && !(continua == '0'));
			if ((continua == '0')) {
				encerrar();
			}
		}		leia.close();
		
	}
	
	//MÉTODOS
	public static void sobre() {
		System.out.println("Manuella V. Oliveira");
		System.out.println("➤ Informações de contato:");
		System.out.println("manuellavi0@gmail.com");
		System.out.println("https://github.com/manuellavso");
	}
	//Faz uma pausa, mas não precisou porque criei um char e fiz do-while.
	/*public static void keyPress() {
		//System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		//leia.nextLine();
	} */
	
	public static void encerrar() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("│	➤ Ｂ𝐀𝐍𝐂𝐎 - Ｈ𝐄𝐗𝐀 2026   		     ");
		System.out.println("│Obrigado por nos escolher diariamente	     ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("Projeto desenvolvido por:	   ");
		sobre();
		System.exit(0); //Finaliza a aplicação
		
	}
	//Contas para testar
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
		
		//Case lambida (não precisa do break;
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
}
