package com.gabrielcunha.crudjpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gabrielcunha.crudjpa.model.Conta;

public class ConsultaJPQL {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		EntityManager em = emf.createEntityManager();
		
		List<Conta> contas = em.createQuery("from Conta ", Conta.class).getResultList();
				
		for (Conta conta : contas) {
			System.out.println("Agencia = " + conta.getAgencia());		
			System.out.println("Saldo = " + conta.getSaldo());		
		}
	}	
}
