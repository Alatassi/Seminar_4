package se.kth.iv1350.POS.model.DTOs;
/** 
 * contains the amount of money and the currency 
 */
public class Amount {
	public String currency;
	public int amount;
	/**
	 * creates an instance of Amount
	 * @param amount    the amount of money
	 * @param currency  the currency of money
	 */
	public Amount (int amount, String currency) {
		this.currency = currency;
		this.amount =  amount;
	}
	/**
	 * @return amount of money
	 */
	public int getAmount() {
		return this.amount;
	}
	/** 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

}
