package fornecedor;

import java.util.HashMap;import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import produto.InterfaceProduto;
import produto.ProdutoCombo;
import produto.ProdutoComum;
import utilidades.ComparatorProduto;

/**
 * Classe que representa um fornecedor do sistema
 * 
 * @author Aluno de período anterior
 *
 */
public class Fornecedor {
	/**
	 * Nome do fornecedor
	 */
	private String nome;

	/**
	 * Email do fornecedor
	 */
	private String email;

	/**
	 * Telefone do fornecedor
	 */
	private String telefone;

	/**
	 * Hash map dos produtos que o fornecedor oferece sendo as chaves a concatenação
	 * das String que representam o nome e descrição do produto respectivamente, e
	 * os valores são os objetos que representam os produtos
	 */
	private HashMap<String, InterfaceProduto> produtos;

	/**
	 * ArrayList de Strings que são a concatenação do nome e descrição dos produtos
	 */
	private ArrayList<String> produtosCadastrados;
	
	
	private ArrayList<String> combosCadastrados;

	/**
	 * Comparator que compara dois produtos
	 */
	private Comparator<InterfaceProduto> comparador;

	/**
	 * Constrói um fornecedor dado seu nome, email e telefone
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

		this.produtos = new HashMap<String, InterfaceProduto>();
		this.produtosCadastrados = new ArrayList<String>();
		this.combosCadastrados = new ArrayList<String>();

		this.comparador = new ComparatorProduto();
	}

	/**
	 * Retorna a representação textual do fornecedor no formato "Nome" - "Email" -
	 * "Telefone"
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - " + this.getTelefone();
	}

	/**
	 * Compara dois fornecedores pelo nome
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) o;

			if (this.getNome().equals(f.getNome())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gera o hashCode do fornecedor baseado no nome
	 */
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	/**
	 * Retorna o nome do fornecedor
	 * 
	 * @return String contendo o nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna o telefone do fornecedor
	 * 
	 * @return String contendo o telefone do fornecedor
	 */
	private String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna o email do fornecedor
	 * 
	 * @return String contendo o email do fornecedor
	 */
	private String getEmail() {
		return this.email;
	}

	/**
	 * Redefine o email do fornecedor dado o novo valor
	 * 
	 * @param email Novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Redefine o telefone do fornecedor dado o novo valor
	 * 
	 * @param telefone Novo numero de telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	 /**
     * Cadastra um produto comum do fornecedor.
     * 
     * @param nome Nome do produto.
     * @param descricao Descrição do produto.
     * @param preco Preço do produto.
     */
	public void adicionaProdutoComum(String nome, String descricao, double preco) {
		String key = nome + descricao;
		
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro de produto comum: nome nao pode ser nulo.");
		}
		
		else if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de produto comum: descricao nao pode ser nula.");
		}
		
		if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Erro no cadastro de produto comum: nome nao pode ser vazio.");
		}
		
		else if ("".equals(descricao.strip())) {
			throw new IllegalArgumentException("Erro no cadastro de produto comum: descricao nao pode ser vazia.");
		}
		
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto comum: preco inválido.");
		}
		
		if (this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}

		this.produtos.put(key, new ProdutoComum(nome, descricao, preco));
		this.produtosCadastrados.add(key);

		for (int i = this.produtosCadastrados.size() - 1; i > 0; i--) {
			String produto1 = this.produtosCadastrados.get(i);
			String produto2 = this.produtosCadastrados.get(i - 1);

			InterfaceProduto p1 = this.produtos.get(produto1);
			InterfaceProduto p2 = this.produtos.get(produto2);

			int compare = this.comparador.compare(p1, p2);

			if (compare < 0) {
				Collections.swap(this.produtosCadastrados, i, i - 1);
			}
		}
	}
	
	/**
     * Cadastra um produto combo do fornecedor.
     * 
     * @param nome Nome do produto.
     * @param descricao Descrição do produto.
     * @param fator Fator de promoção do produto combo.
     * @param listaProdutos Lista de produtos comuns que compõe o produto combo.
     */
	public void adicionaProdutoCombo(String nome, String descricao, double fator, String listaProdutos) {
		String key = nome + descricao;
		
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro de produto combo: nome nao pode ser nulo.");
		}
		
		else if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de produto combo: descricao nao pode ser nula.");
		}
		
		else if (listaProdutos == null) {
			throw new NullPointerException("Erro no cadastro de produto combo: lista de produtos não pode ser nula");
		}
		
		if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Erro no cadastro de produto combo: nome nao pode ser vazio.");
		}
		
		else if ("".equals(descricao.strip())) {
			throw new IllegalArgumentException("Erro no cadastro de produto combo: descricao nao pode ser vazia.");
		}
		
		else if ("".equals(listaProdutos.strip())) {
			throw new IllegalArgumentException("Erro no cadastro de produto combo: lista de produtos não pode ser vazia.");
		}
		
		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de produto combo: fator invalido.");
		}
		
		if (this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		
		String[] vecProdutos = listaProdutos.split(",");
		
		double precoTotal = 0;
		for (int i = 0; i < vecProdutos.length; i++) {
			
			String idProduto = vecProdutos[i].replace(" - ", "").strip();
			
			if (this.combosCadastrados.contains(idProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			
			if (!this.produtos.containsKey(idProduto)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			
			precoTotal += produtos.get(idProduto).getPreco();
		}


		this.produtos.put(key, new ProdutoCombo(nome, descricao, fator, precoTotal));
		this.combosCadastrados.add(key);
		this.produtosCadastrados.add(key);

		for (int i = this.produtosCadastrados.size() - 1; i > 0; i--) {
			String produto1 = this.produtosCadastrados.get(i);
			String produto2 = this.produtosCadastrados.get(i - 1);

			InterfaceProduto p1 = this.produtos.get(produto1);
			InterfaceProduto p2 = this.produtos.get(produto2);

			int compare = this.comparador.compare(p1, p2);

			if (compare < 0) {
				Collections.swap(this.produtosCadastrados, i, i - 1);
			}
		}
	}

	/**
	 * Exibe um produto do fornecedor dado o nome e a descricao do produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @return Representação String do produto
	 */
	public String exibeProduto(String nome, String descricao) {
		if (!this.produtos.containsKey(nome + descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

		return this.produtos.get(nome + descricao).toString();
	}

	/**
	 * Lista todos os produtos do forncedor em ordem alfabética do nome do produto
	 * 
	 * @return String contendo a lista de todos os produtos do fornecedor
	 */
	public String listaProdutos() {
		String retorno = this.getNome() + " -";

		for (int i = 0; i < this.produtosCadastrados.size(); i++) {
			String produto = this.produtosCadastrados.get(i);

			if (i == 0) {
				retorno += " " + this.produtos.get(produto).toString();
			}

			else {
				retorno += " | " + this.getNome() + " - " + this.produtos.get(produto).toString();
			}
		}

		return retorno;
	}


	/**
     * Edita o preço de um produto comum.
     * 
     * @param nome Nome do produto.
     * @param descricao Descrição do produto.
     * @param novoPreco Novo preço do produto comum.
     */
	public void editaProdutoComum(String nome, String descricao, double novoPreco) {
		String key = nome + descricao;
		
		if (nome == null) {
			throw new NullPointerException("Erro na edição de produto comum: nome nao pode ser nulo.");
		}
		
		else if (descricao == null) {
			throw new NullPointerException("Erro na edição de produto comum: descricao nao pode ser nula.");
		}
		
		if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Erro na edição de produto comum: nome nao pode ser vazio.");
		}
		
		else if ("".equals(descricao.strip())) {
			throw new IllegalArgumentException("Erro na edição de produto comum: descricao nao pode ser vazia.");
		}
		
		if (novoPreco <= 0) {
			throw new IllegalArgumentException("Erro na edição de produto comum: preco inválido.");
		}

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}

		this.produtos.get(key).modificaProduto(novoPreco);

	}
	
	/**
     * Edita o preço de um produto combo.
     * 
     * @param nome Nome do produto.
     * @param descricao Descrição do produto.
     * @param novoFator Novo fator de promoção do produto combo.
     */
	public void editaProdutoCombo(String nome, String descricao, double novoFator) {
		String key = nome + descricao;
		
		if (nome == null) {
			throw new NullPointerException("Erro na edição de produto combo: nome nao pode ser nulo.");
		}
		
		else if (descricao == null) {
			throw new NullPointerException("Erro na edição de produto combo: descricao nao pode ser nula.");
		}
		
		if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Erro na edição de produto combo: nome nao pode ser vazio.");
		}
		
		else if ("".equals(descricao.strip())) {
			throw new IllegalArgumentException("Erro na edição de produto combo: descricao nao pode ser vazia.");
		}
		
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edição de produto combo: fator invalido.");
		}
		
		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}

		this.produtos.get(key).modificaProduto(novoFator);

	}
	
	/**
	 * Remove um produto do fornecedor
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 */
	public void removeProduto(String nome, String descricao) {
		String key = nome + descricao;

		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}

		this.produtos.remove(key);

		this.produtosCadastrados.remove(key);
	}

	/**
	 * Retorna o preco de um produto dado o nome e descricao do produto
	 * 
	 * @param nomeProduto      Nome do produto
	 * @param descricaoProduto Descricao do produto
	 * @return Preco do produto
	 */
	public double getPrecoProduto(String nomeProduto, String descricaoProduto) {
		if (!this.produtos.containsKey(nomeProduto + descricaoProduto)) {
			throw new IllegalArgumentException("Erro ao pegar preco do produto: produto nao existe.");
		}

		return this.produtos.get(nomeProduto + descricaoProduto).getPreco();
	}

}
