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

	@ManyToMany(mappedBy = "comptes")
	private Set<Client> clients;

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

//	----------- Constructors -----------:
	public Compte() {
		operations = new HashSet<Operation>();
	}

	public Compte(String numero, double solde) {

		this.numero = numero;
		this.solde = solde;
	}

	public Compte(String numero, double solde, Set<Client> clients) {

		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
	}

	public Compte(String numero, double solde, Set<Client> clients, Set<Operation> operations) {

		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
		this.operations = operations;
	}

//	----------- Getters and setters ----------- :

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Integer getId() {
		return id;
	}

}
