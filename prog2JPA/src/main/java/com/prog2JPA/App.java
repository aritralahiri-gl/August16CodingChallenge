package com.prog2JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	public static void main(String[] args) {
		Employee ep = new Employee();
		ep.setEmpno(002);
		ep.setDesignation("UI");
		ep.setName("Sriparna Roy");
		ep.setSalary(900000);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee_Details");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ep);
		em.getTransaction().commit();
		Query query = em.createQuery("SELECT c FROM Employee c");
		List<Employee> results = query.getResultList();
		for (Employee e : results) {
			System.out.println(e.getEmpno() + " " + e.getName() + " " + e.getDesignation() + " " + e.getSalary());
		}

		em.close();
	}
}
