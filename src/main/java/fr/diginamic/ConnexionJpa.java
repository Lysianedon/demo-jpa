package fr.diginamic;

import entites.Fournisseur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Hello world!
 *
 */

public class ConnexionJpa {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");        
	        EntityManager em = emf.createEntityManager();
	        
	        //Ouvrir la transaction impérativement pour les requêtes de type DML (Insert/Update/Delete)
	        em.getTransaction().begin();
	        
	        // C -> CRUD
	        Fournisseur fournisseurACreer = new Fournisseur("Brico Dépot");
	        em.persist(fournisseurACreer);
	        System.out.println(fournisseurACreer.getId());
	        
	        // R -> CRUD
	        Fournisseur fournisseur = em.find(Fournisseur.class, 2);        
	        if (null != fournisseur) {
	        	System.out.println(fournisseur);
	        }
	        // R -> CRUD JPQL
	        TypedQuery<Fournisseur> query = em.createQuery("SELECT f FROM Fournisseur f WHERE f.raisonSociale = 'Brico Dépot'", Fournisseur.class);
	        System.out.println(query.getResultList());
	        
	        //U -> CRUD
	        Fournisseur fournisseurAMod = em.find(Fournisseur.class, 16);
	        if (null != fournisseurAMod) {
	        	fournisseurAMod.setRaisonSociale("Castorama");
	        }
	        
	        //D -> CRUD
	        Fournisseur fournisseurASup = em.find(Fournisseur.class, 15);
	        if (null != fournisseurASup) {
	        	em.remove(fournisseurASup);
	        }
	        
	        em.getTransaction().commit();
	        em.close();
	        emf.close();

	}

}
