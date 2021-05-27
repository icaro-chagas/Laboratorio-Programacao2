import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.ControleDeAlunos;

class ControleDeAlunosTest {

	ControleDeAlunos cda;
	
	@BeforeEach
	public void initControleDeAlunos() {
		cda = new ControleDeAlunos();
	}
	
	@Test
	public void testaCadastraAluno() {
		
		try {
			cda.cadastraAluno(null, "Gabriel Reyes","Computação");
			fail("Era esperado exceção ao atribuir o valor null para o atributo matricula");
		} catch (NullPointerException npe) {
			System.out.println("\nErro: " + npe.getMessage());
		}
		
		try {
			cda.cadastraAluno("  ", "Gabriel Reyes","Computação");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo matricula");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		assertEquals(cda.cadastraAluno("250", "Gabriel Reyes","Computação"), "CADASTRO REALIZADO!");
		
		assertEquals(cda.cadastraAluno("250","Gabriel Silva","Medicina"), "MATRÍCULA JÁ CADASTRADA!");
	}
	
	@Test
	public void testaExibeAluno() {
		try {
			cda.exibeAluno(null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo matricula");
		} catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
		
		try {
			cda.exibeAluno("  ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo matricula");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		cda.cadastraAluno("250", "Gabriel Reyes","Computação");
		assertEquals(cda.exibeAluno("250"), "\nAluno: 250 - Gabriel Reyes - Computação");
		
		assertEquals(cda.exibeAluno("350"), "\nAluno não cadastrado.");
	}
	
	@Test
	public void testaCadastraNovoGrupo() {
		try {
			cda.cadastraNovoGrupo(null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nomeGrupo");
		} catch (NullPointerException npe) {
			System.out.println("\nErro: " + npe.getMessage());
		}
		
		try {
			cda.cadastraNovoGrupo(" ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo nomeGrupo");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		assertEquals(cda.cadastraNovoGrupo("Listas"), "CADASTRO REALIZADO!");
		
		assertEquals(cda.cadastraNovoGrupo("lisTAS"), "GRUPO JÁ CADASTRADO!");
	}

	@Test
	public void testaAlocaAlunoEmGrupo() {
		
		try {
			cda.alocaAlunoEmGrupo(null, "Listas");
			fail("Era esperado exceção ao atribuir o valor null para o atributo matricula");
		} catch (NullPointerException npe) {
			System.out.println("\nErro: " + npe.getMessage());
		}
		
		try {
			cda.alocaAlunoEmGrupo(" ", "Listas");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo matricula");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		try {
			cda.alocaAlunoEmGrupo("250", null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nomeGrupo");
		} catch (NullPointerException npe) {
			System.out.println("Erro: " + npe.getMessage());
		}
		
		try {
			cda.alocaAlunoEmGrupo("250", " ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo nomeGrupo");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		cda.cadastraAluno("250", "Gabriel Reyes","Computação");
		cda.cadastraNovoGrupo("Listas");
		
		assertEquals(cda.alocaAlunoEmGrupo("550", "listas"), "Aluno não cadastrado.");
		
		assertEquals(cda.alocaAlunoEmGrupo("250", "Interfaces"), "Grupo não cadastrado.");
		
		assertEquals(cda.alocaAlunoEmGrupo("250", "listas"), "ALUNO ALOCADO!");
	}
	
	@Test
	public void testaImprimeGrupo() {
		try {
			cda.imprimeGrupo(null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nomeGrupo");
		} catch (NullPointerException npe) {
			System.out.println("\nErro: " + npe.getMessage());
		}
		
		try {
			cda.imprimeGrupo(" ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo nomeGrupo");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		cda.cadastraAluno("250", "Gabriel Reyes","Computação");
		cda.cadastraNovoGrupo("Listas");
		
		assertEquals(cda.alocaAlunoEmGrupo("250", "Interfaces"), "Grupo não cadastrado.");
	}
	
	@Test
	public void testaRegistraAlunoQueRepondeu() {
		try {
			cda.registraAlunoQueRepondeu(null);
			fail("Era esperado exceção ao atribuir o valor null para o atributo matricula");
		} catch (NullPointerException npe) {
			System.out.println("\nErro: " + npe.getMessage());
		}
		
		try {
			cda.registraAlunoQueRepondeu("  ");
			fail("Era esperado exceção ao atribuir o valor vazio para o atributo matricula");
		} catch (IllegalArgumentException iae) {
			System.out.println("Erro: " + iae.getMessage());
		}
		
		cda.cadastraAluno("250", "Gabriel Reyes","Computação");
		assertEquals(cda.registraAlunoQueRepondeu("350"),"Aluno não cadastrado.");
		
		assertEquals(cda.registraAlunoQueRepondeu("250"),"ALUNO REGISTRADO!");	
	}
	
	@Test
	public void testaImprimeAlunosQueResponderam() {
		cda.cadastraAluno("250","Gabriel Reyes","Computação");
		cda.cadastraAluno("201","Torbjorn Lindholm","Engenharia Mecanica");
		cda.cadastraAluno("200","Angela Ziegler","Medicina");
		
		cda.registraAlunoQueRepondeu("250");
		cda.registraAlunoQueRepondeu("200");
		cda.registraAlunoQueRepondeu("250");
		cda.registraAlunoQueRepondeu("201");
		cda.registraAlunoQueRepondeu("201");
		
		assertEquals(cda.imprimeAlunosQueResponderam(), 
			  "\nAlunos:\n"
			+ "1. 250 - Gabriel Reyes - Computação\n"
			+ "2. 200 - Angela Ziegler - Medicina\n"
			+ "3. 250 - Gabriel Reyes - Computação\n"
			+ "4. 201 - Torbjorn Lindholm - Engenharia Mecanica\n"
			+ "5. 201 - Torbjorn Lindholm - Engenharia Mecanica\n");
	}
	
	
	
}
