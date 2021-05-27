package application;

import java.util.ArrayList;
import java.util.HashMap;

	/**
	 * Sistema de Controle de Alunos responsável pela manipulação das informações relativas 
	 * a alunos e grupos de estudo. 
	 * 
	 * @author Ícaro Chagas de Almeida - 119210960
	 */
public class ControleDeAlunos {
	
	/**
	 * Mapa de alunos indentificados por suas respectivas matrículas.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Mapa de grupos identificados por seus respectivos nomes.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Lista composta do registro de alunos que responderam questões no quadro.
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
	 * @param matricula String que representa a matrícula de um Aluno.
	 * @param nome String que representa o nome de um aluno.
	 * @param curso String que representa o nome do curso de um aluno.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, do cadastro de um aluno.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inválida para o atributo matricula (valor nulo) [método: cadastraAluno]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo matricula (string vazia) [método: cadastraAluno]");
		}
		
		if (alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!";
		}
		else {
			alunos.put(matricula, new Aluno(matricula, nome, curso));
			return "CADASTRO REALIZADO!";
		}
		
	}
	/**
	 * Exibe um aluno cadastrado no sistema a partir de sua respectiva matrícula.
	 * 
	 * @param matricula String que representa a matrícula de um Aluno.
	 * @return Uma String que exibe as informações de um aluno cadastrado no sistema,
	 * ou uma mensagem declarando a impossibilidade do cadastro.
	 */
	public String exibeAluno(String matricula) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inválida para o atributo matricula (valor nulo) [método: exibeAluno]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo matricula (string vazia) [método: exibeAluno]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.";
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
			throw new NullPointerException("Entrada inválida para o atributo nomeGrupo (valor nulo) [método: cadastraNovoGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo nomeGrupo (string vazia) [método: cadastraNovoGrupo]");
		}
		
		if (grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "GRUPO JÁ CADASTRADO!";
		}
		else {
			grupos.put(nomeGrupo.toLowerCase(), new Grupo(nomeGrupo));
			return "CADASTRO REALIZADO!";
		}	
	}
	
	/**
	 * Aloca um aluno em um grupo de estudo.
	 * 
	 * @param matricula String que representa a matrícula de um Aluno.
	 * @param nomeGrupo String que representa o nome de um grupo de estudo.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, da alocação 
	 * de um aluno em um grupo, ou declara a inexistência do grupo no Sistema.
	 */
	public String alocaAlunoEmGrupo(String matricula, String nomeGrupo) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inválida para o atributo matricula (valor nulo) [método: alocaAlunoEmGrupo]");
		}
		
		if (nomeGrupo == null) {
			throw new NullPointerException("Entrada inválida para o atributo nomeGrupo (valor nulo) [método: alocaAlunoEmGrupo]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo matricula (string vazia) [método: alocaAlunoEmGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo nomeGrupo (string vazia) [método: alocaAlunoEmGrupo]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo não cadastrado.";
		}
		
		grupos.get(nomeGrupo.toLowerCase()).getAlunos().add(alunos.get(matricula));
		return "ALUNO ALOCADO!";
	}
	
	/**
	 * Imprime uma relação dos alunos, e suas respectivas informações, que fazem parte
	 * de um grupo de esuto.
	 * 
	 * @param nomeGrupo String que representa o nome de um grupo de estudo.
	 * @return Uma String que informa os alunos que fazem parte um grupo de estudo, ou
	 * uma mensagem declarando que o grupo de estudo não está cadastrado no sistema.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		
		if (nomeGrupo == null) {
			throw new NullPointerException("Entrada inválida para o atributo nomeGrupo (valor nulo) [método: imprimeGrupo]");
		}
		
		else if ("".equals(nomeGrupo.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo nomeGrupo (string vazia) [método: imprimeGrupo]");
		}
		
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo não cadastrado.\n";
		}
		
		return grupos.get(nomeGrupo.toLowerCase()).toString();
	}
	
	/**
	 * Registra aluno que respondeu alguma questão no quadro.
	 * 
	 * @param matricula String que representa a matrícula de um Aluno.
	 * @return Uma String que informa quanto ao sucesso, ou fracasso, do registro 
	 * de um aluno na lista de alunos que responderam questões no quadro.
	 */
	public String registraAlunoQueRepondeu(String matricula) {
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inválida para o atributo matricula (valor nulo) [método: registraAlunoQueRepondeu]");
		}
		
		else if ("".equals(matricula.strip())) {
			throw new IllegalArgumentException("Entrada inválida para o atributo matricula (string vazia) [método: registraAlunoQueRepondeu]");
		}
		
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		
		registroDeRespostas.add(alunos.get(matricula));
		return "ALUNO REGISTRADO!";
	}
	
	/**
	 * Imprime de forma ordenada uma relação dos alunos que responderam questões no quadro.
	 * 
	 * @return Uma String que detalha as informações dos alunos que responderam questões no quadro.
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

