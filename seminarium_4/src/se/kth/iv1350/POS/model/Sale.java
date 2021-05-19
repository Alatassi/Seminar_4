package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.POS.model.DTOs.Amount;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;
/**
 * make new instance of sale    
 */
public class Sale {
	public List<ItemDTO> itemList;
	private String dateAndTime;
	public Sale() {
		itemList = new ArrayList<>();
		dateAndTime = LocalDateTime.now().toString();

	}
	/**
	 *@return the time for the printed receipt
	 */
	public String getDateAndTime() {
		return dateAndTime;
	}
	/**
	 * add item to the receipt 
	 * @param item to be added to receipt 
	 */
	public void addItem(ItemDTO item) {
		for (ItemDTO itemDto: itemList) {
			if (itemDto.getItemIdentifier().equals(item.getItemIdentifier())) {
				itemDto.increaseQuantity();
				return;
			}
		}
		itemList.add(item);

	}

	/** 
	 *@return the total price of all items in the receipt  
	 */
	public ItemDTO getSum() {
		double finalPrice = 0;
		for (ItemDTO item : itemList) {
			finalPrice += item.getPriceAfterVat();
		}
		return new ItemDTO("total", finalPrice, 1, "total");
	}

	/**
	 *@return prints all items in the receipt in addition to the total price
	 */
	private double priceAfterVate = 0;
	public double vat = 0.00;
	/**
	 *@return the final tax.
	 *@return the price after tax.
	 */
	public void endSale() {
		setFinalVat();
		setPriceAfterVate();
	}
	/**
	 * Sets the final vat.
	 */
	private void setFinalVat() {
		for (ItemDTO item : itemList) {
			vat += item.getTotalVate();
		}
	}
	/**
	 * Sets the price after tax.
	 */
	private void setPriceAfterVate() {
		for(ItemDTO item : itemList) {
			this.priceAfterVate += item.getPriceAfterVat();
		}
	}
	
	/**
	 *@return the price after vat.
	 */
	public double getPriceAfterVate() {
		return priceAfterVate;
	}
	
}
