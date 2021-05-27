package domino.US3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domino.Peca;

class PecaTestUS3 {

	@Test
	void testIsCarrocao() {
	
		Peca peca0 = new Peca(0, 0);
		Peca peca1 = new Peca(1, 1);
		Peca peca2 = new Peca(2, 2);
		Peca peca3 = new Peca(3, 3);
		Peca peca4 = new Peca(4, 4);
		Peca peca5 = new Peca(5, 5);
		Peca peca6 = new Peca(6, 6);
		
		Peca peca7 = new Peca(0, 1);
		Peca peca8 = new Peca(1, 2);
		Peca peca9 = new Peca(2, 3);
		Peca peca10 = new Peca(3, 4);
		Peca peca11 = new Peca(4, 5);
		Peca peca12 = new Peca(5, 6);
		Peca peca13 = new Peca(6, 0);

		assertTrue(peca0.isCarrocao());
		assertTrue(peca1.isCarrocao());
		assertTrue(peca2.isCarrocao());
		assertTrue(peca3.isCarrocao());
		assertTrue(peca4.isCarrocao());
		assertTrue(peca5.isCarrocao());
		assertTrue(peca6.isCarrocao());
		
		assertFalse(peca7.isCarrocao());
		assertFalse(peca8.isCarrocao());
		assertFalse(peca9.isCarrocao());
		assertFalse(peca10.isCarrocao());
		assertFalse(peca11.isCarrocao());
		assertFalse(peca12.isCarrocao());
		assertFalse(peca13.isCarrocao());
	}
	
	@Test
	void testTemNumMaisRepetido() {
		Peca peca1 = new Peca(0, 0);
		Peca peca2 = new Peca(1, 1);
		
		peca1.setTemNumMaisRepetido(true);
		assertTrue(peca1.getTemNumMaisRepetido());
		
		peca2.setTemNumMaisRepetido(false);
		assertFalse(peca2.getTemNumMaisRepetido());
	}

}
