package fr.diginamic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import banque.entites.Adresse;
import banque.entites.AssuranceVie;
import banque.entites.Banque;
import banque.entites.Client;
import banque.entites.Compte;
import banque.entites.LivretA;
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
//		em.persist(banque);

//		Creating a client:
		String dateString = "02-12-1986";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		Client client = new Client("Bernard", "Claude", date, new Adresse(1, "rue de la Liberte", 75001, "Paris"),
				banque);
		Client client2 = new Client("Bernard", "Helene", date, new Adresse(1, "rue de la Liberte", 75001, "Paris"),
				banque);
//		em.persist(client);
//		em.persist(client2);
//		System.out.println(client);

//		Creating an account:
		Set<Client> clientsSet = new HashSet<Client>();
		clientsSet.add(client);
		clientsSet.add(client2);
		Compte compte = new Compte("AB01", 9000.9, clientsSet);
//		em.persist(compte);
		System.out.println(compte.getClients());

//		Creating an operation:
		String dateTime = "17-05-2024 14:35:01";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date2 = LocalDateTime.parse(dateTime, format);
		Operation operation = new Operation(date2, 50.0, "Retrait", compte);
//		em.persist(operation);

//			Creating an account associated with 2 clients:
		Banque banqueCC = new Banque("Le Crédit Agricole");
		em.persist(banqueCC);

		Client husband = new Client("Hally", "John", date, new Adresse(1, "rue Reuilly Diderot", 75012, "Paris"),
				banqueCC);
		Client wife = new Client("Hally", "Jenny", date, new Adresse(89, "rue Reuilly Diderot", 75012, "Paris"),
				banqueCC);
		em.persist(husband);
		em.persist(wife);

		Set<Client> clientsSet2 = new HashSet<Client>();
		clientsSet.add(husband);
		clientsSet.add(wife);
		Compte compteJoint = new Compte("Compte Joint", 20000, clientsSet2);
		em.persist(compteJoint);

//		Insert client with multiple accounts:
		
		AssuranceVie compte1 = new AssuranceVie("RichO1", 100000.0, 5.0, date);
		Compte compte2 = new LivretA("Rich02", 6870000.99, 1);
		Set<Compte> comptesRichman = new HashSet<Compte>();
		comptesRichman.add(compte1);
		comptesRichman.add(compte2);
		Client clientWithMultipleAccounts = new Client("Rich", "Man", date, new Adresse(19, "rue des Bois", 75005, "Paris"), banqueCC, comptesRichman);
		em.persist(clientWithMultipleAccounts);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
