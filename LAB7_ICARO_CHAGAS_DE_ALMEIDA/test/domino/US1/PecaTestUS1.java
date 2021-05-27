package domino.US1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domino.Peca;

class PecaTestUS1 {

	@Test
	void testPontosPeca() {
		assertEquals(12, (new Peca(6, 6)).getNumPontos());
		assertEquals(5, (new Peca(0, 5)).getNumPontos());
		assertEquals(7, (new Peca(2, 5)).getNumPontos());
		assertEquals(0, (new Peca(0, 0)).getNumPontos());
	}

}
