package domino.estrategia;

import java.util.Comparator;

import domino.Peca;

/**
 * Classe comparadora utilizada para ordenar uma lista de pe�as de acordo
 * com o retorno do m�todo getTemNumMaisRepetido da Classe Peca.
 * 
 * @author �caro Chagas de Almeida - 119210960
 */
public class ComparadorNumMaisRepetido implements Comparator<Peca> {

	@Override
	public int compare(Peca p1, Peca p2) {
		return p1.getTemNumMaisRepetido().compareTo(p2.getTemNumMaisRepetido()); 
	}
}
