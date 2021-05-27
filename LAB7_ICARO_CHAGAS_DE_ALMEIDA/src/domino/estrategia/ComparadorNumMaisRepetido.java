package domino.estrategia;

import java.util.Comparator;

import domino.Peca;

/**
 * Classe comparadora utilizada para ordenar uma lista de peças de acordo
 * com o retorno do método getTemNumMaisRepetido da Classe Peca.
 * 
 * @author Ícaro Chagas de Almeida - 119210960
 */
public class ComparadorNumMaisRepetido implements Comparator<Peca> {

	@Override
	public int compare(Peca p1, Peca p2) {
		return p1.getTemNumMaisRepetido().compareTo(p2.getTemNumMaisRepetido()); 
	}
}
