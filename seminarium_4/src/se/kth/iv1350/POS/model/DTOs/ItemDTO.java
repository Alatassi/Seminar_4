package se.kth.iv1350.POS.model.DTOs;

/**
 * 
 *all items attributes 
 */
public class ItemDTO {
	public String name ;
	public double price;
	public double vatRate;
	public String itemIdentifier;
	private int quantity = 1;

	public void increaseQuantity () {
		quantity ++;
	}
	/**
	 * creates a new instance representing a new item; 
	 * @param  name      		the name of an item
	 * @param  price     		the price of an item
	 * @param  vatRate 	 		the rate of VAT in percent for every item
	 * @param  itemIdentifier 	the identification of an item  
	 */
	public ItemDTO(String name, double price, double vatRate, String itemIdentifier) {
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.itemIdentifier = itemIdentifier;
	}

	/**
	 * returns the name of an item 
	 *@return the name of an item  
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * returns the price of an item 
	 *@return the name of an item  
	 */
	public double getPrice() {
		return this.price * quantity;
	}
	/**
	 * @return the total tax.
	 */
	public double getTotalVate() {
		return getPrice() * vatRate; 
	}
	/**
	 * returns the VAT Rate of an item 
	 *@return the VAT rate of an item  
	 */
	public double getVateRate() {
		return this.vatRate;
	}

	/**
	 * returns the identification of an item 
	 *@return the identification of an item  
	 */
	public String  getItemIdentifier() {
		return this.itemIdentifier;
	}

	/**
	 * returns the price according VAT
	 * @return amount of money
	 */
	public double getPriceAfterVat() {
		return this.price * (1.0 + this.vatRate) * quantity;
	}
	/**
	 *prints item parameter    
	 */
	public int getQuantity() {
		return quantity;
	}
}
