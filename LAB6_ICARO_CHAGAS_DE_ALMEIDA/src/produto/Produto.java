package produto;

/**
 * Classe gen�rica representativa de um produto (produto comum, ou produto combo).
 * 
 * @author �caro Chagas de Almeida
 *
 */
public abstract class Produto implements InterfaceProduto {
	
	/**
	 * Nome do produto.
	 */
	private String nome;
	
	/**
	 * Descri��o do produto.
	 */
	private String descricao;
	
	/**
	 * Pre�o base do produto.
	 */
	protected double precoBase;
	
	/**
	 * Constr�i um produto.
	 * 
	 * @param nome Nome do produto.
	 * @param descricao Descri��o do produto.
	 * @param precoBase Pre�o base do produto.
	 */
	public Produto(String nome, String descricao, double precoBase) {
		if (nome == null) {
			throw new NullPointerException("Erro no Produto: nome nao pode ser nulo.");
		}
		
		else if (descricao == null) {
			throw new NullPointerException("Erro no Produto: descricao nao pode ser nula.");
		}
		
		if ("".equals(nome.strip())) {
			throw new IllegalArgumentException("Erro no Produto: nome nao pode ser vazio.");
		}
		
		else if ("".equals(descricao.strip())) {
			throw new IllegalArgumentException("Erro no Produto: descricao nao pode ser vazia.");
		}
		
		if (precoBase <= 0) {
			throw new IllegalArgumentException("Erro no Produto: preco inv�lido.");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.precoBase = precoBase;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public double getPreco() {
		return this.precoBase;
	}
	
	public abstract void modificaProduto(double novoValor);
	
	/**
   	 * M�todo equals sobrescrito para a classe Produto.
   	 * 
   	 * @param o Objeto que passa por compara��o. 
   	 * @return Um valor booleano que determina se dois objetos da classe Produto s�o iguais.
   	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		Produto oProduto = (Produto) o;
		return this.getNome().equals(oProduto.getNome()) && this.getDescricao().equals(oProduto.getDescricao());
	}
	
	/**
	 * M�todo hasCode sobrescrito para a classe Produto.
	 * 
	 * @return O hashCode que identifica um objeto da classe Produto.
	 */
	@Override
	public int hashCode() {
    	return this.getNome().hashCode() + this.getDescricao().hashCode();
    }
	
	/**
   	 * M�todo toString sobrescrito para a classe Produto.
   	 * 
   	 * @return A representa��o da classe Produto especificando o nome do produto,
   	 * a descri��o, e o seu Pre�o.
   	 */
	@Override
	public String toString() {
		String precoString = String.format("%.2f", this.getPreco());
		return this.getNome() + " - " + this.getDescricao() + " - R$" + precoString.replace(".",",");
	}
}
