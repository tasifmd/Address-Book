package com.tasif.service;

import java.io.File;
import java.io.IOException;

import com.tasif.utility.Utility;

public class AddressBookManagerImplementation {
	public void create() {
		System.out.println("\tEnter the name of address book");
		String newAddressBookName = Utility.inputSingleString();
		File file = new File("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/" + newAddressBookName + ".json");
		try {
			if (file.createNewFile()) {
				System.out.println("\tFile is created!");
			} else {
				System.out.println("\tFile already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void save(String file) {
		AddressBookImplementation abi = new AddressBookImplementation();
		abi.save(file);

	}
	
	public void read(String existingAddressBook) throws Exception {
		AddressBookImplementation abi = new AddressBookImplementation();
		abi.read(existingAddressBook);
	}
	
	public void readAddress() {
		File f = new File("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println("\n\t\t\t"+file.getName());
				count++;
			}
		}
		System.out.println("\n\t\t\tNumber of files: " + count);
	}
	
	public boolean checkAddress(String existingAddressBook) {
		File f = new File("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/");
		File[] fileArray = f.listFiles();
		int count = 0;
		/*for(int i = 0 ; i < fileArray.length ; i++) {
			if(fileArray[i].isFile()) {
				fileArray[i].getName().equals(existingAddressBook + ".json");
				count++;
				break;
			}
		} */
		
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(existingAddressBook + ".json")) {
					count++;
					break;
				}
			}
		}
		
		if (count == 1)
			return true;
		else
			return false;
	}
	
	public void saveAs() {
		AddressBookImplementation abi = new AddressBookImplementation();
		abi.saveAs();

	}

	public void close(String existingAddressBook) {
		AddressBookImplementation abi = new AddressBookImplementation();
		abi.close(existingAddressBook);

	}
}
