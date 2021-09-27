package com.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class FeesStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String department;
	private double totalAmount;
	private double paidAmount;
	private double remainAmount;
	
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getRemainAmount() {
		return remainAmount;
	}
	public void setRemainAmount(double remainAmount) {
		this.remainAmount = remainAmount;
	}
	public FeesStructure(int id, String name, String department, double totalAmount, double paidAmount,
			double remainAmount , String status) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.remainAmount = remainAmount;
		this.status = status;
	}
	public FeesStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
