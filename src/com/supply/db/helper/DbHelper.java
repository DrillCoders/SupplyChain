/**
 * 
 */
package com.supply.db.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author 
 *
 */
public class DbHelper {
	
	private static final EntityManagerFactory entityManagerFactory = produceObj();

	private static EntityManagerFactory produceObj() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("skul");
		
		return entityManagerFactory;
	}
	public static EntityManagerFactory provideFactory(){
		
		return entityManagerFactory;
		
		
	}
}
