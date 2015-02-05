package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.OrderItem;
import com.supply.db.helper.DbHelper;

public class OrderItemDao {

	 EntityManagerFactory emf=null;
	 EntityManager em= null;
	 
	 
	 public void saveOrderItem(OrderItem orderItem)
	 {
	  emf=DbHelper.provideFactory();
	     em=emf.createEntityManager();
	     em.getTransaction().begin();
	     em.persist(orderItem);
	     em.getTransaction().commit();
	     em.close();
	 }
	 
	 public void updateOrderItem(long ItermId)
	 {
	  
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  OrderItem orderItem =em.find(OrderItem.class,ItermId);
	  orderItem.setItermId(ItermId);
	  em.getTransaction().commit();
	    
	  }
	 
	 public OrderItem searchOrderItem(long ItermId)
	 {
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  OrderItem orderItem =em.find(OrderItem.class,ItermId);
	  return orderItem;
	  
	  }
	 
	 public void deleteOrderItem(long ItermId)
	 {
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  OrderItem orderItem =em.find(OrderItem.class,ItermId);
	  em.remove(orderItem);
	  em.getTransaction().commit();
	  em.close();
	  
	  }

	 
	 public List< OrderItem> listorderItem(){
	        emf = DbHelper.provideFactory();
	        em = emf.createEntityManager();
	        TypedQuery<OrderItem> query = em.createQuery("SELECT * FROM supply_db.orderitem",  OrderItem.class);
	     List<OrderItem> results = query.getResultList();
	      return results;  
	  }
	
}
