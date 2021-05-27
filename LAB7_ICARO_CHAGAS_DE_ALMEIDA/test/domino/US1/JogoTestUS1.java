package domino.US1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domino.Jogo;
import domino.Peca;
import domino.estrategia.JogaPrimeiraPossivel;

class JogoTestUS1 {

	@Test
	void testDesempateOuEmpate() throws Exception {
		
		// Após passe de ambos jogadores: QuantidadeDePecasJ1 < QuantidadeDePecasJ2; NumPontosJ1 > NumPontosJ2
		//----------------------------------------------------------------------------------------------------
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(2, 2), new Peca(2, 3));
		
		Jogo j1 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j1.jogaJogoCompleto();

		assertTrue(j1.isFinalizado());
		assertEquals("J1", j1.getVencedor());
		//----------------------------------------------------------------------------------------------------
		
				
		// Após passe de ambos jogadores: QuantidadeDePecasJ1 > QuantidadeDePecasJ2; NumPontosJ1 < NumPontosJ2
		//----------------------------------------------------------------------------------------------------
		List<Peca> mao3 = List.of(new Peca(0, 0), new Peca(2, 2), new Peca(2, 3));
		List<Peca> mao4 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j2 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao3, mao4);
		
		j2.jogaJogoCompleto();

		assertTrue(j2.isFinalizado());
		assertEquals("J2", j2.getVencedor());
		//----------------------------------------------------------------------------------------------------
			
		
		// Após passe de ambos jogadores: QuantidadeDePecasJ1 == QuantidadeDePecasJ2; NumPontosJ1 < NumPontosJ2
		//----------------------------------------------------------------------------------------------------
		List<Peca> mao5 = List.of(new Peca(0, 0), new Peca(4, 3));
		List<Peca> mao6 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j3 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao5, mao6);
		
		j3.jogaJogoCompleto();

		assertTrue(j3.isFinalizado());
		assertEquals("J1", j3.getVencedor());
		//----------------------------------------------------------------------------------------------------
		
		
		// Após passe de ambos jogadores: QuantidadeDePecasJ1 == QuantidadeDePecasJ2; NumPontosJ1 > NumPontosJ2
		//----------------------------------------------------------------------------------------------------
		List<Peca> mao7 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao8 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j4 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao7, mao8);
		
		j4.jogaJogoCompleto();
		
		assertTrue(j4.isFinalizado());
		assertEquals("J2", j4.getVencedor());
		//----------------------------------------------------------------------------------------------------
		
		
		// Após passe de ambos jogadores: QuantidadeDePecasJ1 = QuantidadeDePecasJ2; NumPontosJ1 = NumPontosJ2
		//----------------------------------------------------------------------------------------------------
		List<Peca> mao9 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao10 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j5 = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao9, mao10);
		
		j5.jogaJogoCompleto();
		
		assertTrue(j5.isFinalizado());
		assertTrue(j5.isResultadoEmpate());
		assertNull(j5.getVencedor());
		//----------------------------------------------------------------------------------------------------
		
	}
}


