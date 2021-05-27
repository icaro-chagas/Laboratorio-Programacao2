package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * L�gica para ler de arquivos csv os dados necess�rios e povoar uma agenda. 
 * 
 * @author Adaptado por: �caro Chagas de Almeida (Autor Original: Nazareno Andrade)
 *
 */
public class LeitorDeAgenda {

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;
	private static final int COLUNA_SOBRENOME = 2;
	private static final int COLUNA_TELEFONE1 = 3;
	private static final int COLUNA_TELEFONE2 = 4;
	private static final int COLUNA_TELEFONE3 = 5;
	private static final int COLUNA_TELEFONE_PRIORITARIO = 6;
	private static final int COLUNA_NUMERO_ZAP = 7;
	
	/**
	 * L� contatos de um arquivo CSV e os coloca em uma agenda.
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda A agenda a manipular.
	 * @return O n�mero de contatos adicionados � agenda.
	 * @throws IOException Caso n�o tenhamos permiss�o de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo n�o exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabe�alho
					continue;
				}
				String[] campos = linha.split(",");
				processaLinhaCsvContatos(campos, agenda);
			}
		}
		
		return carregados;
	}

	
	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial. 
	 * 
	 * @param campos As informa��es lidas do csv. 
	 * @param agenda A agenda a manipular. 
	 */
	private void processaLinhaCsvContatos(String[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String telefone1 = campos[COLUNA_TELEFONE1].trim();
		String telefone2 = campos[COLUNA_TELEFONE2].trim();
		String telefone3 = campos[COLUNA_TELEFONE3].trim();
		int telPrioritario = Integer.parseInt(campos[COLUNA_TELEFONE_PRIORITARIO]);
		int numZap = Integer.parseInt(campos[COLUNA_NUMERO_ZAP]);

		agenda.cadastraContato(posicao, nome, sobrenome, telefone1, telefone2, telefone3, telPrioritario, numZap);
	}

}
