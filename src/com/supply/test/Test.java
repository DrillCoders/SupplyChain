package com.supply.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.Order;



import com.supply.Customer;
import com.supply.OrderItem;
import com.supply.PurchaseOrder;
import com.supply.Stock;
import com.supply.dao.CustomerDao;


public class Test {

	public static void main(String[] args) {
		
		CustomerDao cusdao = new CustomerDao();
		
		Date d = new Date();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("skul");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
	
		
		Customer cust = new Customer("Shopryt","belville","shopryt@com","01156778","cash");
		OrderItem ord = new OrderItem(500,"cloth",d);
		Stock stk = new Stock("toilatry",2000,50000,50);
		PurchaseOrder pco = new PurchaseOrder(d, "processing", d);
		
		
		cust.getOrders().add(ord);
		stk.getPurchaseOrder().add(pco);
		//cusdao.SaveCustomer(cust);
		
		

		cusdao.serchCustomer(2);
		System.out.println(cust.getCompName() + " " + cust.getEmailAddress());

		/*System.out.println("");
		System.out
				.println("***********************************DELETING*******************************");
		System.out.println("");

		cusdao.deleteCustomer(1);
*/
		/*System.out.println("");
		System.out
				.println("************************************RETRIEVING EVERYTING******************************");
		System.out.println("");

		List<Employee> list = empDAO.getAllEmployees();

		for (Employee empl : list) {

			System.out.println(empl.getFirstName() + " " + empl.getLastName());
			
			
			BookDao dao = null;
		dao = new BookDao();
		Book book = new Book("knockout", "mr ndou", "knockout will knock u put", 9.8);
		dao.SaveBook(book);
		//dao.listBooks();
		System.out.println("done");
		}*/

		

	
		
		//em.persist(cusdao);
		em.persist(cust);
		em.persist(ord);
		em.persist(stk);
		em.persist(pco);
		em.getTransaction().commit();
		
		System.out.println("");
		System.out
				.println("***************************************DONE.......***************************");
		System.out.println("");
		
		}

}
