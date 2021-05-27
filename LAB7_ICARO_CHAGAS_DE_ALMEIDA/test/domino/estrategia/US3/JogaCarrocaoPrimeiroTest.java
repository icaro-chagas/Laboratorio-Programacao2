package domino.estrategia.US3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.JogadaInvalidaException;
import domino.estrategia.JogaCarrocaoPrimeiro;
import domino.estrategia.JogaPrimeiraPossivel;

class JogaCarrocaoPrimeiroTest {

	private Mesa mesa, mesa2;
	
	@BeforeEach
	void initJogaCarrocaoPrimeiro() throws Exception {
		mesa = new Mesa();
		mesa2 = new Mesa();
		mesa.jogaNaDireita(new Peca(0, 2));
		mesa.jogaNaEsquerda(new Peca(0, 3));
		
	}
	
	@Test
	void testJogaCarrocaoPrimeiroComMesaVazia() {
		
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		Jogada j = estrategia.decideJogada(mesa2, List.of(new Peca(1, 2), new Peca(0, 3), new Peca(5, 3), new Peca(1, 1)));
		
		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(1, j.getPeca().getNumEsquerdo());
		assertEquals(1, j.getPeca().getNumDireito());
	}

	@Test
	void testPassa() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(5, 5), new Peca(4, 1)));

		assertEquals(TipoJogada.PASSA, j.getTipo());
		assertNull(j.getPeca());
	}
	
	@Test
	void testPrefereJogarCarrocao() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(3,5), new Peca(2, 1), new Peca(2, 2)));
		
		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(2, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereJogarPrimeiroCarrocao() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(3,5), new Peca(3, 3), new Peca(2, 2)));
		
		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereJogarCarrocaoNaDireita() throws JogadaInvalidaException {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		// mesa = 3:0 0:2
		mesa.jogaNaDireita(new Peca(2,3));
		// mesa = 3:0 0:2 2:3
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(3,5), new Peca(3, 3)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaCarrocaoNaEsquerda() throws JogadaInvalidaException {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		// mesa = 3:0 0:2
		mesa.jogaNaEsquerda(new Peca(3,5));
		// mesa = 5:3 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(0, 1), new Peca(5, 5), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(5, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPrimeiraPossivelComMesaVaziaNaAusenciaDeCarrocao() {
		
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();
		
		Jogada j = estrategia.decideJogada(mesa2, List.of(new Peca(1, 2), new Peca(0, 3), new Peca(5, 3), new Peca(0, 1)));
		
		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(1, j.getPeca().getNumEsquerdo());
		assertEquals(2, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaPrimeiraPossivelNaAusenciaDeCarrocao() {
		JogaCarrocaoPrimeiro estrategia = new JogaCarrocaoPrimeiro();

		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(0, 1), new Peca(2, 5), new Peca(3, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}
	
	@Test
	void testPrefereDireitaNaAusenciaDeCarrocao() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();
		
		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(1, 0), new Peca(2, 3), new Peca(2, 5)));

		assertEquals(TipoJogada.NA_DIREITA, j.getTipo());
		assertEquals(2, j.getPeca().getNumEsquerdo());
		assertEquals(3, j.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaNaEsquerdaNaAusenciaDeCarrocao() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		// mesa = 3:0 0:2
		Jogada j = estrategia.decideJogada(mesa, List.of(new Peca(1, 0), new Peca(3, 5), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j.getTipo());
		assertEquals(3, j.getPeca().getNumEsquerdo());
		assertEquals(5, j.getPeca().getNumDireito());
	}

}
