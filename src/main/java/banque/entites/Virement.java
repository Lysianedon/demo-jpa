package banque.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Virement extends Operation {

	String beneficiaire;

//	----------- Constructors -----------:
	public Virement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

//	----------- Getters and setters ----------- :
	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	// ---------------- To String ----------------:
	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + "]";
	}

}
