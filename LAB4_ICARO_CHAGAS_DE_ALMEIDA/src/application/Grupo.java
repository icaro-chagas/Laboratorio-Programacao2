package application;

import java.util.HashSet;
	
	/**
	 * Classe que representa um grupo de estudo composto por alunos.
	 * 
	 * @author Ícaro Chagas de Almeida - 119210960
	 */

public class Grupo {
	
	/**
	 * Nome do grupo de estudo.
	 */
	private String nome;
	
	/**
	 * Conjunto de alunos cadastrados em um grupo de estudo.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Cria um grupo de estudo.
	 * 
	 * @param nome String que representa o nome de um grupo de estudo.
	 */
	public Grupo(String nome) {
		
		if (nome == null) {
			throw new NullPointerException("Entrada inválida para o atributo nomeGrupo (valor nulo)");
		}
		
		else if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo nomeGrupo (string vazia)");
		}
		
		this.nome = nome;
		alunos = new HashSet<>();
	}
	
	/**
	 * Fornece o conjunto de alunos que compõe o grupo de estudo.
	 * 
	 * @return O conjunto de alunos do grupo de estudo.
	 */
	public HashSet<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * Método hasCode sobrescrito para a classe Grupo.
	 * 
	 * @return O hashCode que identifica a classe Grupo.
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	/**
	 * Método equals sobrescrito para a classe Grupo.
	 * 
	 * @return Um valor booleano que determina se dois objetos da classe Grupo são iguais.
	 * 
	 * @param o Objeto que passa por comparação;
	 */
	@Override
	public boolean equals(Object o) {
	    if (o == null) { 
	    	return false; 
	    }
	    if (o.getClass() != this.getClass()) { 
	    	return false; 
	    }
	    
	    Grupo oGrupo = (Grupo) o;
	    return this.nome.equals(oGrupo.nome);
	 }

	/**
	 * Método toString sobrescrito para a classe Grupo.
	 * 
	 * @return A representação da classe Grupo especificando os alunos que 
	 * compõem um grupo.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nAlunos do grupo " + nome + ":\n");
		
		for (Aluno a: alunos) {
			sb.append(" * " + a.toString() + "\n");
		}
		return sb.toString();
	}
	
}
