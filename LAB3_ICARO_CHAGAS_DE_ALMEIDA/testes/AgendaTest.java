import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agenda.Agenda;

import org.junit.jupiter.api.BeforeEach;

class AgendaTest {

	private Agenda a1 = new Agenda();
	private Agenda a2 = new Agenda();
	
	@BeforeEach
	public void initAgenda() {
		
		a1.cadastraContato(1, "Matheus", "Gaudêncio", "98788-8979", "3213-2131", "3213-7873", 1, 1);
		a1.cadastraContato(2, "Lívia", "Sampaio", "9873-7383", "3213-3313", "9887-80987", 2, 1);
		a1.cadastraContato(3, "Fábio", "Morais", "98790-1323", "3231-8383", "", 1, 1);
		a1.cadastraContato(4, "Nazareno", "Andrade", "99979-6564", "99875-3210", " ", 2, 2);
		
		a2.cadastraContato(1, "Matheus", "Gaudêncio", "98788-8979", "3213-2131", "3213-7873", 1, 1);
		a2.cadastraContato(2, "Lívia", "Sampaio", "9873-7383", "3213-3313", "9887-80987", 2, 1);
		a2.cadastraContato(3, "Fábio", "Morais", "98790-1323", "3231-8383", "", 1, 1);
		a2.cadastraContato(4, "Nazareno", "Andrade", "99979-6564", "99875-3210", " ", 2, 2);

	}
	
	@Test
	public void testaHashcode() {
		assertEquals(a1.hashCode(),a2.hashCode());
	}
	
	@Test
	public void testaEqualsObjetosIguais() {
		assertEquals(a1,a2);
	}
	
	@Test
	public void testaEqualsObjetosDiferrentes() {
		a2.cadastraContato(4, "Nazareno", "Torres", "99979-6564", "99875-3210", " ", 2, 2);
		assertNotEquals(a1,a2); 
	}
	
	@Test
	public void testaNovaAtribuicao() {
		a2.cadastraContato(2, "João", "Almeida", "(83) 99873-7383", "(83) 98301-9238", "(83) 99979-6564", 3, 2);
		assertEquals(a2.getContato(2).toString(),
				"\nJoão Almeida\n" + 
				"(83) 99979-6564 (prioritário)\n" + 
				"(83) 98301-9238 (zap)\n" + 
				"(83) 99873-7383");

	}
	@Test
	public void testaGetContato() {
		assertEquals(a2.getContato(90), "POSIÇÃO INVÁLIDA!");
		assertEquals(a1.getContato(3),
				"\nFábio Morais\n" + 
				"98790-1323 (prioritário)\n" + 
				"98790-1323 (zap)\n" + 
				"3231-8383");
	}
}


