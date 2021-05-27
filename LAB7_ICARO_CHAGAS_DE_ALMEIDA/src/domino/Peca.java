package domino;

/**
 * Uma pe�a de domin� com dois lados.
 *
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;
	private Boolean temNumMaisRepetido;

	/**
	 * Cria uma pe�a.
	 * 
	 * @param numEsquerdo N�mero do lado esquerdo.
	 * @param numDireito  N�mero do lado direito.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
		this.temNumMaisRepetido = false;
	}

	/**
	 * Inverte os lados dos n�meros na pe�a.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O n�mero da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O n�mero da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}
	
	/**
	 * Fornece a soma dos pontos nos dois lados da pe�a.
	 * @return A soma dos pontos da pe�a.
	 */
	public int getNumPontos() {
		return numDireito + numEsquerdo;
	}
	
	/**
	 * Determina se a pe�a � do tipo carro��o.
	 * @return Valor booleano que estabelece se a pe�a � do tipo carro��o.
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
	 * Determina se a pe�a cont�m o n�mero mais repetido na m�o 
	 * de um jogador.
	 * @param comando Valor booleano atrelado ao atributo temNumMaisRepetido.
	 */
	public void setTemNumMaisRepetido(boolean comando) {
		this.temNumMaisRepetido = comando;
	}
	
	/**
	 * Fornece um valor booleano que espec�fica se a pe�a cont�m o n�mero 
	 * mais repetido na m�o de um jogador.
	 * @return Valor booleano que estabelece se a pe�a tem o n�mero mais 
	 * repetido na m�o de um jogador. 
	 */
	public Boolean getTemNumMaisRepetido() {
		return this.temNumMaisRepetido;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a pe�a encaixa com um n�mero.
	 * 
	 * @param numero O n�mero a testar.
	 * @return true se um dos lados ao menos combinar com o n�mero.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}

}
