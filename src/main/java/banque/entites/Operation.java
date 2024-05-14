package banque.entites;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERATION")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DATE")
	private LocalDateTime date;
	
	@Column(name = "MONTANT")
	private double montant;
	
	@Column(name = "MOTIF")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="COMPTE_ID")
	private Compte compte;
	
	public Operation() {
		
	}


}
