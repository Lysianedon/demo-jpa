package banque.entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "SOLDE")
	private double solde;
	
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	 private Set<Operation> operations;
	 
	public Compte() {
		operations = new HashSet<Operation>();
	 }
}
