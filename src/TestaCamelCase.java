import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestaCamelCase {
	
	List<String> esperada;
	
	@Before
	public void inicializaListas() {
		CamelCase.limpaLista();
		esperada = new ArrayList<>();
	}
	
	@Test
	public void testaUmaStringMinuscula() {
		esperada.add("nome");
		assertEquals(esperada, CamelCase.converterCamelCase("nome"));
	}

	@Test
	public void testaUmaStringMaiuscula() {
		esperada.add("nome");
		assertEquals(esperada, CamelCase.converterCamelCase("Nome"));
	}
	
	@Test
	public void testaUmaStringComposta() {
		esperada.add("nome");
		esperada.add("composto");
		assertEquals(esperada, CamelCase.converterCamelCase("NomeComposto"));
	}
	
	public void testaUmaStringCompostaMinuscula() {
		esperada.add("nome");
		esperada.add("composto");
		assertEquals(esperada, CamelCase.converterCamelCase("nomecomposto"));
	}
	
	@Test
	public void testaSoMaiuscula() {
		esperada.add("CPF");
		assertEquals(esperada, CamelCase.converterCamelCase("CPF"));
	}
	
	@Test
	public void testaMaisMaiusculas() {
		esperada.add("numero");
		esperada.add("CPF");
		esperada.add("contribuinte");
		assertEquals(esperada, CamelCase.converterCamelCase("numeroCPFContribuinte"));
	}
	
	@Test
	public void testaUmaStringCompostaComNumeros() {
		esperada.add("recupera");
		esperada.add("10");
		esperada.add("primeiros");
		assertEquals(esperada, CamelCase.converterCamelCase("recupera10Primeiros"));
	}
	
	@Test (expected = ComecaComNumeroException.class)
	public void testaUmaStringIniciadaPorNumero() {
		CamelCase.converterCamelCase("10Primeiros");
	}
	
	@Test (expected = TemEspecialException.class)
	public void testaStringComEspecial() {
		CamelCase.converterCamelCase("nome#Composto");
	}
}