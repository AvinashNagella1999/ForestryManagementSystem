package com.cg.fms.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="schedulers")
public class Scheduler {
	@Id
	@Column(name="scheduler_id")
	private String schedulerId;
	
	@Column(name="scheduler_Name", nullable=false)
	private String schedulerName;
	
	@Column(name="scheduler_contact", nullable=false)
	private String schedulerContact;

	@Column(name="truck_number", nullable=false)
	private String truckNumber;
	
	
	@OneToMany(mappedBy="scheduler",cascade = CascadeType.ALL)
	private Set<Contract> contracts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_number")
	private Order order;
	
	public Scheduler() {
		
	}

	public Scheduler(String schedulerId, String schedulerName, String schedulerContact, String truckNumber,
			Order order) {
		super();
		this.schedulerId = schedulerId;
		this.schedulerName = schedulerName;
		this.schedulerContact = schedulerContact;
		this.truckNumber = truckNumber;
		this.order = order;
	}

	public String getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(String schedulerId) {
		this.schedulerId = schedulerId;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getSchedulerContact() {
		return schedulerContact;
	}

	public void setSchedulerContact(String schedulerContact) {
		this.schedulerContact = schedulerContact;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

	
}