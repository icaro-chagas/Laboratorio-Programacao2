package facade;

import cliente.ControlerCliente;
import fornecedor.ControlerFornecedor;
import utilidades.Util;

/**
 * 
 * @author Aluno de per?odo anterior
 *
 */
public class ControlerCentral {
	
	/**
	 * 
	 */
	ControlerCliente cc = new ControlerCliente();

	/**
	 * 
	 */
	ControlerFornecedor cf = new ControlerFornecedor();

	/**
	 * 
	 */
	public ControlerCentral() {
		this.cc = new ControlerCliente();
		this.cf = new ControlerFornecedor();
	}

	/**
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 * @return
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cc.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public String exibeCliente(String cpf) {
		return this.cc.exibeCliente(cpf);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeClientes() {
		return this.cc.listaClientes();
	}

	/**
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * 
	 * @param cpf
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}

	/**
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.cf.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		return this.cf.exibeFornecedor(nome);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeFornecedores() {
		return this.cf.listaFornecedores();
	}

	/**
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.cf.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * 
	 * @param nome
	 */
	public void removeFornecedor(String nome) {
		this.cf.removeFornecedor(nome);
	}

	/**
     * Cadastra produto comum para um fornecedor qualquer.
     * 
     * @param fornecedor Nome do Fornecedor.
     * @param nome Nome do produto.
     * @param descricao Descri??o do produto.
     * @param preco Pre?o do produto.
     */
	public void adicionaProdutoComum(String fornecedor, String nome, String descricao, double preco) {
		this.cf.adicionaProdutoComum(fornecedor, nome, descricao, preco);
	}
	
	/**
     * Cadastra produto combo para um fornecedor qualquer.
     * 
     * @param fornecedor Nome do Fornecedor.
     * @param nome Nome do produto.
     * @param descricao Descri??o do produto.
     * @param fator Fator de promo??o do produto.
     * @param listaProdutos Lista de produtos comuns que comp?em o produto combo.
     */
	public void adicionaProdutoCombo(String fornecedor, String nome, String descricao, double fator, String listaProdutos) {
		this.cf.adicionaProdutoCombo(fornecedor, nome, descricao, fator, listaProdutos);
	}

	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @return
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return this.cf.exibeProduto(fornecedor, nome, descricao);
	}

	/**
	 * 
	 * @param fornecedor
	 * @return
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.cf.listaProdutos(fornecedor);
	}

	/**
	 * 
	 * @return
	 */
	public String exibeProdutos() {
		return this.cf.listaTodosProdutos();
	}

	/**
     * Altera o pre?o de um produto comum.
     * 
     * @param nome Nome do produto.
     * @param descricao Descri??o do produto.
     * @param fornecedor Nome do Fornecedor.
     * @param novoPreco Novo pre?o do produto.
     */
	public void editaProdutoComum(String fornecedor, String nome, String descricao, double novoPreco) {
		this.cf.editaProdutoComum(fornecedor, nome, descricao, novoPreco);
	
	}
	
	/**
     * Altera o fator de promo??o de um produto combo.
     * 
     * @param nome Nome do produto.
     * @param descricao Descri??o do produto.
     * @param fornecedor Nome do Fornecedor.
     * @param novoFator Novo fator de promo??o do produto.
     */
	public void editaProdutoCombo(String nome, String descricao, String fornecedor, double novoFator) {
		this.cf.editaProdutoCombo(nome, descricao, fornecedor, novoFator);
	}
	/**
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		this.cf.removeProduto(fornecedor, nome, descricao);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @param data
	 * @param nomeProduto
	 * @param descricaoProduto
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto,
			String descricaoProduto) {
		double precoProduto = 0;

		try {

			precoProduto = this.cf.getPrecoProduto(fornecedor, nomeProduto, descricaoProduto);

		} catch (IllegalArgumentException iae) {
			if (iae.getMessage().equals("Erro ao pegar preco do produto: fornecedor nao existe.")) {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
			}

			if (iae.getMessage().equals("Erro ao pegar preco do produto: produto nao existe.")) {
				throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
			}

			if (iae.getMessage().equals("Erro ao pegar preco do produto: fornecedor nao pode ser vazio ou nulo.")) {
				throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
			}

			if (iae.getMessage()
					.equals("Erro ao pegar preco do produto: nome do produto nao pode ser vazio ou nulo.")) {
				throw new IllegalArgumentException(
						"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
			}

			if (iae.getMessage()
					.equals("Erro ao pegar preco do produto: descricao do produto nao pode ser vazia ou nula.")) {
				throw new IllegalArgumentException(
						"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
			}
		}

		catch (NullPointerException npe) {
			if (npe.getMessage().equals("Erro ao pegar preco do produto: fornecedor nao pode ser vazio ou nulo.")) {
				throw new NullPointerException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
			}

			if (npe.getMessage()
					.equals("Erro ao pegar preco do produto: nome do produto nao pode ser vazio ou nulo.")) {
				throw new NullPointerException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
			}

			if (npe.getMessage()
					.equals("Erro ao pegar preco do produto: descricao do produto nao pode ser vazia ou nula.")) {
				throw new NullPointerException(
						"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
			}
		}

		this.cc.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto, precoProduto);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */
	public double getDebito(String cpf, String fornecedor) {
		Util.testaNull(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

		if (!this.cf.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}

		return this.cc.getDebito(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @param fornecedor
	 * @return
	 */
	public String exibeContas(String cpf, String fornecedor) {
		Util.testaNull(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		Util.testaVazio(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

		if (!this.cf.existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}

		return this.cc.exibeContas(cpf, fornecedor);
	}

	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public String exibeContasClientes(String cpf) {
		return this.cc.exibeContasClientes(cpf);
	}
	
	/**
	 * 
	 * @param criterio
	 */
	public void ordenaPor(String criterio) {
		this.cc.ordenaComprasPor(criterio);
	}
	
	/**
	 * 
	 * @return
	 */
	public String listarCompras() {
		return this.cc.listarCompras();
	}
}
