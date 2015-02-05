package com.supply.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.supply.Customer;
import com.supply.dao.CustomerDao;


@Path("/customerService")
public class CustomerService {
	
	CustomerDao custDao = new CustomerDao();
	
	 @POST
		@Path(value = "/save")
	    @Consumes(MediaType.APPLICATION_JSON)
		public Response saveCustomer(Customer customer){
	   
	    	custDao.SaveCustomer(customer);
	    	
			return Response.status(Status.CREATED).build();
		}
		
		@PUT
		@Path(value = "/update")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateCustomer(Long custId){
			custDao.updateCustomer(custId);
			return Response.status(201).build();
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/customerList")
		public List<Customer> AllCustomer() 
		{
			
			return custDao.listCustomer();
		}

		@Path("{departmentId}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public String searchCustomer(int CustId) throws JSONException
		{
			Customer customer = new Customer();
			customer = custDao.serchCustomer(CustId);
			JSONObject customerObject = new  JSONObject();
			customerObject.put("", customer);
			
			return customerObject.toString();
		}
		
}
