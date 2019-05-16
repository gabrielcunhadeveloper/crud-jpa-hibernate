package com.gabrielcunha.crudjpa.main;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gabrielcunha.crudjpa.model.Cliente;
import com.gabrielcunha.crudjpa.model.Conta;

public class Transferencia {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		EntityManager em = emf.createEntityManager();
		
		Scanner entrada = new Scanner(System.in);
		
		Conta conta1 = em.find(Conta.class, 1L);
		if (conta1 == null) {
			System.out.println("Digite o saldo inicial para a conta 1: ");
			BigDecimal saldoIncialConta1 = entrada.nextBigDecimal();
			conta1 = new Conta();
			conta1.setSaldo(saldoIncialConta1);
		}
		
		Conta conta2 = em.find(Conta.class, 2L);
		if (conta2 == null) {
			System.out.println("Digite o saldo inicial para a conta 2: ");
			BigDecimal saldoInicialConta2 = entrada.nextBigDecimal();
			conta2 = new Conta();
			conta2.setSaldo(saldoInicialConta2);
		}
		
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();
		
		System.out.println("Saldo da conta 1 R$" + conta1.getSaldo() + ". \n Saldo da conta 2 R$" + conta2.getSaldo());
		
		System.out.println("\nDigite o valor pra transferencia da conta 1 para a conta 2: ");
		BigDecimal valorTransferencia = entrada.nextBigDecimal();
		
		em.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo().subtract(valorTransferencia));
		conta2.setSaldo(conta2.getSaldo().add(valorTransferencia));
		
		if(conta1.getSaldo().compareTo(BigDecimal.ZERO) == 1 ) {
			em.getTransaction().commit();
			System.out.println("Transferencia realizada com Sucesso!");
		} else {
			em.getTransaction().rollback();
			System.err.println("Transferencia não realizada! Saldo insuficiente.");
		}
		
	}
}
