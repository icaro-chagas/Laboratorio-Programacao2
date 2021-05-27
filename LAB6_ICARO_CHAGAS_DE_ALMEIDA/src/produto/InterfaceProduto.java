package produto;

/**
 * Interface elaborada para ser implementada pela classe gen�rica Produto
 * 
 * @author �caro Chagas de Almeida
 */
public interface InterfaceProduto {

	/**
	 * Fornece o nome de um produto.
	 * 
	 * @return O nome do profuto.
	 */
	public String getNome();
	
	/**
	 * Fornece a descri��o de um produto.
	 * 
	 * @return Descri��o do Produto.
	 */
	public String getDescricao();
	
	/**
	 * Fornece o pre�o base de um produto.
	 * 
	 * @return O pre�o base do produto.
	 */
	public double getPreco();
	
	/**
	 * Modifica um atributo de um produto.
	 * @param novoValor Novo valor atribu�do a um atributo.
	 */
	public void modificaProduto(double novoValor);
}
