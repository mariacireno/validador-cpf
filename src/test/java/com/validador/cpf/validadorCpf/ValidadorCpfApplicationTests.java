package com.validador.cpf.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.validador.cpf.validadorCpf.models.Cliente;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void testeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		cliente.setCpf("07696782460");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void testeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Telma");
		cliente.setCpf("11111111111");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void testeCpfIncompleto() {
		Cliente cliente = new Cliente();
		cliente.setNome("Ângela");
		cliente.setCpf("1542");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void testeCpfOverflow() {
		Cliente cliente = new Cliente();
		cliente.setNome("Regina");
		cliente.setCpf("1234567891011");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void testeCpfValidoComMascara() {
		Cliente cliente = new Cliente();
		cliente.setNome("Alessandra");
		cliente.setCpf("076.967.824-60");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void testeCpfInvalidoComMascara() {
		Cliente cliente = new Cliente();
		cliente.setNome("Duda");
		cliente.setCpf("076.485.824-60");
		assertEquals(false,cliente.validarCpf());
	}

	@Test
	void testeCpfInvalidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Karla");
		cliente.setCpf("076.485.824-60 ");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void testeCpfValidoComEspaco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Silvana");
		cliente.setCpf(" 076.96 7.824-60 ");
		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void testeCpfInvalidoComCaracteres() {
		Cliente cliente = new Cliente();
		cliente.setNome("Felipa");
		cliente.setCpf("076.b56.824-60 ");
		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void testeCpfNulo() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		assertEquals(false, cliente.validarCpf());
	}




}
