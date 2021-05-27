package produto;

public class ProdutoComum extends Produto {

	
	/**
	 * Constroí um produto comum.
	 * 
	 * @param nome Nome do produto comum.
	 * @param descricao Descrição do produto comum.
	 * @param preco Preço do produto comum.
	 */
	public ProdutoComum(String nome, String descricao, double preco) {
		super(nome, descricao, preco);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Altera o preço de um produto comum.
	 * 
	 * @param novoPreco Novo valor atribuído ao atributo precoBase.
	 */
	private void setPreco(double novoPreco) {
		this.precoBase = novoPreco;
	}

	/**
	 * Modifica o preço de um produto comum.
	 * 
	 * @param novoValor Novo valor atribuído ao atributo preço.
	 */
	@Override
	public void modificaProduto(double novoValor) {
		this.setPreco(novoValor);
	}

}
