package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.POS.model.DTOs.Amount;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;
public class ItemDTOTest {
	ItemDTO itemTest;
	
	@Before 
    public void init() {
		itemTest = new ItemDTO("Cola",10, 0.12, "7");
    }
	
	@Test
	public void testItemDTO() {
		assertEquals("Cola", itemTest.name);
		assertEquals("7", itemTest.itemIdentifier);
		assertEquals(0.12, itemTest.vatRate, 0);
		
		assertEquals(10, itemTest.getPrice());
	}

	@Test
	public void testGetName() {
		String actual = itemTest.getName();
		String expcted = "Cola";
		assertEquals(expcted, actual);
	}

	@Test
	public void testGetPriceAfterVat() {
		double actual = itemTest.getPriceAfterVat();
		double expcted = 10.12;
		assertEquals(expcted, actual, 0);
	}

	@Test
	public void testGetVateRate() {
		double actual = itemTest.getVateRate();
		double expcted = 0.12;
		assertEquals(expcted, actual, 0);
	}

	@Test
	public void testGetItemIdentifier() {
		String actual = itemTest.getItemIdentifier();
		String expcted = "7";
		assertEquals(expcted, actual);
	}
}
