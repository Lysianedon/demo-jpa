package banque.entites;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte{
	
	@Column(name = "TAUX")
	double taux;
	
//	----------- Constructors -----------:

	public LivretA() {
		super();
	}
	public LivretA(String numeroCompte, double solde, double taux) {
		super(numeroCompte, solde);
		this.taux = taux;
	}
	
//	----------- Getters and setters ----------- :
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	//----------------	To String ----------------:
	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}
	

}
