package domino.estrategia.US3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.JogaNumMenosRepetido;

class JogaNumMenosRepetidoTest {

	private Mesa mesa, mesa2;
	
	@BeforeEach
	void initJogaCarrocaoPrimeiro() throws Exception {
		mesa = new Mesa();
		mesa2 = new Mesa();
		mesa.jogaNaDireita(new Peca(0, 2));
		mesa.jogaNaEsquerda(new Peca(0, 3));
		
	}
	
	@Test
	void testJogaNumMenosRepetidoPrimeiroComMesaVazia() {
		
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		Jogada j = estrategia.decideJogada(mesa2, List.of(new Peca(3, 2), new Peca(3, 3), new Peca(5, 3), new Peca(1, 1)));
		
		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(1, j.getPeca().getNumEsquerdo());
		assertEquals(1, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPassa() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(5, 0), new Peca(5, 5), new Peca(5, 4), new Peca(1, 1)));

		assertEquals(TipoJogada.PASSA, j.getTipo());
		assertNull(j.getPeca());
	}
	
	@Test
	void testPrefereJogarNumMenosRepetido() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(2, 1), new Peca(2, 2), new Peca(3, 5)));
		
		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereJogarPrimeiraPecaComNumMenosRepetido() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(2, 5), new Peca(2, 1), new Peca(2, 2), new Peca(3,5), new Peca(3,6)));
		
		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereJogarNumMenosRepetidoNaDireita() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(5, 3),  new Peca(5, 2), new Peca(5, 5), new Peca(2, 3)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaNumMenosRepetidoNaEsquerda() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();

		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(5, 3),  new Peca(5, 2), new Peca(5, 5), new Peca(0, 3)));

		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(0, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPrimeiraPossivelComMesaVaziaNaAusenciaDeNumMaisRepetido() {
		
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		Jogada j = estrategia.decideJogada(mesa2, List.of(new Peca(1, 2), new Peca(0, 6), new Peca(5, 3)));
		
		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(1, j.getPeca().getNumEsquerdo());
		assertEquals(2, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPrimeiraPossivelNaAusenciaDeNumMaisRepetido() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();

		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(0, 1), new Peca(2, 5), new Peca(3, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereDireitaNaAusenciaDeNumMaisRepetido() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(2, 3) ,new Peca(3, 3), new Peca(2, 2)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaNaEsquerdaNaAusenciaDeNumMaisRepetido() {
		JogaNumMenosRepetido estrategia = new JogaNumMenosRepetido();

		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(3, 3) ,new Peca(2, 3), new Peca(2, 2)));

		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}

}
