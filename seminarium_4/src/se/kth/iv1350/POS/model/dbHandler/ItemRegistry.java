package se.kth.iv1350.POS.model.dbHandler;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.POS.controller.DatabaseFailure;
import se.kth.iv1350.POS.controller.IdentifierDoesNotExist;
import se.kth.iv1350.POS.model.DTOs.*;

/**
 *creates a new instance of the item registry     
 */
public class ItemRegistry {
	public List<ItemDTO> items = new ArrayList<>();
	private static final double SOMEAMOUNT = (10);
	private static final double SOMEOTHERAMOUNT = (15);
	private static final double ANOTHERAMOUNT =  (58);
	private static final double VAT06PERCENT = 0.06;
	private static final double VAT02PERCENT = 0.02;
	private static final double VAT04PERCENT = 0.04;
	private static final String FIRSTITEMIDENTIFIER = "1";
	private static final String SECONDITEMIDENTIFIER = "2";
	private static final String THIRDITEMIDENTIFIER = "3";



	public ItemRegistry(){
		addItem();
	}
	/**
	 *initiates default items   
	 */
	public void addItem() {
		items.add(new ItemDTO("milk", SOMEAMOUNT, VAT06PERCENT, FIRSTITEMIDENTIFIER));
		items.add(new ItemDTO("cocacola", SOMEOTHERAMOUNT,VAT02PERCENT, SECONDITEMIDENTIFIER));
		items.add(new ItemDTO("cigarette", ANOTHERAMOUNT, VAT04PERCENT, THIRDITEMIDENTIFIER));

	}
	/**
	 *@param the id of the item  
	 *@return the corresponding item    
	 * @throws IdentifierDoesNotExist 
	 * if the item does not found (exist in the inventory)
	 * @throws DatabaseFailure 
	 *  if the connection with the database was failed. 
	 */
	public ItemDTO getItemByID(String id) throws IdentifierDoesNotExist, DatabaseFailure {
		for (ItemDTO item : items) {
			if (item.getItemIdentifier().equals(id))
				return item;
		}
	

		if (!id.equals("milk") && !id.equals("cocacola") && !id.equals("cigarette")) {
			throw new IdentifierDoesNotExist(id);
		}
		else {
			throw new DatabaseFailure(id);
		}
	}
}
