package banque.entites;

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
	
	@Column(name = "NOM")
	private String nom;
	
	@OneToMany(mappedBy="banque")
	 private Set<Client> clients;

	public Banque() {

	}
	public Banque(String nom) {
		this.nom = nom;
	}
	
	

}
