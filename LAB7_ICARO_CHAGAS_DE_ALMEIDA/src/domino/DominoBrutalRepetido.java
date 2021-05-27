package domino;

import domino.Jogo.TipoVitoria;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaCarrocaoPrimeiro;
import domino.estrategia.JogaNumMenosRepetido;
import domino.estrategia.JogaPrimeiraPossivel;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0, pontuacaoTotalJ1 = 0, pontuacaoTotalJ2 = 0;
		
		int vitoriasBatidaNormalJ1 = 0, vitoriasDesempateNumPecasJ1 = 0, vitoriasDesempatePontosJ1 = 0;
		int vitoriasBatidaCarrocaJ1 = 0, vitoriasBatidaLaELoJ1 = 0, vitoriasBatidaCarrocaCruzadaJ1 = 0;
		
		int vitoriasBatidaNormalJ2 = 0, vitoriasDesempateNumPecasJ2 = 0, vitoriasDesempatePontosJ2 = 0;
		int vitoriasBatidaCarrocaJ2 = 0, vitoriasBatidaLaELoJ2 = 0, vitoriasBatidaCarrocaCruzadaJ2 = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaCarrocaoPrimeiro(); 
		
		String estrategia1String = null;
		if (estrategia1.getClass().equals((new JogaPrimeiraPossivel()).getClass())) {
			estrategia1String = "JogaPrimeiraPossivel";
		}
		else if (estrategia1.getClass().equals((new JogaNumMenosRepetido()).getClass())) {
			estrategia1String = "JogaNumMenosRepetido";
		}
		else if (estrategia1.getClass().equals((new JogaCarrocaoPrimeiro()).getClass())) {
			estrategia1String = "JogaCarrocaoPrimeiro";
		}
		
		String estrategia2String = null;
		if (estrategia2.getClass().equals((new JogaPrimeiraPossivel()).getClass())) {
			estrategia2String = "JogaPrimeiraPossivel";
		}
		else if (estrategia2.getClass().equals((new JogaNumMenosRepetido()).getClass())) {
			estrategia2String = "JogaNumMenosRepetido";
		}
		else if (estrategia2.getClass().equals((new JogaCarrocaoPrimeiro()).getClass())) {
			estrategia2String = "JogaCarrocaoPrimeiro";
		}
		
		for (int i = 0; i < 10000; i++) {
			Jogo j;
			if (i<5000) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, 12);		
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, 12);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				pontuacaoTotalJ1 += historico.getPontuacaoVencedor();
				if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_NORMAL)) {
					vitoriasBatidaNormalJ1++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.DESEMPATE_NUMERO_PECAS)) {
					vitoriasDesempateNumPecasJ1++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.DESEMPATE_CONTAGEM_PONTOS)) {
					vitoriasDesempatePontosJ1++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_CARROCA)) {
					vitoriasBatidaCarrocaJ1++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_LA_E_LO)) {
					vitoriasBatidaLaELoJ1++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_CARROCA_CRUZADA)) {
					vitoriasBatidaCarrocaCruzadaJ1++;
				}
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				pontuacaoTotalJ2 += historico.getPontuacaoVencedor();
				if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_NORMAL)) {
					vitoriasBatidaNormalJ2++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.DESEMPATE_NUMERO_PECAS)) {
					vitoriasDesempateNumPecasJ2++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.DESEMPATE_CONTAGEM_PONTOS)) {
					vitoriasDesempatePontosJ2++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_CARROCA)) {
					vitoriasBatidaCarrocaJ2++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_LA_E_LO)) {
					vitoriasBatidaLaELoJ2++;
				}
				else if (historico.getTipoVitoriaVencedor().equals(TipoVitoria.BATIDA_CARROCA_CRUZADA)) {
					vitoriasBatidaCarrocaCruzadaJ2++;
				}
			}
		}
		
		
	
		System.out.println("Jogos: " + (empates + vitoriasJ1 + vitoriasJ2) + "\n" +
				"-".repeat(12) + "\n\n" +
		
				"Jogador 1 [Estratégia: " + estrategia1String + "]" +  (pontuacaoTotalJ1 > pontuacaoTotalJ2 ? " - (VENCEDOR!)\n\n" : "\n\n") +
				"Pontuação Total: " + pontuacaoTotalJ1 + "\n" +
				"Número total de vitórias: " + vitoriasJ1 + "\n\n" +
				"Número de vitórias com batida normal: " + vitoriasBatidaNormalJ1 + "\n" +
				"Número de vitórias com desempate por número de peças: " + vitoriasDesempateNumPecasJ1 + "\n" +
				"Número de vitórias com desempate por contagem de pontos: " + vitoriasDesempatePontosJ1 + "\n" +
				"Número de vitórias com batida de carroça: " + vitoriasBatidaCarrocaJ1 + "\n" +
				"Número de vitórias com batida de lá e ló: " + vitoriasBatidaLaELoJ1 + "\n" +
				"Número de vitórias com batida de carroça cruzada: " + vitoriasBatidaCarrocaCruzadaJ1 + "\n" +
				"-".repeat(61) + "\n\n" +
				
				"Jogador 2 [Estratégia: " + estrategia2String + "]" +  (pontuacaoTotalJ2 > pontuacaoTotalJ1 ? " - (VENCEDOR!)\n\n" : "\n\n") + 
				"Pontuação Total: " + pontuacaoTotalJ2 + "\n" +
				"Número total de vitórias: " + vitoriasJ2 + "\n\n" +
				"Número de vitórias com batida normal: " + vitoriasBatidaNormalJ2 + "\n" +
				"Número de vitórias com desempate por número de peças: " + vitoriasDesempateNumPecasJ2 + "\n" +
				"Número de vitórias com desempate por contagem de pontos: " + vitoriasDesempatePontosJ2 + "\n" +
				"Número de vitórias com batida de carroça: " + vitoriasBatidaCarrocaJ2 + "\n" +
				"Número de vitórias com batida de lá e ló: " + vitoriasBatidaLaELoJ2 + "\n" +
				"Número de vitórias com batida de carroça cruzada: " + vitoriasBatidaCarrocaCruzadaJ2 + "\n" +
				"-".repeat(61) + "\n\n" +
				
				"Empates: " + empates);
	}

}
