import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agenda.Contato;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;


class ContatoTest {
	
	private Contato c1,c2;

	@BeforeEach
	public void initContato() {
		c1 = new Contato("João", "Almeida", "(83) 99812-9898", "(83) 3213-2131", "(83) 99393-9328", 2, 1);
		c2 = new Contato("João", "Almeida", "(83) 99873-7383", "(83) 98301-9238", "(83) 99979-6564", 3, 2);
	}
		
	@Test
	public void testHashcode() {
		assertEquals(c1.hashCode(),c2.hashCode());
	}

	@Test
	public void testEqualsObjetosIguais() {
		assertEquals(c1,c2);
	}
	
	@Test
	public void testEqualsObjetosDiferrentes() {
		c2.setSobrenome("da Silva");
		assertNotEquals(c1,c2);
	}
	
	@Test
	public void testGetTelPreferido() {
		assertEquals("(83) 3213-2131", c1.getTelPreferido());
		c1.setTelefone2("");
		assertEquals("Não tem telefone preferido!",c1.getTelPreferido());
	}
	
	
	
	@Test
	public void testGetContatoWhatsapp() {
		assertEquals("(83) 98301-9238", c2.getContatoWhatsapp());
		c2.setTelefone2(" ");
		assertEquals("Não tem Whatsapp!", c2.getContatoWhatsapp());
	}
	
	@Test
	public void testToString() {
		assertEquals("\nJoão Almeida\n" + 
				"(83) 3213-2131 (prioritário)\n" + 
				"(83) 99812-9898 (zap)\n" + 
				"(83) 99393-9328", c1.toString());
	}

}
