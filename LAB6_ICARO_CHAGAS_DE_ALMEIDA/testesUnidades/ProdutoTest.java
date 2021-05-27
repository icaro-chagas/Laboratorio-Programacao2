import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoCombo;
import produto.ProdutoComum;


class ProdutoTest {

	private Produto produto1, produto2, produto3, produto4, produto5, produto6;
	
	@BeforeEach
	public void initProduto() {
		produto1 = new ProdutoComum("X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		produto2 = new ProdutoComum("Suco", "Suco de maracuja (copo)", 1.50);
		produto3 = new ProdutoComum("Suco", "Suco de maracuja (copo)", 9.80);
		
		produto4 = new ProdutoCombo("X-burguer + suco", "X-burguer com suco de maracuja", 0.20, 6.00);
		produto5 = new ProdutoCombo("X-burguer + suco", "X-burguer com suco de maracuja", 0.50, 9.00);
		produto6 = new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.20, 7.50);
	}
	
	@Test
	public void testaConstrutorComAtributoNulo() {
		try {
			new ProdutoComum(null, "Feijao com arroz e queijo coalho", 14.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			new ProdutoCombo(null, "X-burguer com refri (lata)", 0.20, 7.50);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			new ProdutoComum("Rubacao", null, 14.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", null, 0.20, 7.50);
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
	}
	
	@Test
	public void testaConstrutorComAtributoVazio() {
		try {
			new ProdutoComum("  ", "Feijao com arroz e queijo coalho", 14.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage());
		}
		
		try {
			new ProdutoCombo("   ", "X-burguer com refri (lata)", 0.20, 7.50);
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoComum("Rubacao", "", 14.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "", 0.20, 7.50);
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testaConstrutorComAtributoInválido() {
		
		try {
			new ProdutoComum("Rubacao", "Feijao com arroz e queijo coalho", -0.01);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoComum("Rubacao", "Feijao com arroz e queijo coalho", 0.00);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.20, -0.01);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.20, 0.00);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", -0.01, 7.50);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.00, 7.50);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.00, 7.50);
			fail("Era esperado exceção ao atribuir valor 1 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			new ProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.01, 7.50);
			fail("Era esperado exceção ao atribuir valor > 1 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	}
	
	@Test
	public void testaHashcode() {
		assertEquals(produto2.hashCode(),produto3.hashCode());
		assertEquals(produto4.hashCode(),produto5.hashCode());
	}
	
	@Test
	public void testaEqualsObjetosIguais() {
		assertEquals(produto2,produto3);
		assertEquals(produto5,produto5);
	}
	
	@Test
	public void testaEqualsObjetosDiferrentes() {
		assertNotEquals(produto1,produto2);
		assertNotEquals(produto4,produto6);
		assertNotEquals(produto1,produto4);
	}
	
	@Test
	public void testaModificaProduto() {
		
		produto1.modificaProduto(6.50);
		assertEquals("X-burguer" + " - " + "Hamburguer de carne com queijo e calabresa" + " - R$" + "6,50", produto1.toString());
		
		produto4.modificaProduto(0.40);
		assertEquals("X-burguer + suco" + " - " + "X-burguer com suco de maracuja" + " - R$" + "3,60", produto4.toString());	
	}
	
	@Test
	public void testaToString() {
		assertEquals("X-burguer" + " - " + "Hamburguer de carne com queijo e calabresa" + " - R$" + "4,50", produto1.toString());
		assertEquals("X-burguer + suco" + " - " + "X-burguer com suco de maracuja" + " - R$" + "4,80", produto4.toString());
	}

}
