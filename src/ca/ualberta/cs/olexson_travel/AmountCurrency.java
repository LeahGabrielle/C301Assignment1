package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmountCurrency implements Serializable{
	
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
	
}
