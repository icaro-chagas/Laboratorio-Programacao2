package domino.US2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domino.JogadaInvalidaException;
import domino.Jogo;
import domino.Peca;
import domino.Jogo.TipoVitoria;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaPrimeiraPossivel;

class JogoTestUS2 {

	@Test
	void testPontuacaoPorJogo() throws EstrategiaInvalidaException, JogadaInvalidaException {
		
		// Vitória do Jogador 1 com batida normal (última peça na esquerda) 
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j1 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j1.jogaJogoCompleto();
		
		assertEquals("J1", j1.getVencedor());
		assertEquals(1, j1.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_NORMAL, j1.getTipoVitoriaVencedor());
		// ------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com batida normal (última peça na direita) 
		List<Peca> mao3 = List.of(new Peca(0, 3), new Peca(4, 5));
		List<Peca> mao4 = List.of(new Peca(0, 2), new Peca(3, 5));
		
		Jogo j2 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao3, mao4);
		
		j2.jogaJogoCompleto();
		
		assertEquals("J2", j2.getVencedor());
		assertEquals(1, j2.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_NORMAL, j2.getTipoVitoriaVencedor());
		// ------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 1 com desempate por contagem de peças. 
		List<Peca> mao5 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao6 = List.of(new Peca(0, 1), new Peca(2, 2), new Peca(2, 3));
		
		Jogo j3 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao5, mao6);
		
		j3.jogaJogoCompleto();
		
		assertEquals("J1", j3.getVencedor());
		assertEquals(1, j3.getPontuacaoVencedor());
		assertEquals(TipoVitoria.DESEMPATE_NUMERO_PECAS, j3.getTipoVitoriaVencedor());
		// ------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com desempate por contagem de peças. 
		List<Peca> mao7 = List.of(new Peca(0, 0), new Peca(2, 2), new Peca(2, 3));
		List<Peca> mao8 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j4 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao7, mao8);
		
		j4.jogaJogoCompleto();
		
		assertEquals("J2", j4.getVencedor());
		assertEquals(1, j4.getPontuacaoVencedor());
		assertEquals(TipoVitoria.DESEMPATE_NUMERO_PECAS, j4.getTipoVitoriaVencedor());
		// ------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 1 com desempate por contagem de pontos.
		List<Peca> mao9 = List.of(new Peca(0, 0), new Peca(4, 3));
		List<Peca> mao10 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j5 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao9, mao10);
		
		j5.jogaJogoCompleto();
		
		assertEquals("J1", j5.getVencedor());
		assertEquals(1, j5.getPontuacaoVencedor());
		assertEquals(TipoVitoria.DESEMPATE_CONTAGEM_PONTOS, j5.getTipoVitoriaVencedor());
		// -------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com desempate por contagem de pontos. 
		List<Peca> mao11 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao12 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j6 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao11, mao12);
		
		j6.jogaJogoCompleto();
		
		assertEquals("J2", j6.getVencedor());
		assertEquals(1, j6.getPontuacaoVencedor());
		assertEquals(TipoVitoria.DESEMPATE_CONTAGEM_PONTOS, j6.getTipoVitoriaVencedor());
		
		// --------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 1 com batida de carroça (última peça na direita). 
		List<Peca> mao13 = List.of(new Peca(0, 0), new Peca(2, 2));
		List<Peca> mao14 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j7 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao13, mao14);
		
		j7.jogaJogoCompleto();
		
		assertEquals("J1", j7.getVencedor());
		assertEquals(2, j7.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_CARROCA, j7.getTipoVitoriaVencedor());
		// --------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com batida de carroça (última peça na esquerda).
		List<Peca> mao15 = List.of(new Peca(3, 0), new Peca(5, 6));
		List<Peca> mao16 = List.of(new Peca(4, 3), new Peca(4, 4));
		
		Jogo j8 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao15, mao16);
		
		j8.jogaJogoCompleto();
		
		assertEquals("J2", j8.getVencedor());
		assertEquals(2, j8.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_CARROCA, j8.getTipoVitoriaVencedor());
		// -------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 1 com batida de lá e ló (última peça na direita).
		List<Peca> mao17 = List.of(new Peca(0, 0), new Peca(2, 2), new Peca(2, 3));
		List<Peca> mao18 = List.of(new Peca(0, 2), new Peca(0, 3), new Peca(0, 4));
		
		Jogo j9 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao17, mao18);
		
		j9.jogaJogoCompleto();

		assertEquals("J1", j9.getVencedor());
		assertEquals(3, j9.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_LA_E_LO, j9.getTipoVitoriaVencedor());
		// -------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com batida de lá e ló (última peça na direita)
		List<Peca> mao19 = List.of(new Peca(0, 0), new Peca(2, 2), new Peca(0, 4));
		List<Peca> mao20 = List.of(new Peca(0, 2), new Peca(0, 3), new Peca(2, 3));
		
		Jogo j10 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao19, mao20);
		
		j10.jogaJogoCompleto();
		
		assertEquals("J2", j10.getVencedor());
		assertEquals(3, j10.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_LA_E_LO, j10.getTipoVitoriaVencedor());
		// ---------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 1 com batida de carroça cruzada (última peça na direita)
		List<Peca> mao21 = List.of(new Peca(0, 1), new Peca(2, 0), new Peca(0, 0));
		List<Peca> mao22 = List.of(new Peca(1, 2), new Peca(6, 3));
		
		Jogo j11 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao21, mao22);
		
		j11.jogaJogoCompleto();
		
		assertEquals("J1", j11.getVencedor());
		assertEquals(6, j11.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_CARROCA_CRUZADA, j11.getTipoVitoriaVencedor());
		// ---------------------------------------------------------------------------------------------------
		
		
		// Vitória do Jogador 2 com batida de carroça cruzada (última peça na direita)
		List<Peca> mao23 = List.of(new Peca(0, 1), new Peca(1, 2), new Peca(0, 0));
		List<Peca> mao24 = List.of(new Peca(2, 0), new Peca(2, 2));
		
		Jogo j12 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao23, mao24);
		
		j12.jogaJogoCompleto();
		
		assertEquals("J2", j12.getVencedor());
		assertEquals(6, j12.getPontuacaoVencedor());
		assertEquals(TipoVitoria.BATIDA_CARROCA_CRUZADA, j12.getTipoVitoriaVencedor());
		//----------------------------------------------------------------------------------------------------
		
		
		// Empate 
		List<Peca> mao25 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao26 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j13 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao25, mao26);
		
		j13.jogaJogoCompleto();
		
		assertEquals(0, j13.getPontuacaoVencedor());
		assertNull(j13.getVencedor());
		assertNull(j13.getTipoVitoriaVencedor());
		//----------------------------------------------------------------------------------------------------
	}

}
