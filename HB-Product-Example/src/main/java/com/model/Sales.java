package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Sales {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column (name ="SINO")
	 private int SINO;
	 @Column (name ="pname")
	 private String pname;
	 @Column (name ="qty")
	 private int qty;
	 @Column (name ="price")
	 private float price;
	 public Sales(int sINO, String pname, int qty, float price) {
		super();
		SINO = sINO;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	 
	 public int getSINO() {
		return SINO;
	}
	public void setSINO(int sINO) {
		SINO = sINO;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	 
	 
    public Sales() {

}
}