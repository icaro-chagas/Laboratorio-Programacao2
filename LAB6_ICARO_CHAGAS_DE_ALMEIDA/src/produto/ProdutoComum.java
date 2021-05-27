package produto;

public class ProdutoComum extends Produto {

	
	/**
	 * Constro� um produto comum.
	 * 
	 * @param nome Nome do produto comum.
	 * @param descricao Descri��o do produto comum.
	 * @param preco Pre�o do produto comum.
	 */
	public ProdutoComum(String nome, String descricao, double preco) {
		super(nome, descricao, preco);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Altera o pre�o de um produto comum.
	 * 
	 * @param novoPreco Novo valor atribu�do ao atributo precoBase.
	 */
	private void setPreco(double novoPreco) {
		this.precoBase = novoPreco;
	}

	/**
	 * Modifica o pre�o de um produto comum.
	 * 
	 * @param novoValor Novo valor atribu�do ao atributo pre�o.
	 */
	@Override
	public void modificaProduto(double novoValor) {
		this.setPreco(novoValor);
	}

}
