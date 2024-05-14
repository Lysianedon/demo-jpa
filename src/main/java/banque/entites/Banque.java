package banque.entites;

import java.time.LocalDate;
import java.util.Set;

import entites.Emprunt;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;

	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;

//	----------- Constructors -----------:

	public Banque() {

	}

	public Banque(String nom) {
		this.nom = nom;
	}

//	----------- Getters and setters ----------- :
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Integer getId() {
		return id;
	}

	// ---------------- To String ----------------:
	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}

}
