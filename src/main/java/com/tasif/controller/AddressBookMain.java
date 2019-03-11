package com.tasif.controller;

import com.tasif.service.AddressBookImplementation;
import com.tasif.service.AddressBookManagerImplementation;
import com.tasif.utility.Utility;

public class AddressBookMain {
	public static void main(String[] args) throws Exception {
		
		AddressBookManagerImplementation addressBookManagerImpl = new AddressBookManagerImplementation();
		String existingAddressBook = "";
		int loop = 0;

		while (loop == 0) {
			AddressBookImplementation addressBook = new AddressBookImplementation();
			System.out.println("\t________________________________________________\n"
					+ "\t Address Book \n"
					+ "\t -------------- \n"
					+ "\t 1. Create new Address Book \n"
					+ "\t 2. Open existing Address Book \n"
					+ "\t 3. Save Address Book \n"
					+ "\t 4. Save As Address Book \n"
					+ "\t 5. Close Address Book \n"  
					+ "\t _______________________________________________\n");
			int choice = Utility.inputInteger();
			switch (choice) {
			case 1:
				addressBookManagerImpl.create();
				addressBookManagerImpl.close(existingAddressBook);
				break;
			case 2:
				addressBookManagerImpl.close(existingAddressBook);
				addressBookManagerImpl.readAddress();
				System.out.println("\n\t Enter the name of the address book\n");
				existingAddressBook = Utility.inputSingleString();
				if (addressBookManagerImpl.checkAddress(existingAddressBook)) {
					System.out.println("\t File Exists\n");

					addressBookManagerImpl.read(existingAddressBook);
					int i = 0;
					while (i == 0) {
						System.out.println("\t ___________________\n"
								+ "\t Menu \n"
								+ "\t ------ \n"
								+ "\t 1. Add \n"
								+ "\t 2. Edit \n"
								+ "\t 3. Remove  \n"
								+ "\t 4. Sort By Name \n"
								+ "\t 5. Sort By Zip \n"
								+ "\t 6. Display \n"
								+ "\t 7. Exit  \n"
								+ "\t __________________");
						int choose = Utility.inputInteger();
						switch (choose) {
						case 1:
							addressBook.add();
							break;
						case 2:
							addressBook.edit();
							break;
						case 3:
							addressBook.remove();
							break;
						case 4:
							addressBook.sortByName();
							break;
						case 5:
							addressBook.sortByZip();
							break;
						case 6:
							addressBook.printAll();
							break;
						case 7:
							System.out.println("\tTraversing to Main Menu");
							i = 1;
							break;
						default:
							System.out.println("\tWrong data recieved\n" + "\tAddress Book named '" + existingAddressBook
									+ "' closed\n");
							addressBook.close(existingAddressBook);
							i = 1;
							break;

						}
					}
				} else {
					System.out.println("\tEntered filename doesn't exist");
				}
				break;
			case 3:
				addressBookManagerImpl.save(existingAddressBook);
				break;
			case 4:
				addressBookManagerImpl.saveAs();
				break;
			case 5:
				System.out.println("\t Closing Address Book...!\n\t Thank You");
				loop = 1;
				break;
			default:
				System.out.println("\t Sorry, Something went wrong...!\n" + "\t Address Book closed\n\t Thank You");
				loop = 1;
				break;
			}
		}
		
		
	}
		
}
