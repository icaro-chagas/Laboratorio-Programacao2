package agenda;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Adaptado por: Ícaro Chagas de Almeida (Autor Original: Nazareno Andrade)
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
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Retorna a string "POSIÇÃO INVÁLIDA!" caso a posição do array seja do tipo null,
	 * caso contrário retorna o método toString(), da classe Contato, para o contato da posição requisitado.
	 */
	public String getContato(int posicao) {
		if (contatos[posicao-1] == null) {
			return "POSIÇÃO INVÁLIDA!";
		}
		else {
			return contatos[posicao-1].toString();
		}
		
	}

	/**
	 * Cadastra um contato em uma posição do array contatos. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 1º telefone do contato. 
	 * @param telefone2 2º telefone do contato.
	 * @param telefone3 3º telefone do contato.
	 * @param telPrincipal Telefone prioritário do contato.
	 * @param telWhatsapp Número de Whatsapp do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int telPrincipal, int telWhatsapp) {
		
		this.contatos[posicao-1] = new Contato(nome, sobrenome, telefone1, telefone2, telefone3, telPrincipal, telWhatsapp);
	}
	
	/**
	 * Método equals sobrescrito para a classe Agenda.
	 * 
	 * @return Um valor boleano que determina se dois objetos da classe Agenda são iguais.
	 * 
	 * @param o Objeto sujeito a comparação;
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
	 * Método hasCode sobrescrito para a classe Agenda.
	 * 
	 * @return O hashCode que identifica a classe Agenda.
	 */
	@Override
	public int hashCode() {
		
		return Arrays.hashCode(contatos);
	}
}
