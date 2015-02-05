package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.Customer;
import com.supply.db.helper.DbHelper;

public class CustomerDao {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public Long SaveCustomer(Customer cust){
		emf = DbHelper.provideFactory();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
		em.close();
		return null;
	}
	
	public void deleteCustomer(long custId){
		emf=DbHelper.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer=em.find(Customer.class,custId);
		em.remove(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateCustomer(long custId){
		emf=DbHelper.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer=em.find(Customer.class,custId);
		customer.setCustId(custId);
		em.getTransaction().commit();
		em.close();
	}

	public List<Customer> listCustomer(){
		     emf = DbHelper.provideFactory();
		     em = emf.createEntityManager();
		     TypedQuery<Customer> query = em.createQuery("", Customer.class);
			 List<Customer> results = query.getResultList();
		   return results;		
	}
	
	public Customer serchCustomer(long CustId) {
		emf=DbHelper.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer=em.find(Customer.class,CustId);
		return customer;
	}

	
	
	
}

