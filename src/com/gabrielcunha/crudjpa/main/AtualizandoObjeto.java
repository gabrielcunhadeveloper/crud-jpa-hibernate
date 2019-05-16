package com.gabrielcunha.crudjpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gabrielcunha.crudjpa.model.Cliente;

public class AtualizandoObjeto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1L);
		
		cliente.setNome("Jesus Cristo meu rei");
		cliente.setIdade(32);
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		
	}
	
}
