import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fornecedor.Fornecedor;


class AlteracoesFornecedorTest {

	private Fornecedor fornecedor;
	
	@BeforeEach
	public void initProduto() {

		fornecedor = new Fornecedor("Seu Olavo", "olavo@gmail.com", "83 99348-1092");
		fornecedor.adicionaProdutoComum("X-burguer", "Hamburguer de carne com queijo e calabresa", 4.50);
		fornecedor.adicionaProdutoComum("Suco", "Suco de maracuja (copo)", 1.50);
		fornecedor.adicionaProdutoComum("Coca-cola", "Coca-cola (lata)", 3.00);
		
		fornecedor.adicionaProdutoCombo("X-burguer + suco", "X-burguer com suco de maracuja", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");

	}
	
	@Test
	public void testaCadastroProdutoComAtributoNulo() {
		try {
			fornecedor.adicionaProdutoComum(null, "Pastel de forno de frango", 2.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoComum("Pastel de frango", null, 2.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo(null, "X-burguer com refri (lata)", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", null, 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
	}
	
	@Test
	public void testaCadastroProdutoComAtributoVazio() {
		try {
			fornecedor.adicionaProdutoComum(" ", "Pastel de forno de frango", 2.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoComum("Pastel de frango", "  ", 2.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("", "X-burguer com refri (lata)", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", "", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
		
	}
	
	@Test
	public void testaCadastroProdutoComAtributoInvalido() {
		try {
			fornecedor.adicionaProdutoComum("Pastel de frango", "Pastel de forno de frango", -0.01);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println( "\n" + iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoComum("Pastel de frango", "Pastel de forno de frango", 0);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", -0.01, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.00, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir valor 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.00, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir valor 1 para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.adicionaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.01, "X-burguer - Hamburguer de carne com queijo e calabresa, Coca-cola - Coca-cola (lata)");
			fail("Era esperado exceção ao atribuir valor > 1 para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	@Test
	public void testaEdicaoProdutoComAtributoNulo() {
		try {
			fornecedor.editaProdutoComum(null, "Pastel de forno de frango", 2.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println("\n" + npe.getMessage());
		}
		
		try {
			fornecedor.editaProdutoComum("Pastel de frango", null, 2.00);
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo(null, "X-burguer com refri (lata)", 0.20);
			fail("Era esperado exceção ao atribuir o valor null para o atributo nome");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", null, 0.20);
			fail("Era esperado exceção ao atribuir o valor null para o atributo descricao");
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}
	
	@Test
	public void testaEdicaoProdutoComAtributoVazio() {
		try {
			fornecedor.editaProdutoComum(" ", "Pastel de forno de frango", 2.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoComum("Pastel de frango", "  ", 2.00);
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("", "X-burguer com refri (lata)", 0.20);
			fail("Era esperado exceção ao atribuir String vazia para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", "", 0.20);
			fail("Era esperado exceção ao atribuir String vazia para o atributo descricao");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
		
	}
	
	@Test
	public void testaEdicaoProdutoComAtributoInvalido() {
		try {
			fornecedor.editaProdutoComum("Pastel de frango", "Pastel de forno de frango", -0.01);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoComum("Pastel de frango", "Pastel de forno de frango", 0);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo preco");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", -0.01);
			fail("Era esperado exceção ao atribuir valor < 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 0.00);
			fail("Era esperado exceção ao atribuir valor 0 para o atributo fator");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.00);
			fail("Era esperado exceção ao atribuir valor 1 para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		
		try {
			fornecedor.editaProdutoCombo("X-burguer + refrigerante", "X-burguer com refri (lata)", 1.01);
			fail("Era esperado exceção ao atribuir valor > 1 para o atributo nome");
		}
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage() + "\n");
		}
	
	}
}
