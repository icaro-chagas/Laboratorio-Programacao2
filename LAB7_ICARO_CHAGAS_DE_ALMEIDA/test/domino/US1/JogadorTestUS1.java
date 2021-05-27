package domino.US1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domino.Jogador;
import domino.Peca;
import domino.estrategia.JogaPrimeiraPossivel;

class JogadorTestUS1 {

	@Test
	void testPontosMaoJogador() {
		List<Peca> mao1 = List.of(new Peca(0, 2), new Peca(2, 3), new Peca(4, 3));
		Jogador jogador1 = new Jogador("j", new JogaPrimeiraPossivel(), mao1);
		
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(2, 2), new Peca(2, 3));
		Jogador jogador2 = new Jogador("j", new JogaPrimeiraPossivel(), mao2);
		
		List<Peca> mao3 = List.of(new Peca(0, 0));
		Jogador jogador3 = new Jogador("j", new JogaPrimeiraPossivel(), mao3);
		
		List<Peca> mao4 = List.of(new Peca(6, 6));
		Jogador jogador4 = new Jogador("j", new JogaPrimeiraPossivel(), mao4);
		
		assertEquals(14, jogador1.getPontosMao());
		assertEquals(10, jogador2.getPontosMao());
		assertEquals(0, jogador3.getPontosMao());
		assertEquals(12, jogador4.getPontosMao());
	}

}
