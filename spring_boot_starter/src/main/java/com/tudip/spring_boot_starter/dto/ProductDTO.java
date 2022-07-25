package com.tudip.spring_boot_starter.dto;

import java.util.Date;

public class ProductDTO 
{
	private long id;
	private String name;
	private long price;
	private Date expiredate;
	private Date manufacturedate;
    private long quantity;
	public ProductDTO(long id, String name, long price, Date expiredate, Date manufacturedate, long quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.expiredate = expiredate;
		this.manufacturedate = manufacturedate;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Date getExpiredate() {
		return expiredate;
	}
	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
	}
	public Date getManufacturedate() {
		return manufacturedate;
	}
	public void setManufacturedate(Date manufacturedate) {
		this.manufacturedate = manufacturedate;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


}
