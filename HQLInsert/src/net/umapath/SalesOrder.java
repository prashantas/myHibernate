package net.umapath;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class SalesOrder {

	
	private int id;
	
	private int price;
	
	private String purchaser;
	
	private int stockId;

	public SalesOrder()
	{

	}

	public SalesOrder(int id, int price, String purchaser, int stockId) {
		super();
		this.id = id;
		this.price = price;
		this.purchaser = purchaser;
		this.stockId = stockId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	
	
	
	
	
}
