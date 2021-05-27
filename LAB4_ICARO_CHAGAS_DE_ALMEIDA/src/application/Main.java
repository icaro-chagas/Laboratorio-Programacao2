package application;

import java.util.Scanner;

/**
 * Classe principal com menus de texto para manipular o Controle de Alunos.
 * 
 * @author �caro Chagas de Almeida - 119210960
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ControleDeAlunos cda = new ControleDeAlunos();
		
		String escolha = "";
		while (true) {
			escolha = menu(sc);
			
			if (escolha.equals("O")) {
				System.out.println("\nAplica��o Encerrada!");
				break;
			}
			
			comando(escolha, cda, sc);				
		}
		
	}
	
	/**
	 * Exibe o menu e captura a escolha do(a) usu�rio(a).
	 * 
	 * @param sc Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner sc) {
		System.out.print(
						"\n(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo e Imprimir Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam\n" + 
						"(O)ra, vamos fechar o programa\n" + 
						"\n" +
						"Op��o> ");
		return sc.next().toUpperCase();
	}
	
	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao Op��o digitada.
	 * @param cda Objeto da classe ControleDeAlunos que estamos manipulando.
	 * @param sc Objeto do tipo Scanner para a entrada de dados nos m�todos referenciados.
	 */
	private static void comando(String opcao, ControleDeAlunos cda, Scanner sc) {
		switch (opcao) {
		case "C":
			cadastraAluno(cda, sc);
			break;
		case "E":
			exibeAluno(cda, sc);
			break;
		case "N":
			cadastraNovoGrupo(cda, sc);
			break;
		case "A":
			alocaAlunoOuImprimeGrupo(cda, sc);
			break;
		case "R":
			registraAlunoQueRespondeu(cda, sc);
			break;
		case "I":
			imprimeAlunosQueResponderam(cda, sc);
			break;
		default:
			System.out.println("OP��O INV�LIDA!");
		}
	}
	
	/**
	 * Casdastra um aluno no Sistema de Controle de Alunos.
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todo cadastraAluno.
	 * @param sc Objeto do tipo Scanner para a entrada de dados. 
	 */
	private static void cadastraAluno(ControleDeAlunos cda, Scanner sc) {
		System.out.print("Matr�cula: ");
		String matricula = sc.next();
		sc.nextLine();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		
		System.out.println(cda.cadastraAluno(matricula, nome, curso));
	}

	/**
	 * Exibe aluno cadastrado no Sistema de Controle de Alunos
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todo exibeAluno.
	 * @param sc Objeto do tipo Scanner para a entrada de dados.
	 */
	private static void exibeAluno(ControleDeAlunos cda, Scanner sc) {
		System.out.print("Matr�cula: ");
		String matricula = sc.next();
		sc.nextLine();
		
		System.out.println(cda.exibeAluno(matricula));
	}
	
	/**
	 * Cadastra um novo grupo de estudo no Sistema de Controle de Alunos.
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todo cadastraNovoGrupo.
	 * @param sc Objeto do tipo Scanner para a entrada de dados.
	 */
	private static void cadastraNovoGrupo(ControleDeAlunos cda, Scanner sc) {
		System.out.print("Grupo: ");
		sc.nextLine();
		String nomeGrupo = sc.nextLine();
		
		System.out.println(cda.cadastraNovoGrupo(nomeGrupo));
	}
	
	/**
	 * Aloca um aluno em grupo de estudo ou solicita impress�o dos alunos, e suas respectivas
	 * informa��es, que fazem parte de um grupo (n�o h� ordem definida para impress�o dos componentes do grupo).
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todos alocaAlunoEmGrupo e imprimeGrupo.
	 * @param sc Objeto do tipo Scanner para a entrada de dados.
	 */
	private static void alocaAlunoOuImprimeGrupo(ControleDeAlunos cda, Scanner sc) {
		System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
		String escolha = sc.next();
		sc.nextLine();
		
		if ("A".equals(escolha.toUpperCase())) {
			System.out.print("Matr�cula: ");
			String matricula = sc.next();
			sc.nextLine();
			
			System.out.print("Grupo: ");
			String nomeGrupo = sc.nextLine();
			System.out.println(cda.alocaAlunoEmGrupo(matricula, nomeGrupo));
		}
		
		if ("I".equals(escolha.toUpperCase())) {
			System.out.print("Grupo: ");
			String nomeGrupo = sc.nextLine();
			System.out.print(cda.imprimeGrupo(nomeGrupo));
		}
	}
	
	/**
	 * Registra alunos que respondem quest�es no quadro no Sistema de Controle de Alunos.
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todo registraAlunoQueRepondeu.
	 * @param sc Objeto do tipo Scanner para a entrada de dados.
	 */
	private static void registraAlunoQueRespondeu(ControleDeAlunos cda, Scanner sc) {
		System.out.print("Matr�cula: ");
		String matricula = sc.next();
		sc.nextLine();
		
		System.out.println(cda.registraAlunoQueRepondeu(matricula));
	}
	
	/**
	 * Imprime lista ordenada dos alunos que responderam quest�es no quadro (� poss�vel que o mesmo 
	 * aluno responda quest�es mais de uma vez). 
	 * 
	 * @param cda Objeto do tipo ControleDeAlunos para manipula��o do m�todo imprimeAlunosQueResponderam.
	 * @param sc Objeto do tipo Scanner para a entrada de dados.
	 */
	private static void imprimeAlunosQueResponderam(ControleDeAlunos cda, Scanner sc) {
		System.out.print(cda.imprimeAlunosQueResponderam());
	}
}
