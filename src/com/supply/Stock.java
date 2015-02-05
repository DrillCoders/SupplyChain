package com.supply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tblStock")
@XmlRootElement(name = "tblstock")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Stock_Id")
	private Long stockId;
	@Column(name = "Description")
	private String description;
	@Column(name = "Unit_Price")
	private double unitPrice;
	@Column(name = "Total_Price")
	private double totalPrice;
	@Column(name = "Quantinty")
	private int quantity;
	
	 @ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(name="tblpurchaseorder_stock",
		joinColumns={@JoinColumn(name="Stock_Id")},inverseJoinColumns={@JoinColumn(name="purchaseid")})
	private Set<PurchaseOrder>purchaseOrder=new HashSet<PurchaseOrder>();
	
	public Stock() {
		super();
		
	}
	
	public Stock(String description, double unitPrice, double totalPrice,
			int quantity) {
		super();
		this.description = description;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		
	}

	public Set<PurchaseOrder> getPurchaseOrder() {
		return purchaseOrder;
	}

public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}


	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
