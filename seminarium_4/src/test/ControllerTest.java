package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.DatabaseFailure;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public class ControllerTest {
	Controller contoller;
	
	@Before 
    public void init() {
		contoller = new Controller();
		try {
			contoller.addItemToSale("1");
		} catch (DatabaseFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Test
	public void testController() {
		int expected = 3;
		int actual = contoller.itemRegistry.items.size();
		assertEquals(expected, actual);
		
		expected = 1;
		actual = contoller.sale.itemList.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetItemByID() {
		ItemDTO item;
		try {
			item = contoller.getItemByID("1");
			String expected = "1";
			String actual = item.itemIdentifier;
			assertEquals(expected, actual);
		} catch (DatabaseFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	@Test
	public void testAddItemToSale() {
		try {
			contoller.addItemToSale("3");
		} catch (DatabaseFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expected = "3";
		String actual = contoller.sale.itemList.get(1).itemIdentifier;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsItemExists() {
		boolean actual;
		try {
			actual = contoller.isItemExists("3");
			boolean expected = true;
			assertEquals(expected, actual);
			
		} catch (DatabaseFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			actual = contoller.isItemExists("4");
			boolean expected = false;
			assertEquals(expected, actual);
		} catch (DatabaseFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
