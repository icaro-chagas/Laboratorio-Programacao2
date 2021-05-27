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
	 * Fornece o pre�o de um produto combo a partir do pre�o base e de um
	 * fator de promo��o.
	 * 
	 * @return O pre�o de um produto combo.
	 */
	
	@Override
	public double getPreco() {
		return super.getPreco() - super.getPreco()*this.fator;
	}
	
	/**
	 * Altera o pre�o de um produto combo.
	 * 
	 * @param novoFator Novo valor atribu�do ao atributo fator.
	 */
	private void setFator(double novoFator) {
		this.fator = novoFator;
	}
	
	/**
	 * Modifica o pre�o de um produto combo.
	 * 
	 * @param novoValor Novo valor atribu�do ao atributo fator.
	 */
	@Override
	public void modificaProduto(double novoValor) {
		this.setFator(novoValor);
		
	}

}
