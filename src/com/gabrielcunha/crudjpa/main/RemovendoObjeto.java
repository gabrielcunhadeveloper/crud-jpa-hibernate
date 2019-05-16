package com.gabrielcunha.crudjpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gabrielcunha.crudjpa.model.Cliente;

public class RemovendoObjeto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 2L);
		
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		
	}
	
}
