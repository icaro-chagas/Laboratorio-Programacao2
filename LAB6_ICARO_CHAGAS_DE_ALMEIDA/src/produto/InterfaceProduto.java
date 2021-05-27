package produto;

/**
 * Interface elaborada para ser implementada pela classe genérica Produto
 * 
 * @author Ícaro Chagas de Almeida
 */
public interface InterfaceProduto {

	/**
	 * Fornece o nome de um produto.
	 * 
	 * @return O nome do profuto.
	 */
	public String getNome();
	
	/**
	 * Fornece a descrição de um produto.
	 * 
	 * @return Descrição do Produto.
	 */
	public String getDescricao();
	
	/**
	 * Fornece o preço base de um produto.
	 * 
	 * @return O preço base do produto.
	 */
	public double getPreco();
	
	/**
	 * Modifica um atributo de um produto.
	 * @param novoValor Novo valor atribuído a um atributo.
	 */
	public void modificaProduto(double novoValor);
}
