package produto;

/**
 * Classe genérica representativa de um produto (produto comum, ou produto combo).
 * 
 * @author Ícaro Chagas de Almeida
 *
 */
public abstract class Produto implements InterfaceProduto {
	
	/**
	 * Nome do produto.
	 */
	private String nome;
	
	/**
	 * Descrição do produto.
	 */
	private String descricao;
	
	/**
	 * Preço base do produto.
	 */
	protected double precoBase;
	
	/**
	 * Constrói um produto.
	 * 
	 * @param nome Nome do produto.
	 * @param descricao Descrição do produto.
	 * @param precoBase Preço base do produto.
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
			throw new IllegalArgumentException("Erro no Produto: preco inválido.");
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
   	 * Método equals sobrescrito para a classe Produto.
   	 * 
   	 * @param o Objeto que passa por comparação. 
   	 * @return Um valor booleano que determina se dois objetos da classe Produto são iguais.
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
	 * Método hasCode sobrescrito para a classe Produto.
	 * 
	 * @return O hashCode que identifica um objeto da classe Produto.
	 */
	@Override
	public int hashCode() {
    	return this.getNome().hashCode() + this.getDescricao().hashCode();
    }
	
	/**
   	 * Método toString sobrescrito para a classe Produto.
   	 * 
   	 * @return A representação da classe Produto especificando o nome do produto,
   	 * a descrição, e o seu Preço.
   	 */
	@Override
	public String toString() {
		String precoString = String.format("%.2f", this.getPreco());
		return this.getNome() + " - " + this.getDescricao() + " - R$" + precoString.replace(".",",");
	}
}
