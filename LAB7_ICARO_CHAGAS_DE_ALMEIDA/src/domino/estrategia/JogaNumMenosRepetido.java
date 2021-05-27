package domino.estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

/**
 * Ordena a lista que contém a mão do jogador de modo que a(s) peça(s) com número(s) mais repetido(s) 
 * é/são deslocada(s) para a direita. Como resultado, a jogada gerada sempre seleciona a primeira peça com 
 * número menos repetido que encaixa na mesa. Caso uma peça possa ser encaixada em ambos os lados da mesa, 
 * jogadas no lado direito são escolhidas prioritariamente.
 */
public class JogaNumMenosRepetido implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
		List<Peca> pecas = new LinkedList<Peca>(mao);
		
		for (Peca peca: pecas) {
			peca.setTemNumMaisRepetido(false);
		}
		
    	int numPecasCom0 = 0, numPecasCom1 = 0, numPecasCom2 = 0, numPecasCom3 = 0,
    	    numPecasCom4 = 0, numPecasCom5 = 0, numPecasCom6 = 0;
		
    	for (Peca peca: pecas) {
    		
    		if (peca.encaixa(0)) {
    			numPecasCom0++;
    		}
    		if (peca.encaixa(1)) {
    			numPecasCom1++;
    		}
    		if (peca.encaixa(2)) {
    			numPecasCom2++;
    		}
    		if (peca.encaixa(3)) {
    			numPecasCom3++;
    		}
    		if (peca.encaixa(4)) {
    			numPecasCom4++;
    		}
    		if (peca.encaixa(5)) {
    			numPecasCom5++;
    		}
    		if (peca.encaixa(6)) {
    			numPecasCom6++;
    		}
    	}
    	
    	List<Integer> relacaoRepeticaoNumsPecas = List.of(numPecasCom0, numPecasCom1, numPecasCom2, numPecasCom3, 
    			                                          numPecasCom4, numPecasCom5, numPecasCom6);
    	
    	int maiorRepeticao = 0;
    	for (int i: relacaoRepeticaoNumsPecas) {
    		if (i > maiorRepeticao) {
    			maiorRepeticao = i;
    		}
    	}
    	
    	List<Integer> numsComMaiorRepeticao = new ArrayList<>();
    	for (int i = 0; i < relacaoRepeticaoNumsPecas.size(); i++) {
    		if (relacaoRepeticaoNumsPecas.get(i) == maiorRepeticao) {
    			numsComMaiorRepeticao.add(i);
    		}
    	}
    	
    	for (Peca peca: pecas) {
    		if (numsComMaiorRepeticao.contains(peca.getNumDireito()) || numsComMaiorRepeticao.contains(peca.getNumEsquerdo())) {
    			peca.setTemNumMaisRepetido(true);
    		}
    	}
    	
    	Comparator<Peca> comparador = new ComparadorNumMaisRepetido();

    	Collections.sort(pecas, comparador);
    	
    	if (mesa.getNumPecas() == 0) {
			return new Jogada(pecas.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : pecas) {
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
