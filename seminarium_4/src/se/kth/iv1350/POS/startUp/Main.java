/**
 * Author: M Rami Alsaid Suliman
 * Date: may 5th 2021
 */

package se.kth.iv1350.POS.startUp;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.DatabaseFailure;
import se.kth.iv1350.POS.view.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 * change the comment in main 
	 * @throws DatabaseFailure 
	 */
	public static void main(String[] args) throws DatabaseFailure {
		Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeSale();
	}

}
