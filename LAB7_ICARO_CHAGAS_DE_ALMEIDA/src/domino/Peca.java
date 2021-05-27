package domino;

/**
 * Uma peça de dominó com dois lados.
 *
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;
	private Boolean temNumMaisRepetido;

	/**
	 * Cria uma peça.
	 * 
	 * @param numEsquerdo Número do lado esquerdo.
	 * @param numDireito  Número do lado direito.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
		this.temNumMaisRepetido = false;
	}

	/**
	 * Inverte os lados dos números na peça.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O número da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O número da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}
	
	/**
	 * Fornece a soma dos pontos nos dois lados da peça.
	 * @return A soma dos pontos da peça.
	 */
	public int getNumPontos() {
		return numDireito + numEsquerdo;
	}
	
	/**
	 * Determina se a peça é do tipo carroção.
	 * @return Valor booleano que estabelece se a peça é do tipo carroção.
	 */
	public boolean isCarrocao() {
		if (numDireito == numEsquerdo) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Determina se a peça contém o número mais repetido na mão 
	 * de um jogador.
	 * @param comando Valor booleano atrelado ao atributo temNumMaisRepetido.
	 */
	public void setTemNumMaisRepetido(boolean comando) {
		this.temNumMaisRepetido = comando;
	}
	
	/**
	 * Fornece um valor booleano que específica se a peça contém o número 
	 * mais repetido na mão de um jogador.
	 * @return Valor booleano que estabelece se a peça tem o número mais 
	 * repetido na mão de um jogador. 
	 */
	public Boolean getTemNumMaisRepetido() {
		return this.temNumMaisRepetido;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a peça encaixa com um número.
	 * 
	 * @param numero O número a testar.
	 * @return true se um dos lados ao menos combinar com o número.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}

}
