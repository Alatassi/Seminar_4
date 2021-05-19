package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.model.DTOs.ItemDTO;
import se.kth.iv1350.POS.model.dbHandler.ItemRegistry;
import se.kth.iv1350.POS.model.extrnalSystem.Tax;
import se.kth.iv1350.POS.model.extrnalSystem.Printer;
import se.kth.iv1350.POS.model.*;


public class Controller {
	public Sale sale;
	public ItemRegistry itemRegistry;

	// Constructor to begin the sale and item registry at the beginning of the startup of the application
	public Controller() {
		this.sale = new Sale();
		this.itemRegistry = new ItemRegistry();

	}
	/**
	 *@param the id of the item  
	 *@return the item using ID   
	 */
	public ItemDTO getItemByID(String id) throws DatabaseFailure {
		try {
			return itemRegistry.getItemByID(id);
		}
		catch(IdentifierDoesNotExist identifierDoesNotExist) {
			identifierDoesNotExist.notifyDevloper();
			identifierDoesNotExist.notifyUser();

		}
		return null;
	}
	/**
	 *@param the id of the item  
	 *add an item to sale   
	 */
	public void addItemToSale(String id) throws DatabaseFailure {
		ItemDTO item = getItemByID(id);
		sale.addItem(item);
	}

	/**
	 *@param the id of the item  
	 *@return the item if the item was found. 
	 */
	public boolean isItemExists(String id) throws DatabaseFailure {
		ItemDTO item = getItemByID(id);
		return item != null;
	}
	/**
	 *this function shows if the receipt sent to successfully to tax or not.
	 */
	public void sendToTax() {
		int sendResult = Tax.sendToTax(sale.getSum().getPriceAfterVat(), sale.vat);
		if(sendResult == 200)
			System.out.println("The reciept is sent successfully to tax");
		else
			System.err.println("Error: cannot send the reciept to tax. The error code: " + sendResult);
	}
	/**
	 *call the function endSale in the class sale to end the sale
	 */
	public void endSale() {
		sale.endSale();
		
	}
	/**
	 *this function shows if the receipt sent successfully to printer or not.
	 */
	public void sendToPrintr() {
		boolean printResult = Printer.print(sale);
		if(printResult)
			System.out.println("Printed");
		else
			System.out.println("Error while printing");
		
	}
}
