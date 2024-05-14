package banque.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "RUE")
	private String rue;
	
	@Column(name = "CODE_POSTAL")
	private int codePostal;
	
	@Column(name = "VILLE")
	private String ville;
	
    public Adresse() {
        this.numero = 0;
        this.rue = "";
        this.codePostal = 0;
        this.ville = "";
    }

	public Adresse(int numero, String rue, int codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
}
