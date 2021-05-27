import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Aluno;
import application.Grupo;

class GrupoTest {

	private Aluno aluno1, aluno2, aluno3;
	private Grupo grupo1, grupo2, grupo3;
	
	@BeforeEach
	public void initGrupo() {
		aluno1 = new Aluno("250","Gabriel Reyes","Computação");
		aluno2 = new Aluno("201","Torbjorn Lindholm","Engenharia Mecanica");
		aluno3 = new Aluno("200","Angela Ziegler","Medicina");
		
		grupo1 = new Grupo("Listas");
		grupo2 = new Grupo("Listas");
		grupo3 = new Grupo("Interfaces");
		
		grupo1.getAlunos().add(aluno1);
		grupo1.getAlunos().add(aluno2);
		grupo1.getAlunos().add(aluno3);
		
		grupo2.getAlunos().add(aluno1);
		grupo2.getAlunos().add(aluno2);
		grupo2.getAlunos().add(aluno3);
		
		grupo3.getAlunos().add(aluno1);
		grupo3.getAlunos().add(aluno2);
		grupo3.getAlunos().add(aluno3);
		
	}
	
	@Test
	public void testaConstrutorComAtributoNulo() {
		try {
			new Grupo(null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
	}
	
	@Test
	public void testaConstrutorComAtributoVazio() {
		try {
			new Grupo(" ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
	}
	
	@Test
	public void testaHashcode() {
		assertEquals(grupo1.hashCode(),grupo2.hashCode());
	}

	@Test
	public void testaEqualsObjetosIguais() {
		assertEquals(grupo1,grupo2);
	}

	@Test
	public void testaEqualsObjetosDiferrentes() {
		assertNotEquals(grupo1,grupo3);
	}
}
