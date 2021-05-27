package produto;

public class ProdutoCombo extends Produto {

	private double fator;
	
	
	public ProdutoCombo(String nome, String descricao, double fator, double preco) {
		super(nome, descricao, preco);
		
		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no Produto Combo: fator invalido.");
		}
		
		this.fator = fator;
		
	}
	
	/**
	 * Fornece o preço de um produto combo a partir do preço base e de um
	 * fator de promoção.
	 * 
	 * @return O preço de um produto combo.
	 */
	
	@Override
	public double getPreco() {
		return super.getPreco() - super.getPreco()*this.fator;
	}
	
	/**
	 * Altera o preço de um produto combo.
	 * 
	 * @param novoFator Novo valor atribuído ao atributo fator.
	 */
	private void setFator(double novoFator) {
		this.fator = novoFator;
	}
	
	/**
	 * Modifica o preço de um produto combo.
	 * 
	 * @param novoValor Novo valor atribuído ao atributo fator.
	 */
	@Override
	public void modificaProduto(double novoValor) {
		this.setFator(novoValor);
		
	}

}
