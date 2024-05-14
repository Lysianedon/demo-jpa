package fr.diginamic;
import entites.Client;

import entites.Emprunt;

import entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Bibliotheque {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");        
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        
	        Livre livre = em.find(Livre.class, 2);        
	        if (null != livre) {
	        	System.out.println(livre);
	        }
	        
//	        Réaliser une requête qui permet d’extraire un emprunt en fonction son id.	        
	        Emprunt emprunt = em.find(Emprunt.class, 1);
	        
	        if (null != emprunt) {
	        	System.out.println(emprunt);
//	        	 Affichez tous les livres associés
	        	System.out.println(emprunt.getLivres());
	        }
	        
//	        Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
	        Client client = em.find(Client.class, 3);
	        if (null != client) {
	        	System.out.println(client.getEmprunts());
	        }        
	        
	        em.getTransaction().commit();
	        em.close();
	        emf.close();

	}

}
