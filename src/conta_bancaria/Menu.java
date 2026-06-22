package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		/* Instanciar objetos da classe conta */
		Conta c1 = new Conta(1,123,1,"Manuella", 200000.00f);
		c1.visualizar();
		
		Conta c2 = new Conta(2,321,2,"Bella", 200000.00f);
		c2.visualizar();
		
		/* Alteração(set) do saldo:
		c1.setSaldo(350000.00f);
		c1.visualizar();*/
		
		/*If ternário > condição ? ação se for verdadeiro : ação se for falso */
		System.out.println("\nSacar R$1.000,00 da conta c1: " + (c1.sacar(1000.00f) 
				? "Saque efetuado com sucesso" : "Saldo insuficiente"));
		c1.visualizar();
		
		c1.depositar(9000.00f); 
		c1.visualizar();
		
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
				opcao = leia.nextInt();
			
			if(opcao == 0) {
				encerrar();
				}
				
			switch(opcao) {
			case 1:
				System.out.println("Criar conta");
				break;
			case 2:
				System.out.println("Listar todas as contas");
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
				System.out.println("Opção inválida!");
				break;
			}
						
			do {
			System.out.println("➤ Deseja continuar? (S/0) ");
			continua = leia.next().toUpperCase().charAt(0);
			}while(!(continua == 'S') && !(continua == '0'));
			if ((continua == '0')) {
				encerrar();
			}
		}		leia.close();
		
	}
	
	public static void sobre() {
		System.out.println("Manuella V. Oliveira");
		System.out.println("➤ Informações de contato:");
		System.out.println("manuellavi0@gmail.com");
		System.out.println("https://github.com/manuellavso");
	}
	
	public static void encerrar() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("│	➤ Ｂ𝐀𝐍𝐂𝐎 - Ｈ𝐄𝐗𝐀 2026   		     ");
		System.out.println("│Obrigado por nos escolher diariamente	     ");
		System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("Projeto desenvolvido por:	   ");
		sobre();
		System.exit(0);
		
	}
}
