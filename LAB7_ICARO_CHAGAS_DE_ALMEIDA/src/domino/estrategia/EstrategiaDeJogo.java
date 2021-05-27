package domino.estrategia;

import java.util.List;

import domino.Jogada;
import domino.Peca;

/**
 * Uma estrat�gia para jogar em uma partida de domin�. � usada pelo jogo para
 * decidir a pr�xima jogada do jogador.
 *
 */
public interface EstrategiaDeJogo {

	/**
	 * Decide a jogada na vez do jogador.
	 * 
	 * @param mesa O estado atual da mesa, com as pe�as j� jogadas.
	 * @param mao  As pe�as dispon�veis para o jogador.
	 * @return Uma Jogada
	 */
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao);
}