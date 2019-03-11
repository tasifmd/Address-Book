package com.tasif.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tasif.model.Address;
import com.tasif.model.Person;
import com.tasif.utility.Utility;

public class AddressBookImplementation {
	public static List<Person> list = new ArrayList<Person>();
	ObjectMapper mapper = new ObjectMapper();
	static int count = 0;
	
	public List<Person> add() {
		list.add(addUser());
		for (Person P : list) {
			System.out.println(P.toString());
		}
		return list;
	}

	public void edit() {
		System.out.println("\n\tEnter first name");
		String firstName = Utility.inputSingleString();
		for (Person P : list) {
			if (firstName.equals(P.getFirstName())) {
				count++;
				System.out.println("\n\tData found\n");
				System.out.println("\t1. To edit Address\n" + "\t2. To edit Phone Number\n");
				int editChoice = Utility.inputInteger();
				switch (editChoice) {
				case 1:
					editAddressPhone(P, 1);
					break;
				case 2:
					editAddressPhone(P, 2);
					break;
				default:
					System.out.println("\tSomething went wrong\n" + "\t\t\tTry again later");
				}
			} 
		}
		if(count==0)
			System.out.println("\n\tData not found");

	}

	public void remove() throws Exception {
		System.out.println("\n\tEnter first name whose data is to be removed");
		String firstName = Utility.inputSingleString();
		int count = 0;
		List<Person> toRemove = new ArrayList<Person>();
		for (Person P : list) {
			if (firstName.equals(P.getFirstName())) {
				System.out.println("\n\tData found\n\n\tData Removed");
				toRemove.add(P);
				count++;
			}
		}
		list.removeAll(toRemove);
		if (count == 0)
			System.out.println("\n\tSorry, no such data found");

	}

	public void sortByName() {
		Collections.sort(list, new SortByName());
		for (Person person : list) {
			System.out.println(person.toString());
		}

	}

	public void sortByZip() {
		Collections.sort(list, new SortByZip());
		for (Person person : list) {
			System.out.println(person.toString());
		}

	}

	public void printAll() {
		for (Person P : list) {
			System.out.println(P.toString());
		}

	}
	
	public Person addUser() {
		Person person = new Person();
		Address address = new Address();
		System.out.println("\n\tEnter First Name");
		person.setFirstName(Utility.inputSingleString());
		//System.out.println((person.getFirstName()));
		System.out.println("\n\tEnter Last Name");
		person.setLastName(Utility.inputSingleString());
		System.out.println("\n\tEnter city");
		address.setCity(Utility.inputSingleString());
		System.out.println("\n\tEnter State");
		address.setState(Utility.inputSingleString());
		System.out.println("\n\tEnter ZipCode");
		address.setZip(Utility.inputInteger());
		System.out.println("\n\tEnter Phone Number");
		person.setPhoneNumber(Utility.inputSingleString());
		person.setAddress(address);
		return person;
	}
	
	private void editAddressPhone(Person P, int i) {
		switch (i) {
		case 1:
			System.out.println("\n\tEnter the state");
			P.address.setState(Utility.inputSingleString());
			System.out.println("\n\tEnter the city");
			P.address.setCity(Utility.inputSingleString());
			System.out.println("\n\tEnter the ZipCode");
			P.address.setZip(Utility.inputLong());
			System.out.println("\n\tNew Address updated");
			break;
		case 2:
			System.out.println("\n\tEnter the new Phone Number");
			String phoneNumber = Utility.inputSingleString();
			P.setPhoneNumber(phoneNumber);
			System.out.println("\n\tNew Phone Number updated ");
			break;
		}
	}
	
	public void save(String file) {
		try {
			mapper.writeValue(new File("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/" + file + ".json"), list);
			System.out.println("\n\tSaved");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveAs(String file) {
		try {
			mapper.writeValue(new File("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/" + file + ".txt"), list);
			System.out.println("\n\tSaved as" + file + ".txt");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void read(String existingAddressBook) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		//try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/admin1/eclipse-workspace/tasif/oops/AddressBok/src/main/java/myfiles/" + existingAddressBook + ".json"));
			String arrayToJson;
			if ((arrayToJson = reader.readLine()) != null) {
				TypeReference<ArrayList<Person>> type = new TypeReference<ArrayList<Person>>() {};
				list = (List<Person>) objectMapper.readValue(arrayToJson, Person.class);
				//list = objectMapper.readValue(arrayToJson, type);
				reader.close();
			}
		/*} catch (IOException e) {
			e.printStackTrace();
		}*/


	}

	public void close(String existingAddressBook) {
		list.clear();
	}
	
	public void saveAs() {
		System.out.println("\n\tEnter the name of the new file");
		String fileNameNew = Utility.inputSingleString();
		saveAs(fileNameNew);
		System.out.println("\n\tData saved in new file");
	}
}
