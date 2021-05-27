package agenda;

	/**
	 * Classe contato que comp�e a Agenda. 
	 * 
	 * @author �caro Chagas de Almeida
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
	 * 1� telefone de um contato.
	 */
	private String telefone1;
	
	/**
	 * 2� telefone de um contato.
	 */
	private String telefone2;
	
	/**
	 * 3� telefone de um contato.
	 */
	private String telefone3;
	
	/**
	 * Telefone priorit�rio de um contato.
	 */
	private int telPrincipal;
	
	/**
	 * N�mero de Whatsapp de um contato.
	 */
	private int telWhatsapp;
	
	/**
	 * Arrays do tipo String composto pelos tr�s telefones do contato.
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
	 * M�todo para obter o nome de um contato.
	 * 
	 * @return O nome do contato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo para definir o nome de um contato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * M�todo para obter o sobrenome de um contato.
	 * 
	 * @return O sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * M�todo para definir o sobrenome de um contato.
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * M�todo para obter o 1� telefone de um contato.
	 * 
	 * @return O 1� telefone de um contato.
	 */
	public String getTelefone1() {
		return telefone1;
	}
	
	/**
	 * M�todo para definir o 1� telefone de um contato.
	 */
	public void setTelefone1(String telefone1) {
		telefones[0] = telefone1;
	}
	
	/**
	 * M�todo para obter o 2� telefone de um contato.
	 * 
	 * @return O 2� telefone de um contato.
	 */
	public String getTelefone2() {
		return telefone2;
	}
	
	/**
	 * M�todo para definir o 2� telefone de um contato.
	 */
	public void setTelefone2(String telefone2) {
		telefones[1] = telefone2;
	}
	
	/**
	 * M�todo para obter o 3� telefone de um contato.
	 * 
	 * @return O 3� telefone de um contato.
	 */
	public String getTelefone3() {
		return telefone3;
	}
	
	/**
	 * M�todo para definir o 3� telefone de um contato.
	 */
	public void setTelefone3(String telefone3) {
		telefones[2] = telefone3;
	}
	
	/**
	 * M�todo para obter a posi��o do telefone principal no array de telefones.
	 * 
	 * @return A posi��o do telefone principal. 
	 */
	public int getTelPrincipal() {
		return telPrincipal;
	}
	
	/**
	 * M�todo para definir a posi��o do telefone principal no array de telefones.
	 */
	public void setTelPrincipal(int telPrincipal) {
		this.telPrincipal = telPrincipal;
	}
	
	/**
	 * M�todo para obter a posi��o do n�mero de whatsapp no array de telefones.
	 * 
	 * @return A posi��o do n�mero de whatsapp no array telefones.
	 */
	public int getTelWhatsapp() {
		return telWhatsapp;
	}
	
	/**
	 * M�todo para definir a posi��o do n�mero de whatsapp no array de telefones.
	 */
	public void setTelWhatsapp(int telWhatsapp) {
		this.telWhatsapp = telWhatsapp;
	}
	
	/**
	 * Fornece o n�mero preferido do contato.
	 * 
	 * @return O telefone preferido de um contato, ou uma mensagem informando a aus�ncia de atribui��o
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
		return "N�o tem telefone preferido!";
	}
	
	/**
	 * Fornece o n�mero de Whatsapp do contato.
	 * 
	 * @return O n�mero de Whtasapp de um contato, ou uma mensagem informando a aus�ncia de atribui��o
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
		return "N�o tem Whatsapp!";
	}
	
	/**
	 * Formata os dados de telefone de um contato
	 * 
	 * @param telefones Array contendo os tr�s n�meros de telefone de um contato.
	 * @param sb Objeto do tipo StringBuilder utilizado para compor a sa�da do m�todo toString().
	 * @return Uma string com os n�meros de um contato.
	 */
	private String formataTelefones(String[] telefones, StringBuilder sb) {
		
		String telP = null;
		String telW = null;
		
		if (!telefones[telPrincipal-1].strip().equals("")) {
			telP = telefones[telPrincipal-1];
			sb.append(telP + " (priorit�rio)\n");
		}
		else {
			sb.append("Este contato n�o tem um telefone priorit�rio\n");
		}
		
		if (!telefones[telWhatsapp-1].strip().equals("")) {
			telW = telefones[telWhatsapp-1];
			sb.append(telW + " (zap)");
		}
		else {
			sb.append("Este contato n�o tem um telefone Whatsapp");
		}
		
		for (int i = 0; i < telefones.length; i++) {
			if ((!telefones[i].strip().equals(telP)) && (!telefones[i].strip().equals(telW)) && (!telefones[i].strip().equals(""))) {
				sb.append("\n" + telefones[i]);
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * M�todo equals sobrescrito para a classe Contato.
	 * 
	 * @return Um valor boleano que determina se dois objetos da classe Contato s�o iguais.
	 * 
	 * @param o Objeto sujeito a compara��o;
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
	 * M�todo hasCode sobrescrito para a classe Contato.
	 * 
	 * @return O hashCode que identifica a classe Contato.
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.sobrenome.hashCode();
	}
	
	/**
	 * M�todo toString sobrescrito para a classe Contato.
	 * 
	 * @return A representa��o da classe contato especificando o n�mero priorit�rio (ou aus�ncia),
	 * o n�mero de Whatsapp (ou aus�ncia), e o(s) telefone(s) remanecente(s) (ou aus�ncia).
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + nome + " "  + sobrenome + "\n");
		
		return formataTelefones(telefones, sb);
	}
	
	
	
}
