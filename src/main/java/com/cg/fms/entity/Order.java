package com.cg.fms.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="order_number")
	private String orderNumber;

	@Column(name="delivery_place")
	private String deliveryPlace;

	@Column(name="delivery_date")
	private String deliveryDate;

	@Column(name="quantity")
	private int quantity;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer1;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_Number")
	private List<Product> product = new ArrayList<Product>();
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Scheduler> scheduler;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Contract> contract;

	
	public Order() {
		
	}


	public Order(String orderNumber, String deliveryPlace, String deliveryDate, int quantity,
			Customer customer1) {
		super();
		this.orderNumber = orderNumber;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.customer1 = customer1;
	}


	public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public String getDeliveryPlace() {
		return deliveryPlace;
	}


	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}


	public String getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Customer getCustomer() {
		return customer1;
	}


	public void setCustomer(Customer customer1) {
		this.customer1 = customer1;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	
	
	
}