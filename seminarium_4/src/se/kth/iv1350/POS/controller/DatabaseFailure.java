package se.kth.iv1350.POS.controller;

@SuppressWarnings("serial")
public class DatabaseFailure extends Exception {

	String hardcodedIdentifier;
	/**
	 * @param hardcodedIdentifier when there is a connection failure with the database.
	 */
	public DatabaseFailure(String hardcodedIdentifier) {
		super(hardcodedIdentifier + " Is hardcoded identifier");
		this.hardcodedIdentifier = hardcodedIdentifier;

	}
	/**
	 * Notify the user with a message.
	 */
	public void notifyUser() {
		System.out.println("The item "+ hardcodedIdentifier +  " is hardcoded, enter the item (number id)");
	}
	/**
	 * Notify the developer with a message.
	 */
	public void notifyDevloper() {
		this.printStackTrace();
	}
	
	
}
