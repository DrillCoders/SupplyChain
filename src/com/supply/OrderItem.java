package com.supply;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ORDERITEM")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="ITERMID")
 private long ItermId;
 
 @Column(name="ITEMQUANTITY")
 private long ItemQuantity;
 
 @Column(name="ITEMDESCRIPTION")
 private String Itemdescription;
 
 @Column(name="ITEMDATE")
 private Date Itemdate;
 
 @ManyToMany(mappedBy = "orders") 
  private Set<Customer>customer = new HashSet<Customer>();

 
 public Set<Customer> getCustomer() {
	return customer;
}

public void setCustomer(Set<Customer> customer) {
	this.customer = customer;
}

public OrderItem(long itermId, long itemQuantity, String itemdescription,
		Date itemdate, Set<Customer> customer) {
	super();
	ItermId = itermId;
	ItemQuantity = itemQuantity;
	Itemdescription = itemdescription;
	Itemdate = itemdate;
	this.customer = customer;
}

public OrderItem(long itermId, long itemQuantity, String itemdescription,
		Date itemdate) {
	super();
	ItermId = itermId;
	ItemQuantity = itemQuantity;
	Itemdescription = itemdescription;
	Itemdate = itemdate;
	
}

public OrderItem() {
  
 }

 public OrderItem( long itemQuantity, String itemdescription,
   Date itemdate) {
	 
  ItemQuantity = itemQuantity;
  Itemdescription = itemdescription;
  Itemdate = itemdate;
 }

 public long getItermId() {
  return ItermId;
 }

 public void setItermId(long itermId) {
  ItermId = itermId;
 }

 public long getItemQuantity() {
  return ItemQuantity;
 }

 public void setItemQuantity(long itemQuantity) {
  ItemQuantity = itemQuantity;
 }

 public String getItemdescription() {
  return Itemdescription;
 }

 public void setItemdescription(String itemdescription) {
  Itemdescription = itemdescription;
 }

 public Date getItemdate() {
  return Itemdate;
 }

 public void setItemdate(Date itemdate) {
  Itemdate = itemdate;
 }
 
 
}
