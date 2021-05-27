package agenda;

	/**
	 * Classe contato que compõe a Agenda. 
	 * 
	 * @author Ícaro Chagas de Almeida
	 */
public class Contato {
	
	/**
	 * Nome de um contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome de um contato.
	 */
	private String sobrenome;
	
	/**
	 * 1º telefone de um contato.
	 */
	private String telefone1;
	
	/**
	 * 2º telefone de um contato.
	 */
	private String telefone2;
	
	/**
	 * 3º telefone de um contato.
	 */
	private String telefone3;
	
	/**
	 * Telefone prioritário de um contato.
	 */
	private int telPrincipal;
	
	/**
	 * Número de Whatsapp de um contato.
	 */
	private int telWhatsapp;
	
	/**
	 * Arrays do tipo String composto pelos três telefones do contato.
	 */
	private String[] telefones;
	
	/**
	 * Construtor da classe Contato.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param telefone1
	 * @param telefone2
	 * @param telefone3
	 * @param telPrincipal
	 * @param telWhatsapp
	 */
	public Contato(String nome, String sobrenome, String telefone1, String telefone2, String telefone3,
			int telPrincipal, int telWhatsapp) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.telPrincipal = telPrincipal;
		this.telWhatsapp = telWhatsapp;
		
		telefones = new String[] {telefone1, telefone2, telefone3};
	}
	/**
	 * Método para obter o nome de um contato.
	 * 
	 * @return O nome do contato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método para definir o nome de um contato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * Método para obter o sobrenome de um contato.
	 * 
	 * @return O sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Método para definir o sobrenome de um contato.
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * Método para obter o 1° telefone de um contato.
	 * 
	 * @return O 1º telefone de um contato.
	 */
	public String getTelefone1() {
		return telefone1;
	}
	
	/**
	 * Método para definir o 1° telefone de um contato.
	 */
	public void setTelefone1(String telefone1) {
		telefones[0] = telefone1;
	}
	
	/**
	 * Método para obter o 2° telefone de um contato.
	 * 
	 * @return O 2º telefone de um contato.
	 */
	public String getTelefone2() {
		return telefone2;
	}
	
	/**
	 * Método para definir o 2° telefone de um contato.
	 */
	public void setTelefone2(String telefone2) {
		telefones[1] = telefone2;
	}
	
	/**
	 * Método para obter o 3° telefone de um contato.
	 * 
	 * @return O 3º telefone de um contato.
	 */
	public String getTelefone3() {
		return telefone3;
	}
	
	/**
	 * Método para definir o 3° telefone de um contato.
	 */
	public void setTelefone3(String telefone3) {
		telefones[2] = telefone3;
	}
	
	/**
	 * Método para obter a posição do telefone principal no array de telefones.
	 * 
	 * @return A posição do telefone principal. 
	 */
	public int getTelPrincipal() {
		return telPrincipal;
	}
	
	/**
	 * Método para definir a posição do telefone principal no array de telefones.
	 */
	public void setTelPrincipal(int telPrincipal) {
		this.telPrincipal = telPrincipal;
	}
	
	/**
	 * Método para obter a posição do número de whatsapp no array de telefones.
	 * 
	 * @return A posição do número de whatsapp no array telefones.
	 */
	public int getTelWhatsapp() {
		return telWhatsapp;
	}
	
	/**
	 * Método para definir a posição do número de whatsapp no array de telefones.
	 */
	public void setTelWhatsapp(int telWhatsapp) {
		this.telWhatsapp = telWhatsapp;
	}
	
	/**
	 * Fornece o número preferido do contato.
	 * 
	 * @return O telefone preferido de um contato, ou uma mensagem informando a ausência de atribuição
	 * de um telefone preferido.
	 */
	public String getTelPreferido() {
		if (!telefones[telPrincipal-1].strip().equals("")) {
			if (telPrincipal == 1) {
				return telefone1;
			}
			else if (telPrincipal == 2) {
				return telefone2;
			}
			
			else if (telPrincipal == 3){
				return telefone3;
			}
		}
		return "Não tem telefone preferido!";
	}
	
	/**
	 * Fornece o número de Whatsapp do contato.
	 * 
	 * @return O número de Whtasapp de um contato, ou uma mensagem informando a ausência de atribuição
	 * de um telefone de Whatsapp.
	 */
	
	public String getContatoWhatsapp() {
		if (!telefones[telWhatsapp-1].strip().equals("")) {
			if (telWhatsapp == 1) {
				return telefone1;
			}
			else if (telWhatsapp == 2) {
				return telefone2;
			}
			
			else if (telWhatsapp == 3){
				return telefone3;
			}
		}
		return "Não tem Whatsapp!";
	}
	
	/**
	 * Formata os dados de telefone de um contato
	 * 
	 * @param telefones Array contendo os três números de telefone de um contato.
	 * @param sb Objeto do tipo StringBuilder utilizado para compor a saída do método toString().
	 * @return Uma string com os números de um contato.
	 */
	private String formataTelefones(String[] telefones, StringBuilder sb) {
		
		String telP = null;
		String telW = null;
		
		if (!telefones[telPrincipal-1].strip().equals("")) {
			telP = telefones[telPrincipal-1];
			sb.append(telP + " (prioritário)\n");
		}
		else {
			sb.append("Este contato não tem um telefone prioritário\n");
		}
		
		if (!telefones[telWhatsapp-1].strip().equals("")) {
			telW = telefones[telWhatsapp-1];
			sb.append(telW + " (zap)");
		}
		else {
			sb.append("Este contato não tem um telefone Whatsapp");
		}
		
		for (int i = 0; i < telefones.length; i++) {
			if ((!telefones[i].strip().equals(telP)) && (!telefones[i].strip().equals(telW)) && (!telefones[i].strip().equals(""))) {
				sb.append("\n" + telefones[i]);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Método equals sobrescrito para a classe Contato.
	 * 
	 * @return Um valor boleano que determina se dois objetos da classe Contato são iguais.
	 * 
	 * @param o Objeto sujeito a comparação;
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		Contato contato = (Contato) o;
		return this.nome.equals(contato.nome) && this.sobrenome.equals(contato.sobrenome);
	}
	
	/**
	 * Método hasCode sobrescrito para a classe Contato.
	 * 
	 * @return O hashCode que identifica a classe Contato.
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.sobrenome.hashCode();
	}
	
	/**
	 * Método toString sobrescrito para a classe Contato.
	 * 
	 * @return A representação da classe contato especificando o número prioritário (ou ausência),
	 * o número de Whatsapp (ou ausência), e o(s) telefone(s) remanecente(s) (ou ausência).
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + nome + " "  + sobrenome + "\n");
		
		return formataTelefones(telefones, sb);
	}
	
	
	
}
