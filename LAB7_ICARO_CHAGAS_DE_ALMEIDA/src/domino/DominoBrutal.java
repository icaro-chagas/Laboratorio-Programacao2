package domino;

import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaPrimeiraPossivel;

/**
 * Exemplo de como fazer uma disputa entre duas estratégias em uma UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), 
						  "J2", new JogaPrimeiraPossivel(), 
						  12);

		HistoricoDeJogo historico;
		
		try {
			historico = j.jogaJogoCompleto();
			System.out.println(historico.toString());
		} catch (EstrategiaInvalidaException e) {
			e.printStackTrace();
		} catch (JogadaInvalidaException e) {
			e.printStackTrace();
		}
		
	}

}

