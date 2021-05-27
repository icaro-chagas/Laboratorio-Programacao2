package application;

import java.util.ArrayList;
import java.util.HashMap;

	/**
	 * Sistema de Controle de Alunos respons�vel pela manipula��o das informa��es relativas 
	 * a alunos e grupos de estudo. 
	 * 
	 * @author �caro Chagas de Almeida - 119210960
	 */
public class ControleDeAlunos {
	
	/**
	 * Mapa de alunos indentificados por suas respectivas matr�culas.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Mapa de grupos identificados por seus respectivos nomes.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Lista composta do registro de alunos que responderam quest�es no quadro.
	 */
	private ArrayList<Aluno> registroDeRespostas;
	
	/**
	 * Cria um Sistema de Controle de Alunos.
	 */
	public ControleDeAlunos() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.registroDeRespostas = new ArrayList<>();
	}
	
	/**
	 * Cadastra um aluno no Sistema.
	 * 
	 * @param matricula String que representa a matr�cula de um Aluno.
	 * @param nome String que representa o nome de um aluno.
	 * @param curso String que representa o nome do curso de um aluno.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, do cadastro de um aluno.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo matricula (valor nulo) [m�todo: cadastraAluno]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo matricula (string vazia) [m�todo: cadastraAluno]");
		}
		
		if (alunos.containsKey(matricula)) {
			return "MATR�CULA J� CADASTRADA!";
		}
		else {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
			return "CADASTRO REALIZADO!";
		}
		
	}
	/**
	 * Exibe um aluno cadastrado no sistema a partir de sua respectiva matr�cula.
	 * 
	 * @param matricula String que representa a matr�cula de um Aluno.
	 * @return Uma String que exibe as informa��es de um aluno cadastrado no sistema,
	 * ou uma mensagem declarando a impossibilidade do cadastro.
	 */
	public String exibeAluno(String matricula) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo matricula (valor nulo) [m�todo: exibeAluno]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo matricula (string vazia) [m�todo: exibeAluno]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "\nAluno n�o cadastrado.";
		}
		
		return "\nAluno: " + alunos.get(matricula).toString();
	}
	
	/**
	 * Cadastra novo grupo de estudo no Sistema.
	 * 
	 * @param nomeGrupo String que representa o nome de um grupo de estudo.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, do cadastro 
	 * de um grupo de estudo.
	 */
	public String cadastraNovoGrupo(String nomeGrupo) {
		
		if (nomeGrupo == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo nomeGrupo (valor nulo) [m�todo: cadastraNovoGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo nomeGrupo (string vazia) [m�todo: cadastraNovoGrupo]");
		}
		
		if (grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "GRUPO J� CADASTRADO!";
		}
		else {
			grupos.put(nomeGrupo.toLowerCase(), new Grupo(nomeGrupo));
			return "CADASTRO REALIZADO!";
		}	
	}
	
	/**
	 * Aloca um aluno em um grupo de estudo.
	 * 
	 * @param matricula String que representa a matr�cula de um Aluno.
	 * @param nomeGrupo String que representa o nome de um grupo de estudo.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, da aloca��o 
	 * de um aluno em um grupo, ou declara a inexist�ncia do grupo no Sistema.
	 */
	public String alocaAlunoEmGrupo(String matricula, String nomeGrupo) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo matricula (valor nulo) [m�todo: alocaAlunoEmGrupo]");
		}
		
		if (nomeGrupo == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo nomeGrupo (valor nulo) [m�todo: alocaAlunoEmGrupo]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo matricula (string vazia) [m�todo: alocaAlunoEmGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo nomeGrupo (string vazia) [m�todo: alocaAlunoEmGrupo]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "Aluno n�o cadastrado.";
		}
		
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo n�o cadastrado.";
		}
		
		grupos.get(nomeGrupo.toLowerCase()).getAlunos().add(alunos.get(matricula));
		return "ALUNO ALOCADO!";
	}
	
	/**
	 * Imprime uma rela��o dos alunos, e suas respectivas informa��es, que fazem parte
	 * de um grupo de esuto.
	 * 
	 * @param nomeGrupo String que representa o nome de um grupo de estudo.
	 * @return Uma String que informa os alunos que fazem parte um grupo de estudo, ou
	 * uma mensagem declarando que o grupo de estudo n�o est� cadastrado no sistema.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		
		if (nomeGrupo == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo nomeGrupo (valor nulo) [m�todo: imprimeGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo nomeGrupo (string vazia) [m�todo: imprimeGrupo]");
		}
		
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo n�o cadastrado.\n";
		}
		
		return grupos.get(nomeGrupo.toLowerCase()).toString();
	}
	
	/**
	 * Registra aluno que respondeu alguma quest�o no quadro.
	 * 
	 * @param matricula String que representa a matr�cula de um Aluno.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, do registro 
	 * de um aluno na lista de alunos que responderam quest�es no quadro.
	 */
	public String registraAlunoQueRepondeu(String matricula) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inv�lida para o atributo matricula (valor nulo) [m�todo: registraAlunoQueRepondeu]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inv�lida para o atributo matricula (string vazia) [m�todo: registraAlunoQueRepondeu]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "Aluno n�o cadastrado.";
		}
		
		registroDeRespostas.add(alunos.get(matricula));
		return "ALUNO REGISTRADO!";
	}
	
	/**
	 * Imprime de forma ordenada uma rela��o dos alunos que responderam quest�es no quadro.
	 * 
	 * @return Uma String que detalha as informa��es dos alunos que responderam quest�es no quadro.
	 */
	public String imprimeAlunosQueResponderam() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nAlunos:\n");
		
		for (int i = 0; i < registroDeRespostas.size(); i++) {
			sb.append((i+1) + ". " + registroDeRespostas.get(i).toString() + "\n");
		}
		
		return sb.toString();
	}
	
}

