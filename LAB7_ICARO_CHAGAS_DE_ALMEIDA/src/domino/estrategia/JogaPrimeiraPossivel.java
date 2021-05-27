/**
 * 
 */
package domino.estrategia;

import java.util.List;

import domino.Jogada;
import domino.Jogada.TipoJogada;
import domino.Peca;

/**
 * Joga sempre a primeira pe�a que encaixa. Tenta primeiro no lado direito e
 * depois esquerdo, se encaixar em ambas.
 */
public class JogaPrimeiraPossivel implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {

		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : mao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

}
