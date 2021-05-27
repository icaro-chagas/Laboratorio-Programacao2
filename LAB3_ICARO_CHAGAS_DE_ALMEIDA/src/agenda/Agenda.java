package agenda;

import java.util.Arrays;

/**
 * Uma agenda que mant�m uma lista de contatos com posi��es. Podem existir 100 contatos. 
 * 
 * @author Adaptado por: �caro Chagas de Almeida (Autor Original: Nazareno Andrade)
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	/**
	 * Array de contatos da agenda.
	 */
	private Contato[] contatos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato espec�fico.
	 * @param posicao Posi��o do contato na agenda.
	 * @return Dados do contato. Retorna a string "POSI��O INV�LIDA!" caso a posi��o do array seja do tipo null,
	 * caso contr�rio retorna o m�todo toString(), da classe Contato, para o contato da posi��o requisitado.
	 */
	public String getContato(int posicao) {
		if (contatos[posicao-1] == null) {
			return "POSI��O INV�LIDA!";
		}
		else {
			return contatos[posicao-1].toString();
		}
		
	}

	/**
	 * Cadastra um contato em uma posi��o do array contatos. Um cadastro em uma posi��o que j� existe sobrescreve o anterior. 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 1� telefone do contato. 
	 * @param telefone2 2� telefone do contato.
	 * @param telefone3 3� telefone do contato.
	 * @param telPrincipal Telefone priorit�rio do contato.
	 * @param telWhatsapp N�mero de Whatsapp do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int telPrincipal, int telWhatsapp) {
		
		this.contatos[posicao-1] = new Contato(nome, sobrenome, telefone1, telefone2, telefone3, telPrincipal, telWhatsapp);
	}
	
	/**
	 * M�todo equals sobrescrito para a classe Agenda.
	 * 
	 * @return Um valor boleano que determina se dois objetos da classe Agenda s�o iguais.
	 * 
	 * @param o Objeto sujeito a compara��o;
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		Agenda oAgenda = (Agenda) o;
		
		return Arrays.equals(contatos,oAgenda.contatos);
	}
	
	/**
	 * M�todo hasCode sobrescrito para a classe Agenda.
	 * 
	 * @return O hashCode que identifica a classe Agenda.
	 */
	@Override
	public int hashCode() {
		
		return Arrays.hashCode(contatos);
	}
}
