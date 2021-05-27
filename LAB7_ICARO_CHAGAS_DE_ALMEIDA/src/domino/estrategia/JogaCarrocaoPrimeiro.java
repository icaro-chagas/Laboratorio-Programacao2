package domino.estrategia;

import java.util.LinkedList;
import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

/**
 * Seleciona (caso exista) o(s) carroção(ões) na mão do jogador. Assim, a jogada gerada sempre seleciona 
 * a primeira peça do tipo carroção que encaixa na mesa. Caso uma peça possa ser encaixada em ambos os lados da 
 * mesa, jogadas no lado direito são escolhidas prioritariamente.
 */
public class JogaCarrocaoPrimeiro implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		
		List<Peca> carrocoes = new LinkedList<>();
		for(Peca peca: mao) {
			if (peca.isCarrocao()) {
				carrocoes.add(peca);
			}
		}
		
		if (mesa.getNumPecas() == 0) {
			if (carrocoes.size() > 0) {
				return new Jogada(carrocoes.get(0), TipoJogada.NA_DIREITA);
			}
			else {
				return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
			}
		}

		for (Peca peca : carrocoes) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
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
