package domino;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;

/**
 * Um jogo de dominó envolvendo 2 jogadores.
 *
 */
public class Jogo {

	/**
	 * Constantes para informar que tipo de batida levou um jogador
	 * a vitória em uma partida.
	 *
	 * @author Ícaro Chagas de Almeida - 119210960
	 *
	 */
	public enum TipoVitoria {
		BATIDA_NORMAL,
		DESEMPATE_NUMERO_PECAS,
		DESEMPATE_CONTAGEM_PONTOS,
		BATIDA_CARROCA, 
		BATIDA_LA_E_LO,
		BATIDA_CARROCA_CRUZADA
	}
	
	private Jogador jogador1;
	private Jogador jogador2;

	private Mesa mesa;
	private int rodadasJogadas;

	private boolean finalizado;
	private String vencedor;
	
	/**
	 * Especifica o tipo de vitória do jogador vencedor.
	 */
	private TipoVitoria tipoVitoriaVencedor;
	
	/**
	 * Especifica a pontuação do jogador vencedor.
	 */
	private int pontuacaoVencedor;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com batida normal.
	 */
	private static final int PONTUACAO_BATIDA_NORMAL = 1;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com desempate por número de peças.
	 */
	private static final int PONTUACAO_DESEMPATE_NUMERO_PECAS = 1;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com desempate por contagem de pontos.
	 */
	private static final int PONTUACAO_DESEMPATE_CONTAGEM_PONTOS= 1;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com desempate por batida com carroça.
	 */
	private static final int PONTUACAO_BATIDA_CARROCA = 2;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com desempate por batida com lá e ló.
	 */
	private static final int PONTUACAO_BATIDA_LA_E_LO = 3;
	
	/**
	 * Constante utilizada para especificar a pontuação em uma vitória
	 * com desempate por batida com carroça cruzada.
	 */
	private static final int PONTUACAO_BATIDA_CARROCA_CRUZADA = 6;
	

	/**
	 * Fatora código comum de inicialização.
	 */
	private Jogo() {
		this.rodadasJogadas = 0;
		this.finalizado = false;
		this.vencedor = null;
		this.mesa = new Mesa();
		this.tipoVitoriaVencedor = null;
		this.pontuacaoVencedor = 0;
	}

	/**
	 * Para uso em testes apenas: cria, embaralha e distribui peças entre dois
	 * jogadores de maneira reprodutível. Sempre que o mesmo objeto Random for
	 * passado, as peças com cada jogador acabarão sendo as mesmas.
	 * 
	 * @param nomeJogador1            Id do jogador 1.
	 * @param estrategia1             Estratégia para o jogador 1.
	 * @param nomeJogador2            Id do jogador 2.
	 * @param estrategia2             Estratégia para o jogador 2.
	 * @param numPecasInicial         Número de peças a dar para cada jogador no
	 *                                início.
	 * @param geradorDeNumsAleatorios Objeto que determina as peças que cada um
	 *                                receberá após embaralhamento.
	 */
	protected Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			int numPecasInicial, Random geradorDeNumsAleatorios) {
		this();
		List<Peca> pecas = criaPecas();
		
		Collections.shuffle(pecas, geradorDeNumsAleatorios);

		List<Peca> maoJ1 = sorteiaMao(pecas, numPecasInicial);
		List<Peca> maoJ2 = sorteiaMao(pecas, numPecasInicial);

		this.jogador1 = new Jogador(nomeJogador1, estrategia1, maoJ1);
		this.jogador2 = new Jogador(nomeJogador2, estrategia2, maoJ2);
	}

	/**
	 * Cria, embaralha e distribui peças entre dois jogadores.
	 * 
	 * @param nomeJogador1    Id do jogador 1.
	 * @param estrategia1     Estratégia para o jogador 1.
	 * @param nomeJogador2    Id do jogador 2.
	 * @param estrategia2     Estratégia para o jogador 2.
	 * @param numPecasInicial Número de peças a dar para cada jogador no início.
	 */
	public Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			int numPecasInicial) {
		this(nomeJogador1, estrategia1, nomeJogador2, estrategia2, numPecasInicial, new Random());
	}

	/**
	 * 
	 * Para uso em testes: cria um jogo com peças escolhidas para a mão dos
	 * jogadores. Isso permite criar situações para testes de unidade mais
	 * facilmente.
	 * 
	 * @param nomeJogador1 Id do jogador 1.
	 * @param estrategia1  Estratégia para o jogador 1.
	 * @param nomeJogador2 Id do jogador 2.
	 * @param estrategia2  Estratégia para o jogador 2.
	 * @param maoJogador1  Mão do jogador 1.
	 * @param maoJogador2  Mão do jogador 2
	 */
	public Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			List<Peca> maoJogador1, List<Peca> maoJogador2) {
		this();
		this.jogador1 = new Jogador(nomeJogador1, estrategia1, new LinkedList<Peca>(maoJogador1));
		this.jogador2 = new Jogador(nomeJogador2, estrategia2, new LinkedList<Peca>(maoJogador2));
	}

	/**
	 * Sorteia peças para um jogador.
	 * 
	 * @param pecas           conjunto de peças total (será alterado)
	 * @param numPecasInicial Número de peças a retirar
	 * @return Peças retiradas.
	 */
	private List<Peca> sorteiaMao(List<Peca> pecas, int numPecasInicial) {
		List<Peca> mao = new LinkedList<Peca>();
		for (int i = 0; i < numPecasInicial; i++) {
			mao.add(pecas.remove(0));
		}
		return mao;
	}

	/**
	 * Cria o dominó.
	 * 
	 * @return Conjunto de 28 peças de 0:0 a 6:6
	 */
	private List<Peca> criaPecas() {
		List<Peca> pecas = new LinkedList<Peca>();

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j <= 6; j++) {
				pecas.add(new Peca(i, j));
			}
		}

		return pecas;
	}

	/**
	 * @return Número de peças na mão do jogador 1.
	 */
	public int getNumPecasJ1() {
		return this.jogador1.getNumPecas();
	}

	/**
	 * @return Número de peças na mão do jogador 2.
	 */
	public int getNumPecasJ2() {
		return this.jogador2.getNumPecas();
	}

	/**
	 * Joga uma rodada do jogo. Ambos os jogadores fazem 1 jogada, iniciando pelo
	 * jogador 1. As exceções abaixo são necessárias para proteger o jogo de
	 * estratégias com bugs.
	 * 
	 * @throws EstrategiaInvalidaException Se a estratégia de um dos jogadores
	 *                                     decidir jogar uma peça que ele não
	 *                                     possui.
	 * @throws JogadaInvalidaException     Se a peça escolhida por algum dos
	 *                                     jogadores não encaixar na mesa.
	 */
	public void rodada() throws EstrategiaInvalidaException, JogadaInvalidaException {
		rodadasJogadas += 1;

		Jogada jogadaJ1 = jogador1.decideJogada(mesa);
		jogaJogada(jogador1, jogadaJ1);

		if (jogador1.getNumPecas() == 0) {
			
			// J1 venceu
			this.finalizado = true;
			this.vencedor = this.jogador1.getNome();	
			this.setPontuacaoVencedor(jogador1.getUltimaJogada());
			
			return;
		}

		Jogada jogadaJ2 = jogador2.decideJogada(mesa);
		jogaJogada(jogador2, jogadaJ2);
		

		if (jogador2.getNumPecas() == 0) {
			
			// J2 venceu
			this.finalizado = true;
			this.vencedor = this.jogador2.getNome();	
			this.setPontuacaoVencedor(jogador2.getUltimaJogada());
			
			return;
		}

		if (jogadaJ1.getTipo() == TipoJogada.PASSA && jogadaJ2.getTipo() == TipoJogada.PASSA) {		
			this.finalizado = true;
			this.setDesempateOuEmpate();
			
		}
		
	}

	/**
	 * Joga o jogo do ponto atual até o seu fim.
	 * @return 
	 * 
	 * @throws EstrategiaInvalidaException Se a estratégia de um dos jogadores
	 *                                     decidir jogar uma peça que ele não
	 *                                     possui.
	 * @throws JogadaInvalidaException     Se a peça escolhida por algum dos
	 *                                     jogadores não encaixar na mesa.
	 */
	public HistoricoDeJogo jogaJogoCompleto() throws EstrategiaInvalidaException, JogadaInvalidaException {
		HistoricoDeJogo jogado = new HistoricoDeJogo(jogador1, jogador2);
		while (!this.isFinalizado()) {
			this.rodada();
			jogado.addRodada(jogador1.getUltimaJogada(), jogador2.getUltimaJogada(), mesa);
		}
		
		if(this.isResultadoEmpate()) {
			jogado.setResultadoEmpate();
		} else {
			jogado.setVencedor(getVencedor());
			jogado.setPontuacaoVencedor(getPontuacaoVencedor());
			jogado.setTipoVitoriaVencedor(getTipoVitoriaVencedor());
		}
		
		return jogado;
//		System.out.println("==> final: " + (venceu == null ? "EMPATE" : venceu + " VENCEU") + "\n");
	}

	/**
	 * Faz a jogada decidida por um dos jogadores ter efeito. Quem realiza de fato
	 * as jogadas é essa classe (Jogo), e não o Jogador ou a estratégia, para evitar
	 * que estratégias com erro modifiquem indevidamente a mesa ou dados do jogador.
	 * 
	 * @param jogador Jogador jogando
	 * @param jogada  A jogada a colocar em prática
	 * @throws JogadaInvalidaException Caso ela não possa ser jogada na mesa atual
	 */
	private void jogaJogada(Jogador jogador, Jogada jogada) throws JogadaInvalidaException {
		if (jogada.getTipo() == TipoJogada.PASSA) {
			return;
		}

		switch (jogada.getTipo()) {
		case NA_ESQUERDA: {
			this.mesa.jogaNaEsquerda(jogada.getPeca());
			break;
		}
		case NA_DIREITA: {
			this.mesa.jogaNaDireita(jogada.getPeca());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + jogada.getTipo());
		}

		jogador.removeDaMao(jogada.getPeca());
	}
	
	/**
	 * Determina a pontuação do jogador vencedor mediante ao tipo de vitória
	 * @param jogadaFinal Última jogada do vencedor.
	 */
	private void setPontuacaoVencedor(Jogada jogadaFinal) {

		if (!jogadaFinal.getTipo().equals(TipoJogada.PASSA)) {
			int numEsquerdoPeca = jogadaFinal.getPeca().getNumEsquerdo();
			int numDireitoPeca = jogadaFinal.getPeca().getNumDireito();
	
			if ( (numEsquerdoPeca == numDireitoPeca) && (jogadaFinal.getTipo() == TipoJogada.NA_DIREITA) ) {
				if (mesa.getNumNaEsquerda() != numDireitoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_CARROCA;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_CARROCA;			
				}
				else if (mesa.getNumNaEsquerda() == numDireitoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_CARROCA_CRUZADA;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_CARROCA_CRUZADA;
				}
			} 
			else if ( (numEsquerdoPeca == numDireitoPeca) && (jogadaFinal.getTipo() == TipoJogada.NA_ESQUERDA) ) {
				if (mesa.getNumNaDireita() != numEsquerdoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_CARROCA;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_CARROCA;
				}
				else if (mesa.getNumNaDireita() == numEsquerdoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_CARROCA_CRUZADA;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_CARROCA_CRUZADA;
				}
			}
			else if ( (numEsquerdoPeca != numDireitoPeca) && (jogadaFinal.getTipo() == TipoJogada.NA_DIREITA) ) {
				if (mesa.getNumNaEsquerda() == numDireitoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_LA_E_LO;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_LA_E_LO;
				}
				else {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_NORMAL;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_NORMAL;
				}
			}	
			else if ( (numEsquerdoPeca != numDireitoPeca) && (jogadaFinal.getTipo() == TipoJogada.NA_ESQUERDA) ) {		
				if (mesa.getNumNaDireita() == numEsquerdoPeca) {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_LA_E_LO;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_LA_E_LO;
				}
				else {
					this.pontuacaoVencedor = PONTUACAO_BATIDA_NORMAL;
					this.tipoVitoriaVencedor = TipoVitoria.BATIDA_NORMAL;
				}	
			}
			
		}
		else {  
			if (jogador1.getNumPecas() != jogador2.getNumPecas()) {
				this.pontuacaoVencedor = PONTUACAO_DESEMPATE_NUMERO_PECAS;
				this.tipoVitoriaVencedor = TipoVitoria.DESEMPATE_NUMERO_PECAS;
			}
				
			if ( (jogador1.getNumPecas() == jogador2.getNumPecas()) && (jogador1.getPontosMao() != jogador2.getPontosMao()) ) {
				this.pontuacaoVencedor = PONTUACAO_DESEMPATE_CONTAGEM_PONTOS;
				this.tipoVitoriaVencedor = TipoVitoria.DESEMPATE_CONTAGEM_PONTOS;
			}
		}
	
	}
	
	/**
	 * Determina qual jogador venceu a partida com base em métricas 
	 * de desempate. Ou estabelece que a partida terminou em empate.
	 */
	private void setDesempateOuEmpate() {
		if (jogador1.getNumPecas() < jogador2.getNumPecas()) {
			this.vencedor = this.jogador1.getNome();
			this.setPontuacaoVencedor(jogador1.getUltimaJogada());
		}
		else if (jogador2.getNumPecas() < jogador1.getNumPecas()) {
			this.vencedor = this.jogador2.getNome();
			this.setPontuacaoVencedor(jogador2.getUltimaJogada());
		}
		else if (jogador1.getPontosMao() < jogador2.getPontosMao()) {
			this.vencedor = this.jogador1.getNome();
			this.setPontuacaoVencedor(jogador1.getUltimaJogada());
		}
		else if (jogador2.getPontosMao() < jogador1.getPontosMao()) {
			this.vencedor = this.jogador2.getNome();
			this.setPontuacaoVencedor(jogador2.getUltimaJogada());
		}
		else {
			this.vencedor = null;
		}
	}

	@Override
	public String toString() {
		String o = jogador1.toString() + "\n" + jogador2.toString() + "\nMesa: " + mesa.toString();
		return o;
	}

	/**
	 * @return Número de rodadas já jogadas.
	 */
	public int getNumRodadas() {
		return rodadasJogadas;
	}

	/**
	 * O jogo está finalizado quando um dos jogadores não tem mais peças ou não é
	 * mais possível jogar para ambos.
	 * 
	 * @return Se o jogo está encerrado
	 */
	public boolean isFinalizado() {
		return this.finalizado;
	}

	/**
	 * Informa se o jogo terminou e foi empate. Retorna false se o jogo ainda não
	 * acabou.
	 * 
	 * @return true se o jogo acabou com empate.
	 */
	public boolean isResultadoEmpate() {
		return this.isFinalizado() && this.vencedor == null;
	}

	/**
	 * @return Id do vencedor, ou null caso o jogo não esteja finalizado.
	 */
	public String getVencedor() {
		return vencedor;
	}
	
	/**
	 * Fornece o tipo de vitória do jogador vencedor.
	 * @return Valor que especifica qual o tipo de vitória do vencedor.
	 */
	public TipoVitoria getTipoVitoriaVencedor() {
		return this.tipoVitoriaVencedor;
	}
	
	/**
	 * Fornece a pontuação do jogador vencedor.
	 * @return Valor que especifica a pontuação do vencedor.
	 */
	public int getPontuacaoVencedor() {
		return this.pontuacaoVencedor;
	}

}
