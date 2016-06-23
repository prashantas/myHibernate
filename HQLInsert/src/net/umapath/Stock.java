package net.umapath;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Stock {
	
	private int stockId;
	
	private int price;
	
	private String stockName;

	public Stock()
	{
	super();
	}

	public Stock(int stockId, int price, String stockName) {
		super();
		this.stockId = stockId;
		this.price = price;
		this.stockName = stockName;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	

}
