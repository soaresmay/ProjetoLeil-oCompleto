package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.modelo.Cliente;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;

public class ControleLeilaoTest {

	private Produto produto;
	private double lanceMinimo;
	private Leilao leilao;
	private ControleLeilao controle;
	private Cliente cliente;
	private Cliente cliente2;

	@Before
	public void inicializacao() {
		produto = new Produto("TV");
		lanceMinimo = 1200;
		leilao = new Leilao(produto, lanceMinimo);
		controle = new ControleLeilao();
		cliente = new Cliente("Ana", "123");
		cliente2 = new Cliente("zé", "124");

	}

	@Test
	public void deveRetornarVerdadeiroParaUmLanceMaiorQueOValorMinimoDoProduto() {
		Lance novoLance = new Lance(cliente, 1201);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeRetornada);

	}

	@Test
	public void deveRetornarFalsoParaUmLanceMenorQueOValorMinimoDoProduto() {
		Lance novoLance = new Lance(cliente, 1000);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = false;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornarVerdadeiroParaUmLanceIgualQueOValorMinimoDoProduto() {
		Lance novoLance = new Lance(cliente, 1200);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornaFalsoParaDoisLancesSeguidosDoMesmoCliente() {
		leilao.addLance(new Lance(cliente, 1300));
		Lance novoLance = new Lance(cliente, 1400);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = false;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornarVerdadeiroParaUmLanceDadoPorUmClienteDiferenteDoUltimoLanceAnterior() {
		leilao.addLance(new Lance(cliente, 1300));
		Lance novoLance = new Lance(cliente2, 1400);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornarVerdadeiroParaOPrimeiroLanceDoLeilaoMaiorQueOValor() {
		Lance novoLance = new Lance(cliente2, 1550);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornarFalsoParaUmLanceMenorQueOLanceAnterior() {
		leilao.addLance(new Lance(cliente, 2000));
		Lance novoLance = new Lance(cliente2, 1900);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = false;
		assertEquals(validadeEsperada, validadeRetornada);

	}

	///////////////////////////////////////////////////////////
	@Test
	public void deveRetornarVeradeiroQuandoOLanceForMaiorQueOAnterior() {
		leilao.addLance(new Lance(cliente, 1200));
		Lance novoLance = new Lance(cliente2, 2000);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = true;
		assertEquals(validadeEsperada, validadeRetornada);
	}

	@Test
	public void deveRetornarfalsoSeOLanceForIgualAoLanceAnterior() {
		leilao.addLance(new Lance(cliente, 1500));
		Lance novoLance = new Lance(cliente2, 1500);
		boolean validadeRetornada = controle.validarLance(novoLance, leilao);
		boolean validadeEsperada = false;
		assertEquals(validadeEsperada, validadeRetornada);
	}
}
