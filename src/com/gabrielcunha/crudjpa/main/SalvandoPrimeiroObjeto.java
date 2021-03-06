package com.gabrielcunha.crudjpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gabrielcunha.crudjpa.model.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Alice Moreira");
		cliente.setIdade(8);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente salvo com sucesso");
		
//		em.close();
		
		
	}
	
}
