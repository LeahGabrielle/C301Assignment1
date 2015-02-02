package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmountCurrency implements Serializable{
	//this class combines Amount and Currency into one for Item
	private static final long serialVersionUID = 6124147205526464963L;
	
	public BigDecimal amount;
	public String currency;
	
	public AmountCurrency(BigDecimal amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}
	public AmountCurrency(){
		super();
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
