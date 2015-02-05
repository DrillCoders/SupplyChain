package com.supply;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Customers")
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
 
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="Cust_Id")
private long CustId;

@Column(name="CompName")
private String compName;

@Column(name="Address")
private String Address;

@Column(name="emailAddress")
private String emailAddress;

@Column(name="telNo")
private String telNo;

@Column(name="paymentMethod")
private String paymentMethod;


@ManyToMany (cascade = {CascadeType.ALL})
@JoinTable(name="Customer_Order",
		  joinColumns={@JoinColumn(name="Cust_Id")},inverseJoinColumns={@JoinColumn(name="ITERMID")})
private Set<OrderItem>orders = new HashSet<OrderItem>();


public Customer(){
 
}

public Set<OrderItem> getOrders() {
	return orders;
}

public void setOrders(Set<OrderItem> orders) {
	this.orders = orders;
}

/*public Customer(long custId, String compName, String address,
		String emailAddress, String telNo, String paymentMethod,
		Set<OrderItem> orders) {
	super();
	CustId = custId;
	this.compName = compName;
	Address = address;
	this.emailAddress = emailAddress;
	this.telNo = telNo;
	this.paymentMethod = paymentMethod;
	this.orders = orders;
}*/

public Customer(String compName, String address, String emailAddress,
  String telNo, String paymentMethod) {
 super();
 this.compName = compName;
 Address = address;
 this.emailAddress = emailAddress;
 this.telNo = telNo;
 this.paymentMethod = paymentMethod;
}

/*public Customer(long custId, String compName, String address,
		String emailAddress, String telNo, String paymentMethod
		) {
	super();
	CustId = custId;
	this.compName = compName;
	Address = address;
	this.emailAddress = emailAddress;
	this.telNo = telNo;
	this.paymentMethod = paymentMethod;
	
}*/

public long getCustId() {
 return CustId;
}

public void setCustId(long custId) {
 CustId = custId;
}

public String getCompName() {
 return compName;
}

public void setCompName(String compName) {
 this.compName = compName;
}

public String getAddress() {
 return Address;
}

public void setAddress(String address) {
 Address = address;
}

public String getEmailAddress() {
 return emailAddress;
}

public void setEmailAddress(String emailAddress) {
 this.emailAddress = emailAddress;
}

public String getTelNo() {
 return telNo;
}

public void setTelNo(String telNo) {
 this.telNo = telNo;
}

public String getPaymentMethod() {
 return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
 this.paymentMethod = paymentMethod;
}



}
