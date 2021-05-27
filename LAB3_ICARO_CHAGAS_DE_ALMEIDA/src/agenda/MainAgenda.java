package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus de texto para manipular uma agenda de contatos.
 * 
 * @author Adaptado por: �caro Chagas de Almeida (Autor Original: Nazareno Andrade)
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa � a maneira de lidar com poss�veis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner sc = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(sc);
			comando(escolha, agenda, sc);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usu�rio/a.
	 * 
	 * @param sc Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner sc) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(T)elefones preferidos\n" +
						"(Z)aps\n" +
						"(S)air\n" + 
						"\n" + 
						"Op��o> ");
		return sc.next().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao Op��o digitada.
	 * @param agenda A agenda que estamos manipulando.
	 * @param sc Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner sc) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, sc);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, sc);
			break;
		case "T":
			telefonesPreferidos(agenda);
			break;
		case "Z":
			contatosWhatsapp(agenda);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OP��O INV�LIDA!");
		}
	}
	/**
	 * Fornece os n�meros de Whatsapp de cada contato (ou informa a aus�ncia de Whatsapp).
	 * 
	 * @param agenda A agenda que armazena as informa��es dos contatos em um array do tipo Contatos[].
	 */
	private static void contatosWhatsapp(Agenda agenda) {
		System.out.println("\nZaps: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(contatos[i].getNome() + " " + contatos[i].getSobrenome() + " - " + contatos[i].getContatoWhatsapp());
			}
		}
	}
	
	/**
	 * Fornece os n�meros priorit�rios de cada contato (ou informa a aus�ncia de telefeno priorit�rio).
	 * 
	 * @param agenda A agenda que armazena as informa��es dos contatos em um array do tipo Contatos[].
	 */
	private static void telefonesPreferidos(Agenda agenda) {
		System.out.println("\nTelefones Preferidos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(contatos[i].getNome() + " " + contatos[i].getSobrenome() + " - " + contatos[i].getTelPreferido());
			}
		}	
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(i+1 + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome());
			}
		}
	}
	
	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param sc Scanner para capturar qual contato.
	 */
		private static void exibeContato(Agenda agenda, Scanner sc) {
		System.out.print("\nQual contato: ");
		int posicao = sc.nextInt();
		System.out.println(agenda.getContato(posicao));
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param sc Scanner para pedir informa��es do contato.
	 * @param posicao Posi��o do vetor contatos para adicionar um contado (apenas posi��es entre 1 e 100, inclusive, s�o v�lidas).
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 1� telefone do contato. 
	 * @param telefone2 2� telefone do contato.
	 * @param telefone3 3� telefone do contato.
	 * @param telPrincipal Telefone priorit�rio do contato.
	 * @param telWhatsapp N�mero de Whatsapp do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner sc) {
		
		System.out.print("\nPosi��o na agenda: ");
		int posicao = sc.nextInt();
			
		while (posicao > 100 || posicao < 1) {
			System.out.println("POSI��O INV�LIDA!");
			System.out.print("\nPosi��o na agenda: ");
			posicao = sc.nextInt();
		}
				
		System.out.print("Nome: ");
		String nome = sc.next();
		sc.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine().strip();
				
		System.out.print("Telefone1: ");
		String telefone1 = sc.nextLine().strip();
			
		System.out.print("Telefone2: ");
		String telefone2 = sc.nextLine().strip();
		
		System.out.print("Telefone3: ");
		String telefone3 = sc.nextLine().strip();	
		 
		System.out.print("Telefone Priorit�rio: ");
		int telPrincipal = sc.nextInt();
		
		System.out.print("Contato Whatsapp: ");
		int telWhatsapp = sc.nextInt();
		
		System.out.println("CADASTRO REALIZADO");
		
		agenda.cadastraContato(posicao, nome, sobrenome, telefone1, telefone2, telefone3, telPrincipal, telWhatsapp);
		
	}

	/**
	 * Sai da aplica��o.
	 */
	private static void sai() {
		System.out.println("\nAplica��o encerrada");
		System.exit(0);
	}

	/**
	 * L� uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo n�o exista ou n�o possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
			LeitorDeAgenda leitor = new LeitorDeAgenda();
	
			int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
			System.out.println("Carregamos " + carregados + " registros.");
	}
}
