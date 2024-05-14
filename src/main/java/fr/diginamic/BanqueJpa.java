package fr.diginamic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import banque.entites.Adresse;
import banque.entites.Banque;
import banque.entites.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BanqueJpa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Banque banque = new Banque("Le Credit Lyonnais");
		em.persist(banque);

		String dateString = "02-12-1986";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		Client client = new Client("Bernard", "Claude", date, new Adresse(1, "rue de la Liberte", 75001, "Paris"), banque);

		em.persist(client);
		System.out.println(client);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
