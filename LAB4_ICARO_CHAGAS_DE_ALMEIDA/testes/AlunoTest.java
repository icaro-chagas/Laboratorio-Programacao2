import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Aluno;

class AlunoTest {

	private Aluno aluno1, aluno2, aluno3;
	
	@BeforeEach
	public void initAluno() {
		aluno1 = new Aluno("250","Gabriel Reyes","Computação");
		aluno2 = new Aluno("250","Gabriel Silva","Medicina");
		aluno3 = new Aluno("200","Angela Ziegler","Medicina");
	}
	
	@Test
	public void testaConstrutorComAtributoNulo() {
		try {
			new Aluno(null,"Gabriel Reyes","Computação");
			fail("Era esperado exceção ao atribuir o valor null para o atributo matricula");
		}
		catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
		
		try {
			new Aluno("250",null,"Computação");
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
		
		try {
			new Aluno("250","Gabriel Reyes",null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo curso");
		}
		catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
	}
	
	@Test
	public void testaConstrutorComAtributoVazio() {
		try {
			new Aluno("","Gabriel Reyes","Computação");
			fail("Era esperado exceção ao atribuir String vazia para o atributo matricula");
		}
		catch (IllegalArgumentException iae) {
			System.out.println("\nErro: " + iae.getMessage());
		}
		
		try {
			new Aluno("250","   ","Computação");
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		try {
			new Aluno("250","Gabriel Reyes","  ");
			fail("Era esperado exceção ao atribuir String vazia para o atributo curso");
		}
		catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
	}
	
	@Test
	public void testaHashcode() {
		assertEquals(aluno1.hashCode(),aluno2.hashCode());
	}
	
	@Test
	public void testaEqualsObjetosIguais() {
		assertEquals(aluno1,aluno2);
	}
	
	@Test
	public void testaEqualsObjetosDiferrentes() {
		assertNotEquals(aluno1,aluno3);
	}
	
	@Test
	public void testaToString() {
		assertEquals("250" + " - " + "Gabriel Reyes" + " - " + "Computação",aluno1.toString());
		assertEquals("200" + " - " + "Angela Ziegler" + " - " + "Medicina",aluno3.toString());
	}

}
