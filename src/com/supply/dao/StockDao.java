package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;



import com.supply.Stock;
import com.supply.db.helper.DbHelper;

public class StockDao {

	 EntityManagerFactory emf=null;
	 EntityManager em= null;
	 
	 
	 public void saveStock(Stock stock)
	 {
	  emf=DbHelper.provideFactory();
	     em=emf.createEntityManager();
	     em.getTransaction().begin();
	     em.persist(stock);
	     em.getTransaction().commit();
	     em.close();
	 }
	 
	 public void updateStock(Long StockId)
	 {
	  
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  Stock stock=em.find(Stock.class,StockId);
	  stock.setStockId(StockId);
	  em.getTransaction().commit();
	    
	  }
	 
	 public Stock searchStock(Long StockId)
	 {
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  Stock stock=em.find(Stock.class,StockId);
	  return stock;
	  
	  }
	 
	 public void deleteStock(Long StockId)
	 {
	  emf=DbHelper.provideFactory();
	  em=emf.createEntityManager();
	  em.getTransaction().begin();
	  Stock stock=em.find(Stock.class,StockId);
	  em.remove(stock);
	  em.getTransaction().commit();
	  em.close();
	  
	  }

	 
	 public List<Stock> listStock(){
	        emf = DbHelper.provideFactory();
	        em = emf.createEntityManager();
	        TypedQuery<Stock> query = em.createQuery("SELECT * FROM supply_db.tblstock", Stock.class);
	     List<Stock> results = query.getResultList();
	      return results;  
	  }
	
}
