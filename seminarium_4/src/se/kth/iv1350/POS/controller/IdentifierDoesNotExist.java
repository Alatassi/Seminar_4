package se.kth.iv1350.POS.controller;

@SuppressWarnings("serial")
public class IdentifierDoesNotExist extends Exception {
	
	String invalidIdentifier;
		/**
		 * @param invalidIdentifier the item identifier that does not exist
		 */
		public IdentifierDoesNotExist(String invalidIdentifier) {
			super(invalidIdentifier + " The inserted item doesn't exist");
			this.invalidIdentifier = invalidIdentifier;

		}
		/**
		 * notify the user with a message.
		 */
		public void notifyUser() {
			System.out.println("The item "+ invalidIdentifier +  " were not found");
		}
		
		/**
		 * notify the developer with a message.
		 */
		public void notifyDevloper() {
			this.printStackTrace();
		}
	}

