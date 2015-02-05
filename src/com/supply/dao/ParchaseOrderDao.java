package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.PurchaseOrder;
import com.supply.Stock;
import com.supply.db.helper.DbHelper;

public class ParchaseOrderDao {

	EntityManagerFactory emf=null;
	 EntityManager em= null;
	 
	 
	 public void savePurchaseOrder(PurchaseOrder order)
	 {
	  emf=DbHelper.provideFactory();
	     em=emf.createEntityManager();
	     em.getTransaction().begin();
	     em.persist(order);
	     em.getTransaction().commit();
	     em.close();
	 }
	 
	 public void updatePurchaseOrder(int purchaseId)
	 {
	  
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  PurchaseOrder order=em.find(PurchaseOrder.class,purchaseId);
	  order.setPurchaseId(purchaseId);
	  em.getTransaction().commit();
	    
	  }
	 
	 public PurchaseOrder searchPurchaseOrder(int  purchaseId)
	 {
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  PurchaseOrder order=em.find(PurchaseOrder.class,purchaseId);
	  return order;
	  
	  }
	 	 
	 public List<PurchaseOrder> listPurchaseOrder(){
	        emf = DbHelper.provideFactory();
	        em = emf.createEntityManager();
	        TypedQuery<PurchaseOrder> query = em.createQuery("SELECT * FROM supply_db.tblstock", PurchaseOrder.class);
	     List<PurchaseOrder> results = query.getResultList();
	      return results;  
	  }
	
}
