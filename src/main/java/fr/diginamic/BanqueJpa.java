package fr.diginamic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import banque.entites.Adresse;
import banque.entites.Banque;
import banque.entites.Client;
import banque.entites.Compte;
import banque.entites.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BanqueJpa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Creating a bank:
		Banque banque = new Banque("Le Credit Lyonnais");
		em.persist(banque);

//		Creating a client:
		String dateString = "02-12-1986";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		Client client = new Client("Bernard", "Claude", date, new Adresse(1, "rue de la Liberte", 75001, "Paris"), banque);
		em.persist(client);
		System.out.println(client);
		
//		Creating an account:
		Set<Client> clientsSet = new HashSet<Client>();
		clientsSet.add(client);
		Compte compte = new Compte("AB01", 9000.9, clientsSet);
		em.persist(compte);
		
//		Creating an operation:
		String dateTime = "17-05-2024 14:35:01";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date2 = LocalDateTime.parse(dateTime, format);
		Operation operation = new Operation(date2, 50.0, "Retrait", compte);
		em.persist(operation);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
