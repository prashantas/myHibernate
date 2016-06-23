package net.umapath;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("Ow")
public class Owner extends Person {

	@Column(name="stocks")
	private Long stocks;
	
	@Column(name="partnership_stake")
	private Long partnershipStake;

	public Owner() {
	}
	/*public Owner(String firstname, String lastname)
	{
		super(firstname, lastname);
	}*/
	public Owner(String firstname, String lastname, Long stocks, Long partnershipStake) {
		
		super(firstname, lastname);
		
		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}

	/*public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getPartnershipStake() {
		return partnershipStake;
	}

	public void setPartnershipStake(Long partnershipStake) {
		this.partnershipStake = partnershipStake;
	}
	*/
}
