package se.kth.iv1350.POS.view;
import java.util.Scanner;

import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

/**
 *create new view to start a new sale     
 */
public class View {
	private Controller contr;
	Scanner scan = new Scanner(System.in);

	public View(Controller contr) {
		this.contr = contr;
	}
	/**
	 *perform the whole progress of the sale process.    
	 */
	public void runFakeSale() {
		System.out.println("New sale was started.");
		String id;

		id = getNextItemId();

		while(!id.equals("0")) {
			try {	
				boolean isItemExists = contr.isItemExists(id);
				if(isItemExists) {
					contr.addItemToSale(id);
					print(contr.getItemByID(id));
				}
			} 
			catch (DatabaseFailure databaseFailure) {
				databaseFailure.notifyDevloper();
				databaseFailure.notifyUser();
			}
			id = getNextItemId();
		}

		contr.endSale();
		printReciept();
		System.out.println("----------------------------------");
		contr.sendToTax();
		contr.sendToPrintr();
	}

	private String getNextItemId() {
		System.out.println("Enter the item id (to end, enter 0): ");

		String result = scan.nextLine();

		return result;
	}

	private void printReciept() {
		for (ItemDTO item : contr.sale.itemList) {
			print(item);
		}
		if(contr.sale.itemList.size()>0) {
			System.out.println(contr.sale.getDateAndTime());
			System.out.println("total vat: " + contr.sale.vat + "\t" +"Kr");
			System.out.println("total price including vat: " + contr.sale.getPriceAfterVate()+ "\t" +"Kr");

		}

	}

	private void print(ItemDTO itemDto) {
		System.out.print("id:" + itemDto.itemIdentifier + "    ");
		System.out.print("QTY:" + itemDto.getQuantity() + "\t"+ itemDto.name  + "    ");
		System.out.print("VAT:" + itemDto.vatRate+ "    ");
		System.out.println(itemDto.getPrice()+ "Kr");
	}

}
