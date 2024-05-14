package banque.entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte{

	@Column(name = "TAUX")
	double taux;
	@Column(name = "DATE_FIN")
	LocalDate dateFin;

//	----------- Constructors -----------:

	public AssuranceVie() {
		super();

	}

	public AssuranceVie(String numeroCompte, double solde, double taux, LocalDate dateFin) {
		super(numeroCompte, solde);
		this.taux = taux;
		this.dateFin = dateFin;
	}

//	----------- Getters and setters ----------- :

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	// ---------------- To String ----------------:
	@Override
	public String toString() {
		return "AssuranceVie [taux=" + taux + "]";
	}

}
