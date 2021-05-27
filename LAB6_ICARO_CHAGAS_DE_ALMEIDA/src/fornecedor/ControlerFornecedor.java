package fornecedor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import utilidades.Util;

/**
 * 
 * Classe que representa o controlador dos fornecedores cadastrados no sistema
 * 
 * @author Aluno de per�odo anterior
 *
 */
public class ControlerFornecedor {
	/**
	 * HashMap que armazena todos os fornecedores, onde a chave � o nome do
	 * fornecedor e o valor � o fornecedor
	 */
	private HashMap<String, Fornecedor> fornecedores;

	/**
	 * Lista com o nome de todos os fornecedores cadastrados no sistema, ordenados
	 * em ordem alfabetica
	 */
	private ArrayList<String> nomesCadastrados;

	/**
	 * Contr�i o controlador de fornecedores, n�o recebe nenhum par�metro, s�
	 * inicializa as variaveis
	 */
	public ControlerFornecedor() {
		this.fornecedores = new HashMap<String, Fornecedor>();
		this.nomesCadastrados = new ArrayList<String>();
	}

	/**
	 * Adiciona um fornecedor ao sistema dado seu nome, telefone e email
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 * @return Nome do fornecedor cadastrado
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		Util.testaNull(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");

		Util.testaNull(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		Util.testaVazio(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");

		Util.testaNull(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		Util.testaVazio(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

		if (this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		this.nomesCadastrados.add(nome);

		for (int i = this.nomesCadastrados.size() - 1; i > 0; i--) {
			String nome1 = this.nomesCadastrados.get(i);
			String nome2 = this.nomesCadastrados.get(i - 1);

			int compare = nome1.compareTo(nome2);

			if (compare < 0) {
				Collections.swap(this.nomesCadastrados, i, i - 1);
			}

		}

		return nome;
	}

	/**
	 * Retorna a representa��o textual de um fornecedor dado o seu nome
	 * 
	 * @param nome Nome do fornecedor que se deseja obter a representa��o textual
	 * @return String que � a representa��o textual do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		Util.testaNull(nome, "Erro na exibicao do fornecedor: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na exibicao do fornecedor: fornecedor nao pode ser vazio ou nulo.");

		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}

		return this.fornecedores.get(nome).toString();
	}

	/**
	 * Retorna uma lista dosfornecedores em String.
	 * 
	 * @return String que � a lista de todos os fornecedores cadastrados no sistema.
	 */
	public String listaFornecedores() {
		String retorno = "";

		for (int i = 0; i < this.nomesCadastrados.size(); i++) {
			String nome = this.nomesCadastrados.get(i);

			if (i == 0) {
				retorno += this.fornecedores.get(nome).toString();
			}

			else {
				retorno += " | " + this.fornecedores.get(nome).toString();
			}
		}

		return retorno;
	}

	/**
	 * Edita um fornecedor dado o nome do fornecedor, o atributo que se deseja
	 * editar e o novo valor.
	 * 
	 * @param nome      Nome dor fornecedor que se deseja editar.
	 * @param atributo  Nome do atributo que se deseja editar.
	 * @param novoValor Novo valor que se deseja atribuir ao atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		Util.testaNull(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");

		Util.testaNull(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		Util.testaVazio(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");

		Util.testaNull(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		Util.testaVazio(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

		if (atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}

		if (!atributo.equals("email") && !atributo.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}

		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}

		if (atributo.equals("email")) {
			this.fornecedores.get(nome).setEmail(novoValor);
		}

		if (atributo.equals("telefone")) {
			this.fornecedores.get(nome).setTelefone(novoValor);
		}
	}

	/**
	 * Remove um fornecedor do cadastro dado o nome do fornecedor
	 * 
	 * @param nome Nome do fornecedor que se deseja remover.
	 */
	public void removeFornecedor(String nome) {
		Util.testaNull(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");

		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}

		this.fornecedores.remove(nome);

		for (int i = 0; i < this.nomesCadastrados.size(); i++) {
			if (this.nomesCadastrados.get(i).equals(nome)) {
				this.nomesCadastrados.remove(i);
				break;
			}
		}
	}

	/**
     * Cadastra produto comum para um fornecedor qualquer.
     * 
     * @param fornecedor Nome do Fornecedor.
     * @param nome Nome do produto.
     * @param descricao Descri��o do produto.
     * @param preco Pre�o do produto.
     */
	public void adicionaProdutoComum(String fornecedor, String nome, String descricao, double preco) {
		Util.testaNull(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}

		this.fornecedores.get(fornecedor).adicionaProdutoComum(nome, descricao, preco);
	}
	
	/**
     * Cadastra produto combo para um fornecedor qualquer.
     * 
     * @param fornecedor Nome do Fornecedor.
     * @param nome Nome do produto.
     * @param descricao Descri��o do produto.
     * @param fator Fator de promo��o do produto.
     * @param listaProdutos Lista de produtos comuns que comp�em o produto combo.
     */
	public void adicionaProdutoCombo(String fornecedor, String nome, String descricao, double fator, String listaProdutos) {
		Util.testaNull(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		
		Util.testaNull(listaProdutos, "Erro no cadastro de combo: combo deve ter produtos.");
		Util.testaVazio(listaProdutos, "Erro no cadastro de combo: combo deve ter produtos.");

		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}

		this.fornecedores.get(fornecedor).adicionaProdutoCombo(nome, descricao, fator, listaProdutos);
	}

	/**
	 * Exibe um produto de um fornecedor, dado o nome do fornecedor, o nome e a
	 * descri��o do produto
	 * 
	 * @param nome       Nome do produto
	 * @param descricao  Descri��o do porduto
	 * @param fornecedor Nome do fornecedor
	 * @return String que � a representa��o textual do produto
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		Util.testaNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);

	}

	/**
	 * Lista todos os produtos de um fornecedor em ordem alfab�tica
	 * 
	 * @param fornecedor Nome do fornecedor
	 * @return String que � a lista de todos os produtos que esse fornecedor oferece
	 *         ordenados em ordem alfab�tica do nome do produto
	 */
	public String listaProdutos(String fornecedor) {
		Util.testaNull(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		return this.fornecedores.get(fornecedor).listaProdutos();
	}

	/**
	 * Lista todos os produtos de todos os forncedores em ordem alfab�tica dos
	 * fornecedores e dos produtos
	 * 
	 * @return String que � uma lista de todos os produtos de todos os fornecedores
	 *         em ordem alfab�tica do nome dos forncedores e dos produtos
	 */
	public String listaTodosProdutos() {
		String retorno = "";

		for (int i = 0; i < this.nomesCadastrados.size(); i++) {
			String fornecedor = this.nomesCadastrados.get(i);

			if (i == 0) {
				retorno += this.fornecedores.get(fornecedor).listaProdutos();
			}

			else {
				retorno += " | " + this.fornecedores.get(fornecedor).listaProdutos();
			}
		}

		return retorno;
	}

	/**
     * Altera o pre�o de um produto comum.
     * 
     * @param nome Nome do produto.
     * @param descricao Descri��o do produto.
     * @param fornecedor Nome do Fornecedor.
     * @param novoPreco Novo pre�o do produto.
     */
	public void editaProdutoComum(String nome, String descricao, String fornecedor, double novoPreco) {
		Util.testaNull(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

		Util.testaNull(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");

		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}

		this.fornecedores.get(fornecedor).editaProdutoComum(nome, descricao, novoPreco);

	}
	
	/**
     * Altera o fator de promo��o de um produto combo.
     * 
     * @param nome Nome do produto.
     * @param descricao Descri��o do produto.
     * @param fornecedor Nome do Fornecedor.
     * @param novoFator Novo fator de promo��o do produto.
     */
	public void editaProdutoCombo(String nome, String descricao, String fornecedor, double novoFator) {
		Util.testaNull(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");

		Util.testaNull(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");

		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}

		this.fornecedores.get(fornecedor).editaProdutoCombo(nome, descricao, novoFator);

	}

	/**
	 * Remove o produto de um fornecedor dado o nome do fornecedor e o nome e
	 * descricao do produto.
	 * 
	 * @param nome       Nome do produto
	 * @param descricao  Decricao do produto
	 * @param fornecedor Nome do fornecedor
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		Util.testaNull(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		Util.testaVazio(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");

		Util.testaNull(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		Util.testaVazio(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}

		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);

	}

	/**
	 * Retorna o preco de um produto dado o nome do fornecedor, nome e descricao do
	 * produto
	 * 
	 * @param fornecedor       Nome do fornecedor
	 * @param nomeProduto      Nome do produto
	 * @param descricaoProduto Descricao do produto
	 * @return Double que � o preco do produto
	 */
	public double getPrecoProduto(String fornecedor, String nomeProduto, String descricaoProduto) {

		Util.testaNull(fornecedor, "Erro ao pegar preco do produto: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro ao pegar preco do produto: fornecedor nao pode ser vazio ou nulo.");

		Util.testaNull(nomeProduto, "Erro ao pegar preco do produto: nome do produto nao pode ser vazio ou nulo.");
		Util.testaVazio(nomeProduto, "Erro ao pegar preco do produto: nome do produto nao pode ser vazio ou nulo");

		Util.testaNull(descricaoProduto,
				"Erro ao pegar preco do produto: descricao do produto nao pode ser vazia ou nula.");
		Util.testaVazio(descricaoProduto,
				"Erro ao pegar preco do produto: decricao do produto nao pode ser vazia ou nula.");

		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao pegar preco do produto: fornecedor nao existe.");
		}

		return this.fornecedores.get(fornecedor).getPrecoProduto(nomeProduto, descricaoProduto);
	}

	/**
	 * Verifica se existe um fornecedor no sistema dado o nome do fornecedor
	 * 
	 * @param fornecedor Nome do fornecedor que se deseja saber se ele existe no
	 *                   sistema
	 * @return True caso exista, false caso contr�rio
	 */
	public boolean existeFornecedor(String fornecedor) {
		if (this.fornecedores.containsKey(fornecedor)) {
			return true;
		}

		return false;
	}
}
