package application;
	
	/**
	 * Classe que representa um aluno de um curso qualquer.
	 * 
	 * @author �caro Chagas de Almeida - 119210960
	 */

public class Aluno {

	/**
	 * Matr�cula de um aluno.
	 */
	private String matricula;
	
	/**
	 * Nome de um Aluno.
	 */
	private String nome;
	
	/**
	 * Curso em que um aluno est� matr�culado.
	 */
	private String curso;
	
	/**
	 * Cria um Aluno.
	 * 
	 * @param matricula String que representa a matr�cula de um Aluno.
	 * @param nome String que representa o nome de um aluno.
	 * @param curso String que representa o nome do curso de um aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo matricula (valor nulo)");
		}
		
		else if (nome == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo nome (valor nulo)");
		}
		
		else if (curso == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo curso (valor nulo)");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo matricula (string vazia)");
		}
		
		else if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo nome (string vazia)");
		}
		
		else if ("".equals(curso.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo curso (string vazia)");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * M�todo hasCode sobrescrito para a classe Aluno.
	 * 
	 * @return O hashCode que identifica a classe Aluno.
	 */
	@Override
	public int hashCode() {
		return this.matricula.hashCode();
	}
	
	/**
	 * M�todo equals sobrescrito para a classe Contato.
	 * 
	 * @return Um valor booleano que determina se dois objetos da classe Contato s�o iguais.
	 * 
	 * @param o Objeto que passa por compara��o;
	 */
	@Override
	public boolean equals(Object o) {
	    if (o == null) { 
	    	return false; 
	    }
	    if (o.getClass() != this.getClass()) { 
	    	return false; 
	    }
	    
	    Aluno oAluno = (Aluno) o;
	    return this.matricula.equals(oAluno.matricula);
	 }

	/**
	 * M�todo toString sobrescrito para a classe Aluno.
	 * 
	 * @return A representa��o da classe Aluno especificando o n�mero de matr�cula,
	 * o nome, e o curso de um aluno.
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
	
	
	
}
