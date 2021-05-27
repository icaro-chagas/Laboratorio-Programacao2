package domino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaCarrocaoPrimeiro;
import domino.estrategia.JogaNumMenosRepetido;
import domino.estrategia.JogaPrimeiraPossivel;

public class CampeonatoBrutal {
	
	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {

		List<EstrategiaDeJogo> listaDeEstrategias1 = List.of(new JogaPrimeiraPossivel(), new JogaNumMenosRepetido());
		List<EstrategiaDeJogo> listaDeEstrategias2 = List.of(new JogaPrimeiraPossivel(), new JogaCarrocaoPrimeiro());
		List<EstrategiaDeJogo> listaDeEstrategias3 = List.of(new JogaCarrocaoPrimeiro(), new JogaNumMenosRepetido());
		
		List<EstrategiaDeJogo> listaDeEstrategiasEscolhidas = new ArrayList<EstrategiaDeJogo>();
		 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Escolha quantas estratégias você deseja que enfrente todas as outras (1, 2 ou 3): ");
		int numEstrategias = sc.nextInt();
		
		while (numEstrategias != 1 && numEstrategias != 2 && numEstrategias != 3) {
			System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE.\n");
			System.out.print("Escolha quantas estratégias você deseja que enfrente todas as outras (1, 2 ou 3): ");
			numEstrategias = sc.nextInt();
		}

				         
		if (numEstrategias == 1) {
			
			System.out.println();
			System.out.print("Especifique o número da estratégia que você dejesa escolher de acordo com as opções abaixo:\n" +
			         "1. JogaPrimeiraPossivel\n" +
			         "2. JogaNumMenosRepetido\n" +
			         "3. JogaCarrocaoPrimeiro");
			
			System.out.println();
			
			
			System.out.print("Número da estratégia: ");
			int numEstrategia = sc.nextInt();
			
			while (numEstrategia != 1 && numEstrategia != 2 && numEstrategia != 3) {
				
				System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE.\n");
				System.out.print("Especifique o número da estratégia que você dejesa escolher de acordo com as opções abaixo:\n" +
				         "1. JogaPrimeiraPossivel\n" +
				         "2. JogaNumMenosRepetido\n" +
				         "3. JogaCarrocaoPrimeiro");
				
				System.out.println();
				
				System.out.print("Número da estratégia: ");
				numEstrategia = sc.nextInt();
				
			}
			
			if (numEstrategia == 1) {
				listaDeEstrategiasEscolhidas.add(new JogaPrimeiraPossivel());
			}
			else if (numEstrategia == 2) {
				listaDeEstrategiasEscolhidas.add(new JogaNumMenosRepetido());
			}
			
			else if (numEstrategia == 3) {
				listaDeEstrategiasEscolhidas.add(new JogaCarrocaoPrimeiro());
			}
		}
		else if (numEstrategias == 2) {
			
			System.out.println();
			System.out.print("Especifique os números das estratégias que você dejesa escolher de acordo com as opções abaixo:\n" +
			         "1. JogaPrimeiraPossivel\n" +
			         "2. JogaNumMenosRepetido\n" +
			         "3. JogaCarrocaoPrimeiro");
			
			System.out.println();
			
			System.out.print("Número da estratégia 1: ");
			int numEstrategia1 = sc.nextInt();
			
			while (numEstrategia1 != 1 && numEstrategia1 != 2 && numEstrategia1 != 3) {
								
				System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE.\n");
				System.out.print("Especifique o número da estratégia que você dejesa escolher de acordo com as opções abaixo:\n" +
				         "1. JogaPrimeiraPossivel\n" +
				         "2. JogaNumMenosRepetido\n" +
				         "3. JogaCarrocaoPrimeiro");
				
				System.out.println();
				
				System.out.print("Número da estratégia 1: ");
				numEstrategia1 = sc.nextInt();
				
			}
			
			
			System.out.print("Número da estratégia 2: ");
			int numEstrategia2 = sc.nextInt();
			
			while (numEstrategia2 == numEstrategia1) {
				System.out.println("\nVOCÊ ESCOLHEU A MESMA ESTRATÉGIA DUAS VEZES! TENTE NOVAMENTE.\n");
				System.out.print("Número da estratégia 2: ");
				numEstrategia2 = sc.nextInt();
			}
			
			while (numEstrategia2 != 1 && numEstrategia2 != 2 && numEstrategia2 != 3) {
				
				System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE.\n");
				System.out.print("Especifique o número da estratégia que você dejesa escolher de acordo com as opções abaixo:\n" +
				         "1. JogaPrimeiraPossivel\n" +
				         "2. JogaNumMenosRepetido\n" +
				         "3. JogaCarrocaoPrimeiro");
				
				System.out.println();
				
				System.out.print("Número da estratégia 2: ");
				numEstrategia2 = sc.nextInt();
				
			}
			
			if (numEstrategia1 == 1) {
				listaDeEstrategiasEscolhidas.add(new JogaPrimeiraPossivel());
			}
			else if (numEstrategia1 == 2) {
				listaDeEstrategiasEscolhidas.add(new JogaNumMenosRepetido());
			}
			
			else if (numEstrategia1 == 3) {
				listaDeEstrategiasEscolhidas.add(new JogaCarrocaoPrimeiro());
			}
			
			if (numEstrategia2 == 1) {
				listaDeEstrategiasEscolhidas.add(new JogaPrimeiraPossivel());
			}
			else if (numEstrategia2 == 2) {
				listaDeEstrategiasEscolhidas.add(new JogaNumMenosRepetido());
			}
			
			else if (numEstrategia2 == 3) {
				listaDeEstrategiasEscolhidas.add(new JogaCarrocaoPrimeiro());
			}
		}
		
		else if (numEstrategias == 3) {
			System.out.println("Todas as estratégias foram escolhidas!");
			listaDeEstrategiasEscolhidas = List.of(new JogaPrimeiraPossivel(), new JogaNumMenosRepetido(), new JogaCarrocaoPrimeiro());
		}
		
		
		int vitoriasE1 = 0, vitoriasE2 = 0, vitoriasE3 = 0, empates = 0;
		
		for (EstrategiaDeJogo estrategia1: listaDeEstrategiasEscolhidas) {
			
			List<EstrategiaDeJogo> listaDeEstrategiasOponentes = new ArrayList<EstrategiaDeJogo>();
			if (estrategia1.getClass().equals(listaDeEstrategias1.get(0).getClass())) {
				listaDeEstrategiasOponentes = listaDeEstrategias3;
			}
			else if (estrategia1.getClass().equals(listaDeEstrategias1.get(1).getClass())) {
				listaDeEstrategiasOponentes = listaDeEstrategias2;
			}
			else if (estrategia1.getClass().equals(listaDeEstrategias2.get(1).getClass())) {
				listaDeEstrategiasOponentes = listaDeEstrategias1;
			}
			for (EstrategiaDeJogo estrategia2: listaDeEstrategiasOponentes) {
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
						if (estrategia1.getClass().equals(listaDeEstrategias1.get(0).getClass())) {
							vitoriasE1++;
						}
						else if (estrategia1.getClass().equals(listaDeEstrategias1.get(1).getClass())) {
							vitoriasE2++;
						}
						else if (estrategia1.getClass().equals(listaDeEstrategias2.get(1).getClass())) {
							vitoriasE3++;
						}
					} else if (historico.getVencedor() == "J2") {
						if (estrategia2.getClass().equals(listaDeEstrategias1.get(0).getClass())) {
							vitoriasE1++;
						}
						else if (estrategia2.getClass().equals(listaDeEstrategias1.get(1).getClass())) {
							vitoriasE2++;
						}
						else if (estrategia2.getClass().equals(listaDeEstrategias2.get(1).getClass())) {
							vitoriasE3++;
						}					
					}
				}
			}
	
		
		}
		System.out.println("\nNúmero total de partidas: " + (vitoriasE1 + vitoriasE2 + vitoriasE3 + empates));
		System.out.println();
		System.out.println("Vitórias JogaPrimeiraPossivel: " + vitoriasE1);
		System.out.println("Vitórias JogaNumMenosRepetido: " + vitoriasE2);
		System.out.println("Vitórias JogaCarrocaoPrimeiro: " + vitoriasE3);
		System.out.println("Empates: " + empates);
		
		sc.close();
		
	}
}
